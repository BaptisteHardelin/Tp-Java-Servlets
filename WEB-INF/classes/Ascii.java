import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet-Ascii")
public class Ascii extends HttpServlet {

    public void service( HttpServletRequest req, HttpServletResponse res )
    throws ServletException, IOException
    {
      res.setContentType("text/html;");
      PrintWriter out = res.getWriter();
      out.println( "<head><title>servlet Ascii</title>" );
      out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );

      out.println( "<h1>Table Ascii</h1>");
      out.println("<table>");

      for(int i = 32; i < 255; i++) {
        out.println("<tr>");
          for(int j = 1; j < 2; j++) {
            out.println("<td>"+(char) i + "</td>");
            out.println("<td>" + i + "</td>");
          }
          out.println("</tr>");
      }


      out.println("</table>");

      out.println( "</center> </body>" );
    }
}

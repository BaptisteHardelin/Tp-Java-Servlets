import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/fibo")
public class Fibonacci extends HttpServlet {

    public int fib(int n) {
        if( n <= 0 ) {
			return 0;
		} else if( n == 1 ) {
			return 1;
		}
		return ( fib( n - 1 )+ fib( n - 2 ));
    }

    public void service( HttpServletRequest req, HttpServletResponse res )
    throws ServletException, IOException
    {
      res.setContentType("text/html;charset=UTF-8");
      PrintWriter out = res.getWriter();
      out.println( "<head><title>servlet first</title>" );
      out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
      out.println( "<h1>Test de ma Servlet Fibonnaci</h1>");
      out.println( "<p>Fibo :");
      for(int i = 1; i <= 30; i++) {
          out.println(fib(i));
      }
      out.print("</p>");
      out.println( "</center> </body>" );
    }
}

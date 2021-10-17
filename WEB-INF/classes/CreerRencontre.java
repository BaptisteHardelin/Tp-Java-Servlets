import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/CreerRencontres")
public class CreerRencontre extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res )
  throws ServletException, IOException
  {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println( "<head><title>servlet CreerRencontres</title>" );
    out.println( "<style>td{height:25px;width:50px;}</style>" );
    out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );

    try {

    // enregistrement du driver
    Class.forName("org.h2.Driver");
    // connexion Ã  la base
    String url = "jdbc:h2:tcp://localhost:9092/D:\\DataBase";
    String nom = "sa";
    String mdp = "";
    Connection con = DriverManager.getConnection(url,nom,mdp);

    int num_match = 0;
    int eq1 = 0;
    int eq2 = 0;
    String jour = "";
    int sc1 = 0;
    int sc2 = 0;

    if(req.getParameter("num") != null && req.getParameter("eq1") != null 
    && req.getParameter("eq2") != null && req.getParameter("j") != null 
    && req.getParameter("sc1") != null && req.getParameter("sc2") != null) {
      num_match = Integer.parseInt(req.getParameter("num"));
      eq1 = Integer.parseInt(req.getParameter("eq1"));
      eq2 = Integer.parseInt(req.getParameter("eq2"));
      jour = req.getParameter("j");
      sc1 = Integer.parseInt(req.getParameter("sc1"));
      sc2 = Integer.parseInt(req.getParameter("sc2"));
    }

    String query = "";
    if(req.getParameter("num") != null && req.getParameter("eq1") != null 
    && req.getParameter("eq2") != null && req.getParameter("j") != null 
    && req.getParameter("sc1") != null && req.getParameter("sc2") != null){
        query = "insert into RENCONTRES values(" + num_match + "," 
        + eq1 + "," + eq2 + "," + jour + "," + sc1 + "," + sc2 +")";
        System.out.println("query : " + query);
    }
    
    PreparedStatement ps = con.prepareStatement(query);
    ps.executeUpdate();

    out.println("<h1>Servlet CreerRencontres</h1>");

    out.println("<form action=CreerRencontres method=post>");
    out.println("<input type=\"text\" name=num value=\"num_match\">");
    out.println("<br />");
    out.println("<input type=\"text\" name=eq1 value=\"eq1\">");
    out.println("<br />");
    out.println("<input type=\"text\" name=eq2 value=\"eq2\">");
    out.println("<br />");
    out.println("<input type=\"text\" name=j value=\"jour\">");
    out.println("<br />");
    out.println("<input type=\"text\" name=sc1 value=\"sc1\">");
    out.println("<br />");
    out.println("<input type=\"text\" name=sc2 value=\"sc2\">");
    out.println("<br />");
    out.println("<input type=\"submit\" value=\"submit\">");
    out.println("<br />");
    out.println("</form>");

    out.println("<p>" + num_match + "</p>");
    out.println("<p>" + eq1 + "</p>");
    out.println("<p>" + eq2 + "</p>");
    out.println("<p>" + jour + "</p>");
    out.println("<p>" + sc1 + "</p>");
    out.println("<p>" + sc2 + "</p>");

    // fermeture de la connexion
    con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    out.println( "</center> </body>" );
  }
}
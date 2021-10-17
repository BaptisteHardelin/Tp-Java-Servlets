import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;

@WebServlet("/ListeRencontres")
public class ListeRencontres extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res )
  throws ServletException, IOException
  {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println( "<head><title>servlet ListeRencontres</title>" );
    out.println( "<style>td{height:25px;width:50px;}</style>" );
    out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );

    try {

    // enregistrement du driver
    Class.forName("org.h2.Driver");
    // connexion à la base
    String url = "jdbc:h2:tcp://localhost:9092/D:\\DataBase";
    String nom = "sa";
    String mdp = "";
    Connection con = DriverManager.getConnection(url,nom,mdp);
    String query = "SELECT * FROM RENCONTRES";
    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();

    out.print("<h1>Table Rencontres</h1>");
    out.println ("<table>");
    out.println("<th>NUM_MATCH</th>");
    out.println("<th>EQ1</th>");
    out.println("<th>EQ2</th>");
    out.println("<th>JOUR</th>");
    out.println("<th>SC1</th>");
    out.println("<th>SC2</th>");

    while(rs.next()) {
        int numMatch = rs.getInt("NUM_MATCH");
        int eq1 = rs.getInt("EQ1");
        int eq2 = rs.getInt("EQ2");
        Date jour = rs.getDate("JOUR");
        int sc1 = rs.getInt("SC1");
        int sc2 = rs.getInt("SC2");

        out.println("<tr>");
        out.println("<td> " + numMatch +" <td>");
        out.println("<td> " + eq1 +" <td>");
        out.println("<td> " + eq2 +" <td>");
        out.println("<td> " + jour +" <td>");
        out.println("<td> " + sc1 +" <td>");
        out.println("<td> " + sc2 +" <td>");
        out.println("</tr>");

    }


    out.println ("</table>");

    // fermeture de la connexion
    con.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    out.println( "</center> </body>" );
  }
}

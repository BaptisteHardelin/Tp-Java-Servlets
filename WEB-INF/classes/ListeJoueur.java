import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/ListeJoueur")
public class ListeJoueur extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res )
  throws ServletException, IOException
  {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println( "<head><title>servlet ListeJoueur</title>" );
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
    String query = "select * from JOUEURS";
    
    PreparedStatement ps = con.prepareStatement(query);
    ResultSet rs = ps.executeQuery();

    out.print("<h1>Table Joueurs</h1>");
    out.println ("<table>");

    out.println("<th>NUM_JOUEUR</th>");
    out.println("<th>NON_JOUEUR</th>");
    out.println("<th>PAYS</th>");
    out.println("<th>POSTE</th>");
    out.println("<th>MAILLOT</th>");
    out.println("<th>DATE</th>");
    out.println("<th>SALAIRE</th>");
    out.println("<br>");
    while(rs.next()) {
        String numJoueur = rs.getNString("NUM_JOUEUR");
        String nomJoueur = rs.getString("NOM_JOUEUR");
        String pays = rs.getString("PAYS");
        String poste = rs.getString("POSTE");
        String maillot = rs.getString("MAILLOT");
        Date date = rs.getDate("DATE_NAISSANCE");
        String club = rs.getString("CLUB");
        String salaire = rs.getString("SALAIRE");

        out.println("<tr>");
        out.println("<td>" + numJoueur + "</td>");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        if(year >= 30) {
          out.println("<td style=\"color: red;\">" + nomJoueur + "</td>");
        }

        
        out.println("<td>" + pays + "</td>");
        out.println("<td>" + poste + "</td>");
        out.println("<td>" + maillot + "</td>");
        out.println("<td>" + date + "</td>");
        out.println("<td>" + club + "</td>");
        out.println("<td>" + salaire + "</td>");
        out.println("</tr>");

    }

    out.println ("</table>");

    // fermeture de la connexion
    con.close();
    } catch (Exception e) {
      //TODO: handle exception
    }

    out.println( "</center> </body>" );
  }
}

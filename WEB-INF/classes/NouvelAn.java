import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/servlet-NouvelAn")
public class NouvelAn extends HttpServlet
{
  public void service( HttpServletRequest req, HttpServletResponse res )
  throws ServletException, IOException
  {
    res.setContentType("text/html;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.println( "<head><title>servlet NouvelAn</title>" );
    out.println( "<META content=\"charset=UTF-8\"></head><body><center>" );
    out.println( "<h1>NouvelAn</h1>" );

    LocalDateTime today = LocalDateTime.now();
    LocalDateTime aprilFirst = LocalDateTime.of(2018, Month.APRIL, 1, 0, 0);
    Duration delay = Duration.between(today, aprilFirst);
    long seconds = delay.get( ChronoUnit.SECONDS );

    out.println(seconds);
    out.println( "</center> </body>" );
  }
}
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/index4")
public class Servlet_04 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("visits")) {
                int visits = Integer.parseInt(cookie.getValue()) + 1;
                cookie.setValue(String.valueOf(visits));
                cookie.setMaxAge(60*60*24*365);
                response.addCookie(cookie);
                response.getWriter().append("Odwiedziłaś/eś tę stronę ")
                        .append(String.valueOf(visits))
                        .append(" razy");
                return;
            } else {
                response.getWriter().append("Witaj na stronie!");
                Cookie c = new Cookie("visits", "1");
                cookie.setMaxAge(60*60*24*365);
                response.addCookie(c);
            }
        }
    }
    /*private void FirstTime (HttpServletResponse response) throws IOException {
        response.getWriter().append("Witaj na stronie!");
        Cookie cookie = new Cookie("visits", "1");
        cookie.setMaxAge(60*60*24*365);
        response.addCookie(cookie);
    }
    */
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index2")
public class Servlet_02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        String number = request.getParameter("number");
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) != '1' && number.charAt(i) != '0') {
                response.getWriter().append("To nie jest liczba binarna");
                return;
            }
        }
        int result = 0;
        int pow = 0;
        for(int i = number.length()-1; i >= 0; i--) {
            result += Character.getNumericValue(number.charAt(i)) * Math.pow(2, pow);
            pow++;
        }

        response.getWriter().append("Liczba dziesiętna liczby ")
                .append(number).append(" wynosi ").append(String.valueOf(result));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/index2.html")
                .forward(request, response);
    }
}

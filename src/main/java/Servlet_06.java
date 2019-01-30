import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index6")
public class Servlet_06 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        if(request.getParameter("num") == null) {
            getServletContext().getRequestDispatcher("/index6.html")
                    .forward(request, response);
        } else {
            String[] numbers = request.getParameterValues("num");
            response.getWriter().append("Liczby: ").append("<br>");
            for(String n : numbers) {
                response.getWriter().append(" - ").append(n).append("<br>");
            }
            response.getWriter().append("Suma: ").append("<br>")
                    .append(" - ").append(sum(numbers)).append("<br>");
            response.getWriter().append("Srednia: ").append("<br>")
                    .append(" - ").append(average(numbers)).append("<br>");
            response.getWriter().append("Iloczyn: ").append("<br>")
                    .append(" - ").append(product(numbers));
        }

    }
    private String sum (String[] numbers) {
        int summary = 0;
        for(String n : numbers) {
            summary += Integer.parseInt(n);
        }
        return String.valueOf(summary);
    }
    private String average (String[] numbers) {
        int summary = 0;
        for(String n : numbers) {
            summary += Integer.parseInt(n);
        }
        double doubleAverage = (double) summary / (double) numbers.length;
        return String.valueOf(doubleAverage);
    }
    private String product (String[] numbers) {
        int product = 1;
        for (String n : numbers){
            product *= Integer.parseInt(n);
        }
        return String.valueOf(product);
    }
}

import org.apache.commons.math3.util.Precision;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/index")
public class Servlet_01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String conversion = request.getParameter("conversion");
        String amount = request.getParameter("amount");
        Map<String, String> exchange = new Exchange().getExchange();
        for(int i = 0; i < exchange.size(); i++) {
            if(exchange.containsKey(conversion)) {
                double dAmount = Double.parseDouble(amount);
                double dEx = Double.parseDouble(exchange.get(conversion));
                double exchangedNumber = dAmount * dEx;
                response.getWriter().append("Wynik przewalutowania: ")
                        .append(String.valueOf(Precision.round(exchangedNumber, 2)));
                return;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/index.html")
                .forward(request, response);
    }
}

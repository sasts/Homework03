import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Servlet_05_2")
public class Servlet_05_2 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();

        if(session.getAttribute("basket") != null) {
            List<Product> basket = (List<Product>) session.getAttribute("basket");
            double basketSum = 0;
            for (Product p : basket) {
                double productPrice = p.getPrice() * p.getQuantity();
                basketSum += productPrice;
                response.getWriter().append(p.getProduct())
                        .append(" - ").append(String.valueOf(p.getQuantity()))
                        .append(" x ").append(String.valueOf(p.getPrice())).append("zł")
                        .append(" = ").append(String.valueOf(productPrice)).append("zł").append("<br><br>");
            }
            response.getWriter().append("<hr>").append("SUMA: ").
                    append(String.valueOf(basketSum))
                    .append("zł");
        } else {
            response.getWriter().append("Koszyk pusty").append("<br>");
            response.getWriter().append("<a href=\"/index5\">Dodaj produkt");
        }

    }
}

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index5")
public class Servlet_05_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String name = request.getParameter("product");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");

        Product product = new Product(name, Integer.parseInt(quantity), Double.parseDouble(price));

        if(session.getAttribute("basket") == null) {
            List<Product> basket = new ArrayList<>();
            basket.add(product);
            session.setAttribute("basket", basket);
        } else {
            List<Product> basket = (List<Product>) session.getAttribute("basket");
            basket.add(product);
            session.setAttribute("basket", basket);
        }
        response.sendRedirect("/index5_2.html");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/index5.html")
                .forward(request, response);
    }

}

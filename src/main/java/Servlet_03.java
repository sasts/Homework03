import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/index3")
public class Servlet_03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        String[] text = request.getParameterValues("text");
        session.setAttribute("text", text);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        String[] text = (String[]) session.getAttribute("text");
        if(text == null) {
            text = new String[]{"", "", "", "", ""};
        }
        PrintWriter writer = response.getWriter();
        writer.append("<form method=\"post\">");
        for (int i = 0; i < 5; i++) {
            writer.append("<input type=\"text\" name=\"text\" value=\"")
                    .append(text[i]).append("\">");
        }
        writer.append("<input type=\"submit\" value=\"Wyślij\">")
                .append("</form>");
    }
}

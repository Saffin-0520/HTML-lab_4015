import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hiddenFieldServlet")
public class HiddenFieldServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve hidden field value
        String userId = request.getParameter("userId");
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hidden Field Data</h1>");
        response.getWriter().println("<p>User ID: " + userId + "</p>");
    }
}

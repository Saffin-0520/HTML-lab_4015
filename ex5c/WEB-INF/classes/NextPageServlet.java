import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/nextPageServlet")
public class NextPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Retrieve user information from URL
        String userName = request.getParameter("userName");
        response.setContentType("text/html");
        response.getWriter().println("<h1>Welcome " + userName + "</h1>");
    }
}

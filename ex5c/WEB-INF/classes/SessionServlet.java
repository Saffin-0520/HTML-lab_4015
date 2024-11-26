import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Create a session and set an attribute
        HttpSession session = request.getSession();
        session.setAttribute("userId", "12345");

        // Retrieve the session attribute
        String userId = (String) session.getAttribute("userId");
        response.setContentType("text/html");
        response.getWriter().println("<h1>Session Handling</h1>");
        response.getWriter().println("<p>Session ID: " + session.getId() + "</p>");
        response.getWriter().println("<p>User ID: " + userId + "</p>");
    }
}

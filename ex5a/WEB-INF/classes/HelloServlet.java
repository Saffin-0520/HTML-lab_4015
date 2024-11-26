import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            response.setContentType("text/html");
            response.getWriter().println("<h1>Welcome to the Servlet!</h1>");
        } catch (Exception e) {
            e.printStackTrace(); // Logs error to catalina.out
            response.getWriter().println("<h1>Internal Server Error</h1>");
        }
    }
}

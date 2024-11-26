import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/urlRewritingServlet")
public class URLRewritingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = "JohnDoe";

        // Add user information in the URL
        response.setContentType("text/html");
        response.getWriter().println("<h1>URL Rewriting</h1>");
        response.getWriter().println("<a href='nextPageServlet?userName=" + userName + "'>Go to Next Page</a>");
    }
}

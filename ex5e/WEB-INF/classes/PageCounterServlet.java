import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;

@WebServlet("/pageCounter")
public class PageCounterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Access the ServletContext to store the counter
        ServletContext context = getServletContext();

        // Get the current counter value
        Integer counter = (Integer) context.getAttribute("pageCounter");

        // Initialize the counter if it doesn't exist
        if (counter == null) {
            counter = 0;
        }

        // Increment the counter
        counter++;

        // Save the updated counter back to the context
        context.setAttribute("pageCounter", counter);

        // Display the counter on the page
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Bike Shop - Page Counter</h1>");
        response.getWriter().println("<p>Number of visits to this page: " + counter + "</p>");
        response.getWriter().println("<a href='home.html'>Go Back to Home</a>");
        response.getWriter().println("</body></html>");
    }
}

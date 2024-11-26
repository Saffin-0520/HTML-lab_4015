import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Set a cookie
        Cookie userCookie = new Cookie("userName", "JohnDoe");
        userCookie.setMaxAge(60 * 60); // 1 hour
        response.addCookie(userCookie);

        // Retrieve cookies
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        response.getWriter().println("<h1>Cookie Handling</h1>");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                response.getWriter().println("<p>" + cookie.getName() + ": " + cookie.getValue() + "</p>");
            }
        } else {
            response.getWriter().println("<p>No cookies found.</p>");
        }
    }
}

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registerBike")
public class BikeRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // JDBC URL, username, and password for MySQL
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bikeshop";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "password";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get form data
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String bikeModel = request.getParameter("bike_model");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Insert data into the database
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            String sql = "INSERT INTO BikeRegistrations (name, email, bike_model) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, bikeModel);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<h1>Registration Successful!</h1>");
            } else {
                out.println("<h1>Registration Failed. Please try again.</h1>");
            }
        } catch (SQLException e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
            e.printStackTrace();
        }
    }
}

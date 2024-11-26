<?php
// Database connection
$servername = "localhost";
$username = "root"; // Replace with your MySQL username
$password = ""; // Replace with your MySQL password
$database = "BikeShopDB";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Fetch bikes from the database
$sql = "SELECT * FROM bikes";
$result = $conn->query($sql);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bike Shop - Products</title>
    <link rel="stylesheet" href="st.css">
</head>
<body>
    <header>
        <h1>BIKE SHOP</h1>
        <nav>
            <ul>
                <li><a href="home.html">Home</a></li>
                <li><a href="bikes.php">Products</a></li>
                <li><a href="contact.html">Contact</a></li>
            </ul>
        </nav>
    </header>
    
    <div class="container">
        <center>
            <h2>Available Bikes</h2>
            <table border="1" class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Color</th>
                        <th>Price</th>
                        <th>Shop</th>
                    </tr>
                </thead>
                <tbody>
                    <?php
                    // Check if there are any rows
                    if ($result->num_rows > 0) {
                        // Output data of each row
                        while ($row = $result->fetch_assoc()) {
                            echo "<tr>
                                <td>" . $row['id'] . "</td>
                                <td>" . $row['name'] . "</td>
                                <td>" . $row['color'] . "</td>
                                <td>" . $row['price'] . "</td>
                                <td>" . $row['shop'] . "</td>
                            </tr>";
                        }
                    } else {
                        echo "<tr><td colspan='5'>No bikes available</td></tr>";
                    }
                    ?>
                </tbody>
            </table>
        </center>
    </div>

    <footer style="background-color: #333; color: rgb(252, 252, 252); text-align: center; padding: 10px 0;">
        <p>&copy; 2024 Bike Shop. All rights reserved.</p>
    </footer>
</body>
</html>

<?php
// Close the database connection
$conn->close();
?>

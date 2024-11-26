<?php
// Load the XML file
$xml = simplexml_load_file("bikes.xml") or die("Error: Cannot create object");

// Display data in a structured format
echo "<h1>Bike Details</h1>";
echo "<table border='1' style='border-collapse: collapse; width: 50%;'>";
echo "<tr>
        <th>Bike Name</th>
        <th>Price</th>
        <th>Color</th>
      </tr>";

foreach ($xml->bike as $bike) {
    echo "<tr>";
    echo "<td>" . $bike->name . "</td>";
    echo "<td>" . $bike->price . "</td>";
    echo "<td>" . $bike->color . "</td>";
    echo "</tr>";
}

echo "</table>";
?>

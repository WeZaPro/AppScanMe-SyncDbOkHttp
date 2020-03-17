<?php
// Create connection
$conn = mysqli_connect("localhost", "root", "","mydb");
mysqli_set_charset($conn,"utf-8");
if ($conn->connect_error) {
echo "error connection database or mysql". $conn->connect_error;
}
?>
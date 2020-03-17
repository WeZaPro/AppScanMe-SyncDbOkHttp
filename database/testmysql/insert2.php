<?php
include "config.php";
if (isset($_POST['id'])) {
    $txtId = $_POST['id'];
    $txtName = $_POST['name'];
    $txtLastname = $_POST['lastname'];
    $txtAge = $_POST['age'];

    $sql = "INSERT INTO tb_mem(mem_id,mem_name,mem_lastname,age) VALUES ('$txtId' , '$txtName' , '$txtLastname', '$txtAge')";
    $result = mysqli_query($conn , $sql);

    $respone = array();
    if(mysqli_affected_rows($conn) > 0)
        $respone['success'] = "1";
    else
        $respone['success'] = "0";

    echo json_encode($respone);
}
?>
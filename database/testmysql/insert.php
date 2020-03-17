<?php

header("content-type:text/javascript;charset=utf-8");
//include("config.php");

$host = "localhost";
$db_user= "root";
$db_password = "";
$db_name = "mydb";

$con = mysqli_connect($host,$db_user,$db_password,$db_name);
if($con)
    echo "Connection Success...";
else
    echo "Connect error....";

$id = $_POST["id"];
$name = $_POST["name"];
$lastnamme= $_POST["lastname"];
$age = $_POST["age"];
$image_url = $_POST["image_url"];

$sql = "INSERT INTO tb_mem (mem_id,mem_name,mem_lastname,age,image_url) VALUES ('$id ','$name','$lastnamme','$age','$image_url')";

mysqli_query($con,$sql);
mysqli_close($con);

?>
<?php
$dbhost = 'localhost';
$username = 'root';
$password = '';
$db = 'from_eshan';
//$sympid = 'Acidity';
//$sympid =$_POST['medicine_id'];

$conn = new mysqli($dbhost,$username,$password, $db);
$sql = "SELECT * FROM `doctor`";
$result = $conn->query($sql) or die(mysqli_error($conn));


if ($result->num_rows> 0) {
    // looping through all results
    // products node
    $response["doctor"] = array();

    while ($row = $result->fetch_assoc()) {
        // temp user array
        $product = array();
        $product["id"] = $row["ID"];
        $product["name"] = $row["Name"];
        $product["designation"] = $row["Designation"];
        $product["phone"] = $row["Phone"];
        //$product["updated_at"] = $row["updated_at"];

        // push single product into final response array
        array_push($response["doctor"], $product);
    }
    // success
    //$response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
}

 ?>

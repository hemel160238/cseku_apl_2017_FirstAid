<?php
$dbhost = 'localhost';
$username = 'root';
$password = '';
$db = 'from_eshan';
//$sympid = 'Acidity';
//$sympid =$_POST['medicine_id'];

$conn = new mysqli($dbhost,$username,$password, $db);
$sql = "SELECT Symptoms FROM `symptoms`";
$result = $conn->query($sql) or die(mysqli_error($conn));


if ($result->num_rows> 0) {
    // looping through all results
    // products node
    $response["symptomlist"] = array();

    while ($row = $result->fetch_assoc()) {
        // temp user array
        $product = array();
        //$product["id"] = $row["s_id"];
        $product["symptom"] = $row["Symptoms"];
        //$product["medicine"] = $row["m_name"];
        //$product["provider"] = $row["m_provider"];
        //$product["updated_at"] = $row["updated_at"];

        // push single product into final response array
        array_push($response["symptomlist"], $product);
    }
    // success
    //$response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
}

 ?>

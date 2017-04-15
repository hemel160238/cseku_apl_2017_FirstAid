<?php
$dbhost = 'localhost';
$username = 'root';
$password = '';
$db = 'from_eshan';
//$sympid = 'Acidity';
$sympid =$_POST['medicine_id'];

$conn = new mysqli($dbhost,$username,$password, $db);
$sql = "SELECT symptoms.s_id,symptoms.Symptoms,medicines.m_name,medicines.m_provider FROM connction__bridge INNER JOIN symptoms ON symptoms.s_id = connction__bridge.s_id INNER JOIN medicines ON medicines.m_id = connction__bridge.m_id WHERE symptoms.Symptoms = '$sympid'";
$result = $conn->query($sql) or die(mysqli_error($conn));


if ($result->num_rows> 0) {
    // looping through all results
    // products node
    $response["medicine"] = array();

    while ($row = $result->fetch_assoc()) {
        // temp user array
        $product = array();
        $product["id"] = $row["s_id"];
        $product["symptom"] = $row["Symptoms"];
        $product["medicine"] = $row["m_name"];
        $product["provider"] = $row["m_provider"];
        //$product["updated_at"] = $row["updated_at"];

        // push single product into final response array
        array_push($response["medicine"], $product);
    }
    // success
    //$response["success"] = 1;

    // echoing JSON response
    echo json_encode($response);
}

 ?>

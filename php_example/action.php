<a href = "index.php"> Go Query Interface</a> <p>
<?php
	if(isset($_POST['MyHead'])) {
		$MyHead=$_POST["MyHead"];
	
		$dbhost = '127.0.0.1';
		$dbuser = 'hj';
		$dbpass = 'test1234';
		$dbname = 'testdb';
		$conn = mysqli_connect($dbhost, $dbuser, $dbpass) or die('Error with MySQL connection');
		mysqli_query($conn, "SET NAMES 'utf8'");
		mysqli_select_db($conn, $dbname);
		$sql = "SELECT description FROM people where name LIKE \"".$MyHead."%\";";
		$result = mysqli_query($conn, $sql) or die('MySQL query error');
		while($row = mysqli_fetch_array($result)){
			echo $row['description']."<p>";
		}
	}
?>

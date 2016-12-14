<a href = "index.php"> Go Query Interface</a> <p>
<?php
	if(isset($_POST['MyHead'])) {
		$MyHead=$_POST["MyHead"];
	
		$dbhost = '127.0.0.1';
		$dbuser = 'hj';
		$dbpass = 'test1234';
		$dbname = 'testdb';
		$conn = mysql_connect($dbhost, $dbuser, $dbpass) or die('Error with MySQL connection');
		mysql_query("SET NAMES 'utf8'");
		mysql_select_db($dbname);
		$sql = "SELECT name FROM people where name LIKE \"".$MyHead."%\";";
		$result = mysql_query($sql) or die('MySQL query error');
		while($row = mysql_fetch_array($result)){
			echo $row['name']."<p>";
		}
	}
?>

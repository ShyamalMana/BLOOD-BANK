<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>Blood Details</h1>
		<br> <br>
		<form action="donate">
			<label>Blood Group:</label> <select name="Blood_group">
				<option value="O+">O+</option>
				<option value="O-">O-</option>
				<option value="A+">A+</option>
				<option value="A-">A-</option>
				<option value="B+">B+</option>
				<option value="B-">B-</option>
				<option value="AB+">AB+</option>
				<option value="AB-">AB-</option>
			</select><br>
			<br> <label>Quantity:</label> <select name="Quantity">
				<option value="300">300ml</option>
				<option value="400">400ml</option>
				<option value="500">500ml</option>
				<option value="600">600ml</option>
				<option value="700">700ml</option>
				<option value="800">800ml</option>
				<option value="900">900ml</option>
				<option value="1000">1000ml</option>
			</select><br>
			<br>
			<button type="submit">Donate</button>
			<button type="reset">Cancel</button>
		</form>
	</center>
</body>
</html>
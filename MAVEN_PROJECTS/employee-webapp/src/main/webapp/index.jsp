<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Form</title>
</head>
<body>

<h2>Employee Registration</h2>

<form action="register" method="post">
    <label>Employee ID:</label>
    <input type="text" name="empId"><br><br>

    <label>Name:</label>
    <input type="text" name="name"><br><br>

    <label>Salary:</label>
    <input type="text" name="salary"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>

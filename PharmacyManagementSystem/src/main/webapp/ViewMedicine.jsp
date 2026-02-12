<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Medicine</title>
</head>
<body>

<h3>View Medicine Record</h3>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="ViewRecord">

    Medicine Name: <input type="text" name="medicineName"><br><br>
    Purchase Date: <input type="date" name="purchaseDate"><br><br>

    <input type="submit" value="Search">

</form>

</body>
</html>
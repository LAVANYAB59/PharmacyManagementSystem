<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>View All Medicines</title>
</head>
<body>

<h3>View All Medicine Records</h3>

<form action="MainServlet" method="post">

    <input type="hidden" name="operation" value="ViewAllRecords">

    <input type="submit" value="View All Records">

</form>

</body>
</html>
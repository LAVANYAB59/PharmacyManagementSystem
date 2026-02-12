<%@ page language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.wipro.pharmacy.bean.PharmacyBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Medicines</title>
</head>
<body>

<h3>All Medicine Records</h3>

<%
    List<PharmacyBean> list = (List<PharmacyBean>) request.getAttribute("list");
    String message = (String) request.getAttribute("message");

    if (list != null && !list.isEmpty()) {
%>

<table border="1">
<tr>
    <th>Record ID</th>
    <th>Medicine Name</th>
    <th>Supplier Name</th>
    <th>Purchase Date</th>
    <th>Quantity</th>
    <th>Price</th>
    <th>Remarks</th>
</tr>

<%
    for (PharmacyBean bean : list) {
%>

<tr>
    <td><%= bean.getRecordId() %></td>
    <td><%= bean.getMedicineName() %></td>
    <td><%= bean.getSupplierName() %></td>
    <td><%= bean.getPurchaseDate() %></td>
    <td><%= bean.getQuantity() %></td>
    <td><%= bean.getPrice() %></td>
    <td><%= bean.getRemarks() %></td>
</tr>

<%
    }
%>

</table>

<%
    } else {
%>

<h4><%= message != null ? message : "No records available!" %></h4>

<%
    }
%>

<br>
<a href="Menu.html">Back to Menu</a>

</body>
</html>
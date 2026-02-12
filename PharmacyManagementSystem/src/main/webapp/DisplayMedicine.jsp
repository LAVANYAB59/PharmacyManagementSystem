<%@ page language="java" %>
<%@ page import="com.wipro.pharmacy.bean.PharmacyBean" %>

<!DOCTYPE html>
<html>
<head>
    <title>Display Medicine</title>
</head>
<body>

<h3>Medicine Details</h3>

<%
    PharmacyBean bean = (PharmacyBean) request.getAttribute("bean");
    String message = (String) request.getAttribute("message");

    if (bean != null) {
%>

Record ID: <%= bean.getRecordId() %> <br><br>
Medicine Name: <%= bean.getMedicineName() %> <br><br>
Supplier Name: <%= bean.getSupplierName() %> <br><br>
Purchase Date: <%= bean.getPurchaseDate() %> <br><br>
Quantity: <%= bean.getQuantity() %> <br><br>
Price: <%= bean.getPrice() %> <br><br>
Remarks: <%= bean.getRemarks() %> <br><br>

<%
    } else {
%>

<h4><%= message != null ? message : "No matching records exists! Please try again!" %></h4>

<%
    }
%>

<a href="Menu.html">Back to Menu</a>

</body>
</html>
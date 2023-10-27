<%-- 
    Document   : ShowConfirmation
    Created on : Oct 21, 2023, 12:05:15 AM
    Author     : aunchisachanatipakul
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Confirmation</title>
    </head>
    <body>
        <h1>Your Order is confirmed!</h1>
        <% out.println("<h1>The total amount is $" + request.getAttribute("totalPrice") + "</h1>"); %>
       
    </body>
</html>

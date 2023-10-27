<%-- 
    Document   : shoppingCartPage
    Created on : Oct 17, 2023, 5:56:08 PM
    Author     : aunchisachanatipakul
--%>

<%@page import="model.Shoppingcart"%>
<%@page import="model.ShoppingcartTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductsTable"%>
<%@page import="model.Products"%>
<%@page import="model.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
    <jsp:useBean id="pr" class="model.Products" scope="page"/>
    <%
                       
            List<Products> prList = ProductsTable.getAllProduct();
            Iterator<Products> itr = prList.iterator();
            
     %>

    <body>
    <center>
        <h1>Shopping Cart</h1>
        <form name="second" action="cartController" method="POST">
            <table border="1">
                <tr>
                    <th>DVD Name</th>
                    <th>Rate</th>
                    <th>Year</th>
                    <th>Price/Unit</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <%
                    while(itr.hasNext()) {
                        pr = itr.next();
                        if(request.getAttribute(pr.getMovie() + "_ChB") != null){
                %>
                <tr>
                <td><%=pr.getMovie()%></td>
                <td><%=pr.getRating()%></td>
                <td><%=pr.getYearcreate()%></td>
                <td><%=pr.getPrice()%></td>
                <td><%=request.getAttribute(pr.getMovie() + "_Qtt")%></td>
                <td><%=request.getAttribute(pr.getMovie() + "_TotalPricePerMovie") %></td>
                </tr>
                <%
                    }
                }
                %>
                <tr>
                        <td>Total</td>
                        <td><%=request.getAttribute("totalPrice")%></td>       
                </tr>
            </table>
                <input type="submit" value="Check Out" name="Check Out" />
    </center>
        
    </body>
</html>

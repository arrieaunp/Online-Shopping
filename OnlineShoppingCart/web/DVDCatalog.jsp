<%@page import="java.util.Enumeration"%>
<%@page import="model.ProductsTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>
<%@page import="model.Products"%>
<%@page import="model.Shoppingcart"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Online Shopping</title>
</head>
    <jsp:useBean id="pr" class="model.Products" scope="page"/>
    <%
       List <Products> prList = ProductsTable.getAllProduct();
       Iterator<Products> itr = prList.iterator();
    %>
<body>
        <center>
        <h1>DVD Catalog</h1>
        <form name="first" action="DVDcatalogController" method="POST">
            <table border="1">
                <tr>
                    <th>DVD Name</th>
                    <th>Rate</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr> 
                <%
                    while(itr.hasNext()) {
                            pr = itr.next();
                %>
                <tr>
                    <td>
                    <input 
                        type="checkbox"
                        name="<%= pr.getMovie() %>_ChB"
                        value="checked" 
                        id="<%= pr.getMovie() %>"/>
                    <%= pr.getMovie() %>
                    </td>
                    <td><%= pr.getRating() %></td>
                    <td><%= pr.getYearcreate() %></td>
                    <td><%= pr.getPrice() %></td>
                    <td>
                    <input
                        type="text" 
                        name="<%= pr.getMovie() %>_Qtt"
                        value=""
                        id="<%= pr.getMovie() %>_Qtt"/>
                    </td>  
                </tr>
                <%
                    }
                        session = request.getSession();
                        if(session.isNew()){
                            out.println("<script>");
                            for(Products prod : prList){
                                out.println("document.getElementById(\"" + prod.getMovie() + "\").checked = false;");
                            }
                            out.println("</script>");
                        }else {
                            out.println("<script>");
                            Enumeration<String> session_attrs = session.getAttributeNames();
                            while(session_attrs.hasMoreElements()){
                                String single_session_attr = session_attrs.nextElement();
                                if(!single_session_attr.equals("WELD_S_HASH") && single_session_attr.contains("_ChB")){
                                    out.println("document.getElementById(\"" + single_session_attr.replace("_ChB", "") + "\").checked = " + (Boolean) session.getAttribute(single_session_attr) + ";");
                                }else if(!single_session_attr.equals("WELD_S_HASH") && single_session_attr.contains("_Qtt")){
                                    out.println("document.getElementById(\"" + single_session_attr + "\").value = \"" + Integer.valueOf((String) session.getAttribute(single_session_attr)) + "\";");
                                }
                            }
                            out.println("</script>");
                        }
                %>
                  
            </table>
            <input type="submit" value="Add To Cart" name="AddToCart_bt" id="submit" />
        </center>
</body>
</html>

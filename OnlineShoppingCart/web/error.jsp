<%-- 
    Document   : error
    Created on : Nov 25, 2020, 1:48:15 PM
    Author     : sarun
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Same session Handling</title>
    </head>
    <Script>
        function msgAlert(){
            alert("Your session has already ended!\nPlease select the product again.");
        }
    </Script>
    <body onload="msgAlert()">
        <center>            
            <jsp:include page="DVDCatalog.jsp" flush="true" />
        </center>
    </body>
</html>

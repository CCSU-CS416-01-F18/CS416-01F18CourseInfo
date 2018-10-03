<%-- 
    Document   : DisplayBands
    Created on : Oct 11, 2017, 9:17:55 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.ccsu.Band;"%>
<%@page import="edu.ccsu.Cd;"%>
<%@page import="edu.ccsu.Musician;"%>
<jsp:useBean id="bands" scope="request" class="java.util.List<Band>" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bands</title>
    </head>
    <body>
        <h1>Bands</h1>
        <% for (Band band : bands){ %>
            <h2> Band: <%= band.getName() %> </h2>

            <h3> CDs</h3>
            <ul>
            <% for (Cd cd : band.getCds()){ %>
                <li> <%= cd.getTitle() %> </li>
            <%}%>
            </ul>

            <h3> Musicians</h3>
            <ul>
            <% for (Musician musicican : band.getMusicians()){ %>
                <li> <%= musicican.getName() %> </li>
            <%}%>
            </ul>      
        <%}%>
    </body>
</html>

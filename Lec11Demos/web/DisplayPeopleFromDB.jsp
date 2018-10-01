<%-- 
    Document   : DisplayPeopleFromDB
    Created on : Sep 27, 2017, 11:12:28 AM
    Author     : cw1491
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="edu.ccsu.Person;"%>
<jsp:useBean id="people" scope="request" class="java.util.List<Person>" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display people from DB</title>
    </head>
    <body>
         <table border="1">
           <tr><th>First</th><th>Last</th></tr>
         <%
            for (Person p : people) {
         %>
            <tr><td><%=p.getFirstName()%></td><td><%=p.getLastName()%></td></tr>
         <% } %>
         </table>
    </body>
</html>

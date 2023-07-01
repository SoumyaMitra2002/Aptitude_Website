<%-- 
    Document   : Questions
    Created on : 08-Jun-2023, 5:46:57 pm
    Author     : hp
--%>

<%@page import="com.tech.blog.entities.QuestionTake"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    QuestionTake user = (QuestionTake) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("error_page.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Questions</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
              crossorigin="anonymous">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <h1>Hello World!</h1>
        <% QuestionTake q=new QuestionTake(); 
        
    %>
    </body>
</html>

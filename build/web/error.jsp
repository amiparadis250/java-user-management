<%-- 
    Document   : error
    Created on : Apr 10, 2025, 8:09:04 AM
    Author     : ISHIMWE Ami Paradis
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
</head>
<body>
 <center>
  <h1>Error</h1>
  <h2><%=exception.getMessage() %><br/> </h2>
 </center> 
</body>
</html>
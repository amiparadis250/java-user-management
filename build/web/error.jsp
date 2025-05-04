<%-- 
    Document   : error
    Created on : Apr 10, 2025, 8:09:04 AM
    Author     : ISHIMWE Ami Paradis
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
 "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Error</title>
<style>
    .error-container {
        width: 80%;
        margin: 0 auto;
        padding: 20px;
        border: 1px solid #f5c6cb;
        background-color: #f8d7da;
        border-radius: 5px;
        color: #721c24;
    }
    .stack-trace {
        background-color: #f8f9fa;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        overflow-x: auto;
        margin-top: 20px;
        font-family: monospace;
    }
</style>
</head>
<body>
 <center>
  <h1>Error</h1>
  <div class="error-container">
    <h2>Error Details:</h2>
    <p><strong>Error Message:</strong> <%=exception.getMessage() %></p>
    <p><strong>Error Type:</strong> <%=exception.getClass().getName() %></p>
    
    <h3>Stack Trace:</h3>
    <div class="stack-trace">
      <% 
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        out.println(stringWriter.toString().replace("\n", "<br/>").replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;"));
      %>
    </div>
  </div>
 </center> 
</body>
</html>
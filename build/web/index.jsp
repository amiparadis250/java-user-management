<%-- 
    Document   : index
    Created on : Apr 10, 2025, 10:16:00 AM
    Author     : ISHIMWE Ami Paradis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Java Servlet Management System</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                line-height: 1.6;
            }
            .container {
                max-width: 800px;
                margin: 0 auto;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }
            h1 {
                color: #333;
                text-align: center;
            }
            .options {
                display: flex;
                justify-content: space-around;
                margin-top: 30px;
            }
            .option-box {
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                width: 40%;
                text-align: center;
            }
            .option-box a {
                display: block;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 4px;
                font-weight: bold;
            }
            .option-box a:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Welcome to Java Management System</h1>
            <p>Developed using JSP, Postgres database and NetBeans</p>
            <p>Please select one of our systems below:</p>
            
            <div class="options">
                <div class="option-box">
                    <h3>User Management</h3>
                    <p>Add, edit, and manage system users</p>
                    <a href="${pageContext.request.contextPath}/users/">USER MANAGEMENT SYSTEM</a>
                </div>
                
                <div class="option-box">
                    <h3>Lost Items Management</h3>
                    <p>Report and track lost items</p>
                    <a href="${pageContext.request.contextPath}/lost-items/">LOST ITEMS MANAGEMENT SYSTEM</a>
                </div>
            </div>
        </div>
    </body>
</html>
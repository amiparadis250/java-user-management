<%--
    Document   : lost-item-list
    Created on : Apr 9, 2025, 4:51:55 PM
    Author     : ISHIMWE Ami Paradis
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Lost Item Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
            <div>
                <a href="https://www.javaguides.net" class="navbar-brand"> Lost Item Management App </a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/lost-items/" class="nav-link">Lost Items</a></li>
                <li><a href="<%=request.getContextPath()%>/" class="nav-link">Home</a></li> <!-- Home Button -->
            </ul>
        </nav>
    </header>
    <br>
    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Lost Items</h3>
            <hr>
            <div class="container text-left">
                <a href="<%=request.getContextPath()%>/lost-items/new" class="btn btn-success">Add New Lost Item</a>
            </div>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Founder</th>
                        <th>Location</th>
                        <th>Date</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="lostItem" items="${listLostItems}">
                        <tr>
                            <td><c:out value="${lostItem.id}" /></td>
                            <td><c:out value="${lostItem.name}" /></td>
                            <td><c:out value="${lostItem.founder}" /></td>
                            <td><c:out value="${lostItem.location}" /></td>
                            <td><c:out value="${lostItem.date}" /></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/lost-items/edit?id=<c:out value='${lostItem.id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="<%=request.getContextPath()%>/lost-items/delete?id=<c:out value='${lostItem.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>

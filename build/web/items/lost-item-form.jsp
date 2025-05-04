<%-- 
    Document   : lost-item-form
    Created on : Apr 9, 2025, 4:51:26 PM
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
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${lostItem != null}">
                    <form action="<%=request.getContextPath()%>/lost-items/update" method="post">
                </c:if>
                <c:if test="${lostItem == null}">
                    <form action="<%=request.getContextPath()%>/lost-items/insert" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${lostItem != null}">
                            Edit Lost Item
                        </c:if>
                        <c:if test="${lostItem == null}">
                            Add New Lost Item
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${lostItem != null}">
                    <input type="hidden" name="id" value="<c:out value='${lostItem.id}' />" />
                </c:if>

                <fieldset class="form-group">
                    <label>Item Name</label>
                    <input type="text" value="<c:out value='${lostItem.name}' />" class="form-control" name="name" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Founder</label>
                    <input type="text" value="<c:out value='${lostItem.founder}' />" class="form-control" name="founder">
                </fieldset>

                <fieldset class="form-group">
                    <label>Location</label>
                    <input type="text" value="<c:out value='${lostItem.location}' />" class="form-control" name="location">
                </fieldset>

                <fieldset class="form-group">
                    <label>Date</label>
                    <input type="datetime-local" value="<c:out value='${lostItem.date}' />" class="form-control" name="date">
                </fieldset>

                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>


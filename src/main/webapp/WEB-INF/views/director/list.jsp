<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Directors</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Directors</h1>

    <div class="mb-3">
        <a href="/directors/new" class="btn btn-primary">Add New Director</a>
        <a href="/movies" class="btn btn-secondary">View Movies</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Nationality</th>
            <th>Birth Date</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${directors}" var="director">
            <tr>
                <td>${director.id}</td>
                <td>${director.name}</td>
                <td>${director.nationality}</td>
                <td><fmt:formatDate value="${director.birthDate}" pattern="yyyy-MM-dd" /></td>
                <td>
                    <a href="/directors/${director.id}" class="btn btn-info btn-sm">View</a>
                    <a href="/directors/${director.id}/edit" class="btn btn-warning btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

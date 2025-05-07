<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Director Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Director Details</h1>

    <div class="card mb-4">
        <div class="card-header">
            <h2>${director.name}</h2>
        </div>
        <div class="card-body">
            <p><strong>Nationality:</strong> ${director.nationality}</p>
            <p><strong>Birth Date:</strong> <fmt:formatDate value="${director.birthDate}" pattern="MMMM d, yyyy" /></p>
            <p><strong>Biography:</strong> ${director.biography}</p>
        </div>
        <div class="card-footer">
            <a href="/directors/${director.id}/edit" class="btn btn-warning">Edit</a>
            <a href="/directors" class="btn btn-secondary">Back to List</a>
        </div>
    </div>

    <h3>Movies Directed</h3>
    <div class="mb-3">
        <a href="/movies/new" class="btn btn-primary">Add New Movie</a>
    </div>

    <c:if test="${empty movies}">
        <p>No movies found for this director.</p>
    </c:if>

    <c:if test="${not empty movies}">
        <div class="row">
            <c:forEach items="${movies}" var="movie">
                <div class="col-md-4 mb-4">
                    <div class="card">
                        <div class="card-header">
                            <h5>${movie.title} (${movie.releaseYear})</h5>
                        </div>
                        <div class="card-body">
                            <p><strong>Genre:</strong> ${movie.genre}</p>
                            <p><strong>Budget:</strong> $${movie.budget} million</p>
                            <p><strong>Box Office:</strong> $${movie.boxOffice} million</p>
                        </div>
                        <div class="card-footer">
                            <a href="/movies/${movie.id}" class="btn btn-info btn-sm">View</a>
                            <a href="/movies/${movie.id}/edit" class="btn btn-warning btn-sm">Edit</a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

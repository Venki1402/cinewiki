<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movies</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Movies</h1>

    <div class="mb-3">
        <a href="/movies/new" class="btn btn-primary">Add New Movie</a>
        <a href="/directors" class="btn btn-secondary">View Directors</a>
    </div>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Year</th>
            <th>Genre</th>
            <th>Director</th>
            <th>Budget (millions)</th>
            <th>Box Office (millions)</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${movies}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.releaseYear}</td>
                <td>${movie.genre}</td>
                <td>${movie.director.name}</td>
                <td>$${movie.budget}</td>
                <td>$${movie.boxOffice}</td>
                <td>
                    <a href="/movies/${movie.id}" class="btn btn-info btn-sm">View</a>
                    <a href="/movies/${movie.id}/edit" class="btn btn-warning btn-sm">Edit</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

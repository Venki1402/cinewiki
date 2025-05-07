<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Movie Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>Movie Details</h1>

    <div class="card mb-4">
        <div class="card-header">
            <h2>${movie.title} (${movie.releaseYear})</h2>
        </div>
        <div class="card-body">
            <p><strong>Genre:</strong> ${movie.genre}</p>
            <p><strong>Director:</strong> <a href="/directors/${movie.director.id}">${movie.director.name}</a></p>
            <p><strong>Budget:</strong> $${movie.budget} million</p>
            <p><strong>Box Office:</strong> $${movie.boxOffice} million</p>
            <p><strong>Plot:</strong> ${movie.plot}</p>
        </div>
        <div class="card-footer">
            <a href="/movies/${movie.id}/edit" class="btn btn-warning">Edit</a>
            <a href="/movies" class="btn btn-secondary">Back to List</a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

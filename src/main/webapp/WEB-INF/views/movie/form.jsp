<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${movie.id == null ? 'Add' : 'Edit'} Movie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${movie.id == null ? 'Add New' : 'Edit'} Movie</h1>

    <form:form action="${movie.id == null ? '/movies' : '/movies/'.concat(movie.id)}" method="post" modelAttribute="movie" cssClass="mt-4">
        <div class="mb-3">
            <label for="title" class="form-label">Title</label>
            <form:input path="title" cssClass="form-control" required="true" />
            <form:errors path="title" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="releaseYear" class="form-label">Release Year</label>
            <form:input type="number" path="releaseYear" cssClass="form-control" min="1888" max="2030" />
            <form:errors path="releaseYear" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="genre" class="form-label">Genre</label>
            <form:input path="genre" cssClass="form-control" />
            <form:errors path="genre" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="plot" class="form-label">Plot</label>
            <form:textarea path="plot" cssClass="form-control" rows="3" />
            <form:errors path="plot" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="budget" class="form-label">Budget (millions)</label>
            <form:input type="number" path="budget" cssClass="form-control" step="0.1" min="0" />
            <form:errors path="budget" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="boxOffice" class="form-label">Box Office (millions)</label>
            <form:input type="number" path="boxOffice" cssClass="form-control" step="0.1" min="0" />
            <form:errors path="boxOffice" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="director" class="form-label">Director</label>
            <form:select path="director" cssClass="form-control" required="true">
                <form:option value="" label="-- Select Director --" />
                <c:forEach items="${directors}" var="director">
                    <form:option value="${director.id}" label="${director.name}" />
                </c:forEach>
            </form:select>
            <form:errors path="director" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/movies" class="btn btn-secondary">Cancel</a>
        </div>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

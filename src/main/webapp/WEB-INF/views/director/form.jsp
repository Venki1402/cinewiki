<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${director.id == null ? 'Add' : 'Edit'} Director</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <h1>${director.id == null ? 'Add New' : 'Edit'} Director</h1>

    <form:form action="${director.id == null ? '/directors' : '/directors/'.concat(director.id)}" method="post" modelAttribute="director" cssClass="mt-4">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <form:input path="name" cssClass="form-control" required="true" />
            <form:errors path="name" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="birthDate" class="form-label">Birth Date</label>
            <form:input type="date" path="birthDate" cssClass="form-control" />
            <form:errors path="birthDate" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="nationality" class="form-label">Nationality</label>
            <form:input path="nationality" cssClass="form-control" />
            <form:errors path="nationality" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <label for="biography" class="form-label">Biography</label>
            <form:textarea path="biography" cssClass="form-control" rows="5" />
            <form:errors path="biography" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary">Save</button>
            <a href="/directors" class="btn btn-secondary">Cancel</a>
        </div>
    </form:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

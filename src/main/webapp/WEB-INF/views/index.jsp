<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CineWiki</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .hero-section {
            background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
            url('https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?ixlib=rb-4.0.3');
            background-size: cover;
            background-position: center;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
        }

        .logo {
            font-size: 4.5rem;
            font-weight: bold;
            margin-bottom: 2rem;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.5);
        }

        .nav-buttons .btn {
            margin: 0 10px;
            padding: 10px 30px;
            font-size: 1.2rem;
            text-transform: uppercase;
            letter-spacing: 1px;
            transition: transform 0.3s;
        }

        .nav-buttons .btn:hover {
            transform: translateY(-3px);
        }

        .social-icons {
            position: fixed;
            bottom: 30px;
            left: 50%;
            transform: translateX(-50%);
        }

        .social-icons a {
            color: white;
            font-size: 1.5rem;
            margin: 0 15px;
            transition: transform 0.3s;
        }

        .social-icons a:hover {
            transform: translateY(-3px);
        }
    </style>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="hero-section">
    <div class="container text-center">
        <h1 class="logo">CineWiki</h1>
        <div class="nav-buttons">
            <a href="/directors" class="btn btn-outline-light">Directors</a>
            <a href="/movies" class="btn btn-outline-light">Movies</a>
        </div>

        <div class="social-icons">
            <a href="https://github.com/Venki1402"><i class="fab fa-github"></i></a>
            <a href="https://x.com/ASaiVenkatesh1"><i class="fab fa-twitter"></i></a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
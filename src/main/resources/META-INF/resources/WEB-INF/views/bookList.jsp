<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <h1>Book List</h1>
    <table class="book-table">
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td><a href="${pageContext.request.contextPath}/editBook?bookId=${book.id}">Edit</a></td>
                <td><a href="${pageContext.request.contextPath}/deleteBook?bookId=${book.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/addBook">Add New Book</a>
</body>
</html>

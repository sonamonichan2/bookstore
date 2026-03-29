<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Book</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>Edit Book</h1>
    <form action="updateBook" method="post" class="book-form">
        <input type="hidden" name="id" value="${book.id}"/>
        <label>Title</label>
        <input type="text" name="title" value="${book.title}" size="40"/>
        <label>Author</label>
        <input type="text" name="author" value="${book.author}"/>
        <input type="submit" value="Save Changes">
    </form>
    <br>
    <a href="bookList">Back to Book List</a>
</body>
</html>

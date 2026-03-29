<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
     <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>Add Book</h1>
    <form action="saveBook" method="post"  class="book-form">
        <label>Title</label>
        <input type="text" name="title" value="${book.title}" size="40"/>
        <label>Author</label>
        <input type="text" name="author" value="${book.author}"/>
        <input type="submit" value="Add Book">
    </form>
    <br>
    <a href="bookList">Back to Book List</a>
</body>
</html>

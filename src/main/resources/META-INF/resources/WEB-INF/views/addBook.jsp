<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
     <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <h1>Add Book</h1>
    <form:form action="/saveBook" method="post" modelAttribute="book" cssClass="book-form">
        <label>Title</label>
        <form:input path="title" size="40"/>
        <br/>
        <label>Author</label>
        <form:input path="author"/>
        <br/>
        <input type="submit" value="Add Book">
    </form:form>
    <br>
    <a href="/bookList">Back to Book List</a>
</body>
</html>

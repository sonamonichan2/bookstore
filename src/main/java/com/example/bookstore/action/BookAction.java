package com.example.bookstore.action;

import com.example.bookstore.dao.BookDAO;
import com.example.bookstore.dao.impl.BookDAOImpl;
import com.example.bookstore.hibernate.model.Book;
import com.example.bookstore.service.BookService;
import org.apache.struts2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookAction extends ActionSupport {
    private Book book;
    private List<Book> bookList;
    private int bookId;

    @Autowired
    private BookService bookService;

    public String list() {
        // Retrieve the list of books from the database
        bookList = bookService.getAllBooks();
        return SUCCESS;
    }

    public String save() {
        // Add the book to the database
        bookService.addBook(book);
        return SUCCESS;
    }
    public String add() {
        // Add the book to the database
        return INPUT;
    }

    public String edit() {
        // Retrieve the book by ID from the database
        book = bookService.getBookById(bookId);
        if (book == null) {
            return ERROR;
        }
        return INPUT;
    }

    public String update() {
        // Update the book in the database
        bookService.updateBook(book);
        return SUCCESS;
    }

    public String delete() {
        // Delete the book from the database
        bookService.deleteBook(bookId);
        return SUCCESS;
    }

    // Getters and setters
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}

package com.example.bookstore.controller;

import com.example.bookstore.hibernate.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/bookList")
    public String list(Model model) {
        // Retrieve the list of books from the database
        model.addAttribute("bookList", bookService.getAllBooks());
        return "bookList";
    }

    @GetMapping("/addBook")
    public String add(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/saveBook")
    public String save(@ModelAttribute Book book) {
        // Add the book to the database
        bookService.addBook(book);
        return "redirect:/bookList";
    }

    @GetMapping("/editBook")
    public String edit(@RequestParam int bookId, Model model) {
        // Retrieve the book by ID from the database
        Book book = bookService.getBookById(bookId);
        model.addAttribute("book", book);
        return "editBook";
    }

    @PostMapping("/updateBook")
    public String update(@ModelAttribute Book book) {
        // Update the book in the database
        bookService.updateBook(book);
        return "redirect:/bookList";
    }

    @GetMapping("/deleteBook")
    public String delete(@RequestParam int bookId) {
        // Delete the book from the database
        bookService.deleteBook(bookId);
        return "redirect:/bookList";
    }
}

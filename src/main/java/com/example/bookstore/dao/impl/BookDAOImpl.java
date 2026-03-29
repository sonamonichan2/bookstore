package com.example.bookstore.dao.impl;


import com.example.bookstore.dao.BookDAO;
import com.example.bookstore.hibernate.model.Book;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<Book> getAllBooks() {
        CriteriaBuilder cb = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        List<Book> books = sessionFactory.getCurrentSession().createQuery(cq).getResultList();
        return books;
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
        sessionFactory.getCurrentSession().delete(book);
    }
}


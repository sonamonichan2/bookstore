package com.example.bookstore.dao.impl;


import com.example.bookstore.dao.BookDAO;
import com.example.bookstore.hibernate.model.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

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
        return sessionFactory.getCurrentSession().createQuery(cq).getResultList();
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().persist(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().merge(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Book book = sessionFactory.getCurrentSession().get(Book.class, id);
        sessionFactory.getCurrentSession().remove(book);
    }
}


package com.example.bookstore.dao.impl;


import com.example.bookstore.dao.BookDAO;
import com.example.bookstore.hibernate.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public List<Book> getAllBooks() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> root = cq.from(Book.class);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        entityManager.persist(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    @Override
    @Transactional
    public void deleteBook(int id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(book);
    }
}

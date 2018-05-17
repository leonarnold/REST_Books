package de.gbsschulen.rest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


public class BookService {

    private EntityManagerFactory emf;
    private EntityManager em;

    public BookService() {
        emf = Persistence.createEntityManagerFactory("books");
        em = emf.createEntityManager();
    }

    public void close() {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }


    public Book getBook(int id) {
        return em.find(Book.class, id);
    }

    public List<Book> getAllBooks() {
        TypedQuery<Book> typedQuery = em.createQuery("SELECT b from Book b", Book.class);
        return typedQuery.getResultList();
    }

    public Book deleteBook(int id){
        Book book = getBook(id);
        if(book != null){
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        return book;
    }

    public static void main(String[] args) {
        BookService bookService = new BookService();
        Book book = bookService.getBook(1);
        System.out.println(book);
        List<Book> books = bookService.getAllBooks();
        for (Book book1 : books) {
            System.out.println(book1);
        }
        bookService.close();
    }

    public void add(Book book){
        if(book != null){
            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
        }
    }
}
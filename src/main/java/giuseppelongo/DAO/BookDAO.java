package giuseppelongo.DAO;

import giuseppelongo.entities.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class BookDAO extends GenericDAO<Book> {

    public BookDAO(EntityManager em) {
        super(em);
    }

    // Ricerca per ISBN
    public Book findByIsbn(String isbn) {
        return find(Book.class, isbn);
    }

    // Ricerca per anno pubblicazione
    public List<Book> findByPublicationYear(int year) {
        String query = "SELECT b FROM Book b WHERE YEAR(b.publicationYear) = :year";
        TypedQuery<Book> typedQuery = em.createQuery(query, Book.class);
        typedQuery.setParameter("year", year);
        return typedQuery.getResultList();
    }

    // Ricerca per autore
    public List<Book> findByAuthor(String author) {
        String query = "SELECT b FROM Book b WHERE b.authors LIKE :author";
        TypedQuery<Book> typedQuery = em.createQuery(query, Book.class);
        typedQuery.setParameter("author", "%" + author + "%");
        return typedQuery.getResultList();
    }

    // Ricerca per titolo o parte di esso
    public List<Book> findByTitle(String title) {
        String query = "SELECT b FROM Book b WHERE b.title LIKE :title";
        TypedQuery<Book> typedQuery = em.createQuery(query, Book.class);
        typedQuery.setParameter("title", "%" + title + "%");
        return typedQuery.getResultList();
    }

}
package giuseppelongo.DAO;

import giuseppelongo.entities.Magazine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MagazineDAO extends GenericDAO<Magazine> {

    public MagazineDAO(EntityManager em) {
        super(em);
    }

    // Ricerca per ISBN
    public Magazine findByIsbn(String isbn) {
        return find(Magazine.class, isbn);
    }

    // Ricerca per anno pubblicazione
    public List<Magazine> findByPublicationYear(int year) {
        String query = "SELECT m FROM Magazine m WHERE YEAR(m.publicationYear) = :year";
        TypedQuery<Magazine> typedQuery = em.createQuery(query, Magazine.class);
        typedQuery.setParameter("year", year);
        return typedQuery.getResultList();
    }

    // Ricerca per titolo o parte di esso
    public List<Magazine> findByTitle(String title) {
        String query = "SELECT m FROM Magazine m WHERE m.title LIKE :title";
        TypedQuery<Magazine> typedQuery = em.createQuery(query, Magazine.class);
        typedQuery.setParameter("title", "%" + title + "%");
        return typedQuery.getResultList();
    }
}
package giuseppelongo.DAO;

import giuseppelongo.entities.Book;
import jakarta.persistence.EntityManager;

public class BookDAO extends GenericDAO<Book> {

    public BookDAO(EntityManager em) {
        super(em);
    }
}
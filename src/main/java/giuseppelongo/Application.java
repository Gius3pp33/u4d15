package giuseppelongo;

import giuseppelongo.DAO.BookDAO;
import giuseppelongo.DAO.MagazineDAO;
import giuseppelongo.entities.Book;
import giuseppelongo.entities.Magazine;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class Application {

    public static void main(String[] args) {
        // Creazione dell'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d15");
        EntityManager em = emf.createEntityManager();

        // Creazione dei DAO
        BookDAO bookDAO = new BookDAO(em);
        MagazineDAO magazineDAO = new MagazineDAO(em);

        // Creazione e salvataggio di un libro
        Book book = new Book("1234567890142377", "GTA", new Date(), 300, "Nome Autore", "Sparatutto");
        bookDAO.save(book);

        // Creazione e salvataggio di una rivista
        Magazine magazine = new Magazine("9876543210987444", "Fantastica rivista", new Date(), 50, Magazine.Periodicity.WEEKLY);
        magazineDAO.save(magazine);

        // Stampa dei dettagli
        System.out.println(book);
        System.out.println(magazine);

        // Chiusura dell'EntityManager
        em.close();
        emf.close();
    }
}

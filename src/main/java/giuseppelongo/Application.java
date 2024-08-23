package giuseppelongo;

import giuseppelongo.DAO.BookDAO;
import giuseppelongo.DAO.LoanDAO;
import giuseppelongo.DAO.MagazineDAO;
import giuseppelongo.DAO.UserDAO;
import giuseppelongo.entities.Book;
import giuseppelongo.entities.Loan;
import giuseppelongo.entities.Magazine;
import giuseppelongo.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {

    public static void main(String[] args) {
        // Creazione dell'EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d15");
        EntityManager em = emf.createEntityManager();

        BookDAO bookDAO = new BookDAO(em);
        MagazineDAO magazineDAO = new MagazineDAO(em);
        UserDAO userDAO = new UserDAO(em);
        LoanDAO loanDAO = new LoanDAO(em);

        // Creazione e salvataggio di un libro
        Book book = new Book("12347445", "Final fantasy", new Date(), 320, "Alberto", "Fantasy");
        bookDAO.save(book);

// Creazione e salvataggio di una rivista
        Magazine magazine = new Magazine("477711111", "Fantastica rivista", new Date(), 51, Magazine.Periodicity.SEMESTRAL);
        magazineDAO.save(magazine);

// Creazione e salvataggio di un utente
        User user = new User("U1442347", "Carlos", "Rossi", parseDate("2000-02-01"));
        userDAO.save(user);

// Verifica che i dati siano stati salvati correttamente
        book = bookDAO.findByIsbn("4555555555");
        user = userDAO.findByCardNumber("U144444");

        if (book != null && user != null) {
            Loan loan = new Loan(user, book, new Date());
            loanDAO.save(loan);
        } else {
            System.out.println("Errore: Libro o utente non trovato.");
        }

        // Esempi di operazioni
        System.out.println("Libro trovato per ISBN: " + bookDAO.findByIsbn("4555555555"));
        System.out.println("Ricerca per anno di pubblicazione: " + bookDAO.findByPublicationYear(2024));
        System.out.println("Ricerca per autore: " + bookDAO.findByAuthor("Alberto"));
        System.out.println("Ricerca per titolo: " + bookDAO.findByTitle("Final fantasy"));

        System.out.println("Prestiti attuali per utente: " + loanDAO.findCurrentLoansByUserCardNumber("U144444"));
        System.out.println("Prestiti scaduti: " + loanDAO.findOverdueLoans());

        em.close();
        emf.close();
    }

    private static Date parseDate(String dateStr) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

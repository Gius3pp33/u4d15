package giuseppelongo.DAO;

import giuseppelongo.entities.Loan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class LoanDAO extends GenericDAO<Loan> {
    public LoanDAO(EntityManager em) {
        super(em);
    }

    public List<Loan> findCurrentLoansByUserCardNumber(String cardNumber) {
        String query = "SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber AND l.actualReturnDate IS NULL";
        TypedQuery<Loan> typedQuery = em.createQuery(query, Loan.class);
        typedQuery.setParameter("cardNumber", cardNumber);
        return typedQuery.getResultList();
    }

    public List<Loan> findOverdueLoans() {
        Date today = new Date();
        String query = "SELECT l FROM Loan l WHERE l.expectedReturnDate < :today AND l.actualReturnDate IS NULL";
        TypedQuery<Loan> typedQuery = em.createQuery(query, Loan.class);
        typedQuery.setParameter("today", today);
        return typedQuery.getResultList();
    }
}

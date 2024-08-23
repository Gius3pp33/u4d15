package giuseppelongo.entities;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_card_number", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "item_isbn", nullable = false)
    private BookMagazineCategory item;

    @Temporal(TemporalType.DATE)
    private Date loanDate;

    @Temporal(TemporalType.DATE)
    private Date expectedReturnDate;

    @Temporal(TemporalType.DATE)
    private Date actualReturnDate;

    // Costruttori
    public Loan() {
    }

    public Loan(User user, BookMagazineCategory item, Date loanDate) {
        this.user = user;
        this.item = item;
        this.loanDate = loanDate;
        this.expectedReturnDate = calculateExpectedReturnDate(loanDate);
    }

    // Metodo per calcolare la data di restituzione prevista
    private Date calculateExpectedReturnDate(Date loanDate) {
        // Calcola la data di restituzione prevista (30 giorni dopo la data di inizio)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loanDate);
        calendar.add(Calendar.DAY_OF_MONTH, 30);
        return calendar.getTime();
    }

    // Getters e Setters
    // ...

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", item=" + item +
                ", loanDate=" + loanDate +
                ", expectedReturnDate=" + expectedReturnDate +
                ", actualReturnDate=" + actualReturnDate +
                '}';
    }
}

package giuseppelongo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "magazines")
public class Magazine extends BookMagazineCategory {
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    // Costruttore
    public Magazine() {
    }

    public Magazine(String isbn, String title, Date publicationYear, int numberPages, Periodicity periodicity) {
        super(isbn, title, publicationYear, numberPages);
        this.periodicity = periodicity;
    }

    // Getters and Setters
    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "ISBN='" + getIsbn() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", numberPages=" + getNumberPages() +
                ", periodicity=" + periodicity +
                '}';
    }

    public enum Periodicity {
        WEEKLY, MONTHLY, SEMESTRAL
    }
}

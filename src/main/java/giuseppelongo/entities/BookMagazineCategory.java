package giuseppelongo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "books_magazines_categories")
@Inheritance(strategy = InheritanceType.JOINED)
public class BookMagazineCategory {

    @Id
    @Column(name = "ISBN")
    private String isbn;

    private String title;

    @Temporal(TemporalType.DATE)
    private Date publicationYear;

    private int numberPages;

    // Costruttore
    public BookMagazineCategory() {
    }

    public BookMagazineCategory(String isbn, String title, Date publicationYear, int numberPages) {
        this.isbn = isbn;
        this.title = title;
        this.publicationYear = publicationYear;
        this.numberPages = numberPages;
    }

    // Getters and Setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Date publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    @Override
    public String toString() {
        return "BookMagazineCategory{" +
                "ISBN='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", numberPages=" + numberPages +
                '}';
    }
}

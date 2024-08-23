package giuseppelongo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "books")
public class Book extends BookMagazineCategory {
    private String authors;
    private String genres;

    // Costruttore
    public Book() {
    }

    public Book(String isbn, String title, Date publicationYear, int numberPages, String authors, String genres) {
        super(isbn, title, publicationYear, numberPages);
        this.authors = authors;
        this.genres = genres;
    }

    // Getters and Setters
    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + getIsbn() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", publicationYear=" + getPublicationYear() +
                ", numberPages=" + getNumberPages() +
                ", authors='" + authors + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }

}

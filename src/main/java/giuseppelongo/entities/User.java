package giuseppelongo.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "card_number")
    private String cardNumber;

    private String name;
    private String surname;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    // Costruttore
    public User() {
    }

    public User(String cardNumber, String name, String surname, Date birthDate) {
        this.cardNumber = cardNumber;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    // Getters and Setters
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "cardNumber='" + cardNumber + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

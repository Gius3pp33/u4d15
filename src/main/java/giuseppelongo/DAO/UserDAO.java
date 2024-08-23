package giuseppelongo.DAO;

import giuseppelongo.entities.User;
import jakarta.persistence.EntityManager;

public class UserDAO extends GenericDAO<User> {
    public UserDAO(EntityManager em) {
        super(em);
    }

    // Ricerca per numero di tessera
    public User findByCardNumber(String cardNumber) {
        return find(User.class, cardNumber);
    }
}

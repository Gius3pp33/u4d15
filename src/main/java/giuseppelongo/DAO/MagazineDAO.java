package giuseppelongo.DAO;

import giuseppelongo.entities.Magazine;
import jakarta.persistence.EntityManager;

public class MagazineDAO extends GenericDAO<Magazine> {

    public MagazineDAO(EntityManager em) {
        super(em);
    }


}
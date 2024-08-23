package giuseppelongo.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public abstract class GenericDAO<T> {

    protected EntityManager em;

    public GenericDAO(EntityManager em) {
        this.em = em;
    }

    public void save(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(entity);
        transaction.commit();
    }

    public T find(Class<T> clazz, String id) {
        return em.find(clazz, id);
    }

    public void update(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.merge(entity);
        transaction.commit();
    }

    public void delete(T entity) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        transaction.commit();
    }

    public List<T> findAll(String query, Class<T> clazz) {
        return em.createQuery(query, clazz).getResultList();
    }
}
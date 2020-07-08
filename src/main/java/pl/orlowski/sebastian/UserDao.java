package pl.orlowski.sebastian;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {
    private EntityManager em;

    public UserDao() {
        this.em = DBConfig.getEntityManagerFactory().createEntityManager();
    }
    public List getAllUsers() {
        return em.createQuery("SELECT u from User u").getResultList();
    }

    public User returnUser(int id) {
        User user = em.find(User.class, id);
        em.close();
        return user;
    }
}

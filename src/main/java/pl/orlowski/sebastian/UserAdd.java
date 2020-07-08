package pl.orlowski.sebastian;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaEELearning");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        try {
            entityTransaction.begin();
            User user = new User();
            user.setName("Alicja");
            user.setLastName("Pawlowska");
            user.setAge(22);
            entityManager.persist(user);
            entityTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}

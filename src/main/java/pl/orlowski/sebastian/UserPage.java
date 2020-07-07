package pl.orlowski.sebastian;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JavaEELearning");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User u1 = entityManager.find(User.class, 1);
        resp.getWriter().println("Użytkownik " + u1.getName() + " " + u1.getLastName());

        entityManager.close();
        entityManagerFactory.close();

    }
}

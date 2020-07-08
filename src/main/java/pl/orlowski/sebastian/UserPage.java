package pl.orlowski.sebastian;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserPage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=utf-8");
        UserDao dao = new UserDao();
        List<User> lista = dao.getAllUsers();
        for (User u : lista) {
            resp.getWriter().println("Użytkownik: " + u.getName() + " " + u.getLastName());
        }

    }
}

package pl.orlowski.sebastian;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User u1 = new User();
        u1.setId(1L);
        u1.setName("Sebastian");
        u1.setLastName("Orlowski");
        request.setAttribute("user", u1);
        User u2 = new User();
        u2.setId(2L);
        u2.setName("Andrzej");
        u2.setLastName("Nowak");
        request.setAttribute("lista", Arrays.asList(u1, u2));
        request.setAttribute("kwota", 299.99);
        request.setAttribute("data", new Date());
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}

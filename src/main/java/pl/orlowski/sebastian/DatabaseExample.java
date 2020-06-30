package pl.orlowski.sebastian;

import com.mysql.jdbc.Driver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class DatabaseExample extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection conn = driver.connect("jdbc:mysql://localhost/learning_javaee?user=root&amp;password=&characterEncoding=utf8",null);
            Statement stmt = conn.createStatement();

            if (stmt.execute("SELECT * FROM users")) {
                ResultSet set = stmt.getResultSet();

                while (set.next()) {
                    response.getWriter().println(set.getString("name") + " " + set.getString("lastName") + "\n");
                }
            }
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}

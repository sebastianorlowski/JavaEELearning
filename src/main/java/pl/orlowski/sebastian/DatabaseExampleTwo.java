package pl.orlowski.sebastian;

import com.mysql.jdbc.Driver;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class DatabaseExampleTwo extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=utf-8");
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            Connection conn = driver.connect("jdbc:mysql://localhost/learning_javaee?user=root&amp;password=&characterEncoding=utf8",null);
            PreparedStatement psmt = conn.prepareStatement("INSERT INTO users VALUES(NULL, ?, ?)");
            psmt.setString(1, "Sebastian");
            psmt.setString(2, "Orlowski");
            if (psmt.executeUpdate() > 0) {
                response.getWriter().println("Record has been added!");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

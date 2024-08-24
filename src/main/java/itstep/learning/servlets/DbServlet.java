package itstep.learning.servlets;
//jdbc:mysql://localhost:3308/JAVA_SPU_221
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class DbServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //підключення до БД
    //JDBC (~ADO/PDO) - уніфікована технологія доступу
    //підключення - інструкція - результат
        Connection connection = null;
        Driver mySqlDriver = null;
        try {
            mySqlDriver =   new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mySqlDriver);
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/JAVA_SPU_221_LOC?useUnicode=true&characterEncoding=UTF-8", "user_221", "pass_221");
            String sql = "SHOW DATABASES";
            Statement stmt = connection.createStatement(); // analog SqlCommand
            ResultSet res =  stmt.executeQuery(sql); // sqlDataReader
            List<String> dataBases = new ArrayList();
            while (res.next()) {
                dataBases.add(res.getString(1)); //!! нумерація у JDBC починається з 1
            }
            req.setAttribute("dataBases", dataBases);
            res.close();
            stmt.close();

        }

        catch (SQLException ex) {
           req.setAttribute("dbError", ex.getMessage());
        }

        req.setAttribute("pageBody", "db.jsp");
        req.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(req, resp);
    }

}


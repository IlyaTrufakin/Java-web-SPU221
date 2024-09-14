package itstep.learning.servlets;
//jdbc:mysql://localhost:3308/JAVA_SPU_221

import com.google.inject.Inject;
import com.google.inject.Singleton;
import itstep.learning.Data.dal.UserDao;

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
    private final Connection connection;
    private final UserDao userDao;

    @Inject
    public DbServlet(Connection connection, UserDao userDao) {
        this.connection = connection;
        this.userDao = userDao;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //підключення до БД
        //JDBC (~ADO/PDO) - уніфікована технологія доступу
        //підключення - інструкція - результат
        List<String> dataBases = new ArrayList();
        try {
            String sql = "SHOW DATABASES";
            Statement stmt = connection.createStatement(); // analog SqlCommand
            ResultSet res = stmt.executeQuery(sql); // sqlDataReader
            while (res.next()) {
                dataBases.add(res.getString(1)); //!! нумерація у JDBC починається з 1
            }
            res.close();
            stmt.close();

        } catch (SQLException ex) {
            req.setAttribute("dbError", ex.getMessage());
        }


        try{
            userDao.installTable();
            dataBases.add("Install Users OK");
        }
        catch (Exception ex) {
            req.setAttribute("dbError", ex.getMessage());
        }
        req.setAttribute("dataBases", dataBases);
        req.setAttribute("pageBody", "db.jsp");
        req.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(req, resp);
    }

}

/*
JSON (API)                                      DAL - data access layer
    \                                               | User DAO
DB --ORM--> DTO (Data transfer Obj  or  Entity) --> | CHAT DAO --->  Controller
    /                                               | GOODS DAO
FILE



 */
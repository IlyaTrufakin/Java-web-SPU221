package itstep.learning.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("fromServlet", "HomeServlet");  // ViewData["fromServlet"] = "HomeServlet"
        req.setAttribute("pageBody", "index.jsp");
        // return View()
        req.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(req, resp);
    }
}



/*
сервлети це спеціалізовані класи для мережевих задач
У веб проєктах грають роль контролерів (API - контролерів)
 */
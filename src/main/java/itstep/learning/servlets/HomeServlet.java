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

        resp.setContentType("text/html");

        // Получите PrintWriter для записи ответа
        PrintWriter out = resp.getWriter();

        // Запишите содержимое ответа
        out.println("<html>");
        out.println("<head><title>Home Servlet</title></head>");
        out.println("<body>");
        out.println("<h1>Добро пожаловать в Home Servlet</h1>");
        out.println("<p>Это простой пример сервлета.</p>");
        out.println("</body>");
        out.println("</html>");

        // Закройте PrintWriter
        out.close();
    }
}

/*
сервлети це спеціалізовані класи для мережевих задач
У веб проєктах грають роль контролерів (API - контролерів)
 */
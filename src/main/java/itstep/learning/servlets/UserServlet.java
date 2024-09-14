package itstep.learning.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.inject.Singleton;
import itstep.learning.Data.dto.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //      String name = req.getParameter("name");
        //      String email = req.getParameter("email");
        //     String password = req.getParameter("password");
        //req.getInputStream() - прямой доступ к телу запроса
        //req.getReader() - для чтения как String

        Gson gson = new Gson();
        JsonObject body = gson.fromJson(req.getReader(), JsonObject.class);
        String name = body.get("name").getAsString();


        resp.getWriter().print("Works " + name);

    }
}


/*
REST - representation state transfer
совокупность требований к архитектуре и работе серверной части
особенности:
- отсутсвие "памяти" - каждый запрос обрабатывается как новый
- http  сессии не допускаются
- каждій запрос должен содержать сведения про историю (при ее наявности),
как правило - єто данные авторизации - токен
- постоянность структуры запросов и ответов
например данные про локализацию - передаются в запросах одинаковым образом:
например заголовок - Location: en-Us
или query-параметр ... &lang=uk
каждый параметр который может быть в различных запросах, передается одинаковым способом во всех запросах.


 */
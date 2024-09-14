package itstep.learning.servlets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import itstep.learning.Data.dal.UserDao;
import itstep.learning.Data.dto.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Singleton
public class UserServlet extends HttpServlet {
    private final UserDao userDao;

    @Inject
    public UserServlet(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*
              String name = req.getParameter("name");
              String email = req.getParameter("email");
             String password = req.getParameter("password");
        req.getInputStream() - прямой доступ к телу запроса
        req.getReader() - для чтения как String
        Gson gson = new Gson();
        */

        Gson gson = new GsonBuilder()
                .serializeNulls()
                .disableHtmlEscaping()
                .create();

        JsonObject body = gson.fromJson(req.getReader(), JsonObject.class);
        String name = body.get("name").getAsString();
        String email = body.get("email").getAsString();
        String password = body.get("password").getAsString();

        JsonObject respBody;
        if (name == null || email == null || password == null) {
            respBody = getErrorBody(req, "Bad Request: name or email or password missed or empty");
        } else {
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPasswordHash(password);
            if (userDao.singUpUser(user)) {
                respBody = getSuccessBody(req, gson.toJsonTree(user));
            } else {
                respBody = getErrorBody(req, "Error, See server logg");
            }
        }

        resp.setContentType("application/json");
        resp.getWriter().print(gson.toJson(respBody));

    }

    private JsonObject getSuccessBody(HttpServletRequest req, JsonElement body) {
        JsonObject respBody = new JsonObject();

        JsonObject status = new JsonObject();
        status.addProperty("isOK", true);
        status.addProperty("code", 0);
        status.addProperty("httpcode", 200);
        status.addProperty("phrase", "OK");
        respBody.add("status", status);

        JsonObject meta = new JsonObject();
        meta.addProperty("service", "User");
        meta.addProperty("action", "SignUp");
        meta.addProperty("location", req.getContextPath() + "/User");
        meta.addProperty("serverTime", System.nanoTime());
        meta.addProperty("locale", "Uk-UA");
        meta.addProperty("count", 0);
        respBody.add("meta", meta);

        respBody.add("body", body);

        return respBody;
    }

    private JsonObject getErrorBody(HttpServletRequest req, String text) {
        JsonObject respBody = new JsonObject();

        JsonObject status = new JsonObject();
        status.addProperty("isOK", false);
        status.addProperty("code", -1);
        status.addProperty("httpcode", 400);
        status.addProperty("phrase", text);
        respBody.add("status", status);

        JsonObject meta = new JsonObject();
        meta.addProperty("service", "User");
        meta.addProperty("action", "SignUp");
        meta.addProperty("location", req.getContextPath() + "/User");
        meta.addProperty("serverTime", System.nanoTime());
        meta.addProperty("locale", "Uk-UA");
        meta.addProperty("count", 0);
        respBody.add("meta", meta);

        JsonObject restData = new JsonObject();
        respBody.add("body", restData);

        return respBody;
    }
}


/*
REST - representation state transfer
совокупность требований к архитектуре и работе серверной части
особенности:
- отсутствие "памяти" - каждый запрос обрабатывается как новый
- http сессии не допускаются
- каждый запрос должен содержать сведения про историю (при ее наличии),
как правило - єто данные авторизации - токен
- постоянность структуры запросов и ответов
например данные про локализацию - передаются в запросах одинаковым образом:
например заголовок - Location: en-Us
или query-параметр ... &lang=uk
каждый параметр который может быть в различных запросах, передается одинаковым способом во всех запросах.
ответы также имеют постоянную структуру, т.е. эти данные находятся в одних и тех же "местах"
вариант:
Status-Meta-Data
ответ состоит из 3х частей
например ответ передается кодом 200 HTTP-OK
но статус можно передать любой
{
    status: {
      isOK: true,
      code: -1,
      httpcode:400,
      phrase: "Bad request: 'name' parameter missed"
    },
    meta: {
       service: "User",
       action: "SignUp",
        location" "/JawaWeb/User",
        serverTime: 1234567890,
        count: 1,
        locale: "en-GB"
        page: 4
    },
    data: {
       id: "sdfgasdfa",
       name: "User"
       etc..
    }
}

 */
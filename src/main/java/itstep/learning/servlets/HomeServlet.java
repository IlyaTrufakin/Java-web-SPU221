package itstep.learning.servlets;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import itstep.learning.Services.hash.HashService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Singleton

public class HomeServlet extends HttpServlet {

    private final HashService digestHashService; // MD5
    private final HashService signatureHashService; // SHA
    @Inject
    public HomeServlet(
            @Named("digest") HashService digestHashService,
            @Named("signature") HashService signatureHashService.

    ) {
        this.digestHashService = digestHashService;
        this.signatureHashService = signatureHashService;
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   //viewData["fromServlet"] = "HomeServlet"
        req.setAttribute("fromServlet", digestHashService.digest("123") +
                " " +
                        digestHashService.digest("123"));  // ViewData["fromServlet"] = "HomeServlet"
        req.setAttribute("pageBody", "index.jsp");
        // return View()
        req.getRequestDispatcher("WEB-INF/views/_layout.jsp").forward(req, resp);
    }
}



/*
сервлети це спеціалізовані класи для мережевих задач
У веб проєктах грають роль контролерів (API - контролерів)
 */
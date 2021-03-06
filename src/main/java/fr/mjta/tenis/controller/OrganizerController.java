package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.OrganizerService;
import fr.mjta.tenis.models.Result;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/login")
public class OrganizerController extends HttpServlet {
    @EJB
    private OrganizerService organizerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (Objects.equals(login, "") || Objects.equals(password, "")) {
            request.setAttribute("result",new Result<>(false, "Login Failed"));
            doGet(request, response);
        }
        else {
            var result = organizerService.login(login, password);
            request.setAttribute("result", new Result<>(result, result ? "Login Successful" : "Login Failed"));

            if(!result){
                doGet(request, response);
                return;
            }

            var session = request.getSession();
            session.setAttribute("isAdmin", true);

            response.sendRedirect(request.getContextPath() + "/admin/consultMatches");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var session = request.getSession();
        var isAdmin = (Boolean) session.getAttribute("isAdmin");

        if(isAdmin != null && isAdmin){
            response.sendRedirect(request.getContextPath() + "/admin/consultMatches");
        }
        else {
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}

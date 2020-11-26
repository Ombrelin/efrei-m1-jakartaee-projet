package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.RefereeService;
import fr.mjta.tenis.models.Result;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/admin/registerReferee")
public class RefereeController extends HttpServlet {
    @EJB
    private RefereeService refereeService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Objects.equals(request.getParameter("name"), "") && !Objects.equals(request.getParameter("nationality"), "")) {
            String name = request.getParameter("name");
            String nationality = request.getParameter("nationality");

            var result = refereeService.registerReferee(name, nationality);
            request.setAttribute("result", new Result<>(result, result ? "Referee registered" : "Registration failed"));
        }else {
            request.setAttribute("result", new Result<>(false, "Failure"));
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registerReferee.jsp").forward(request, response);
    }
}

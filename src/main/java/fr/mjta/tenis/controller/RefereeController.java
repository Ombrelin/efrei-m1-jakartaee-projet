package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.OrganizerService;
import fr.mjta.tenis.domain.services.RefereeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerReferee")
public class RefereeController extends HttpServlet {
    @EJB
    private RefereeService refereeService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String nationality = request.getParameter("nationality");

        var result = refereeService.registerReferee(name, nationality);
        request.setAttribute("result", result ? "Referee registered" :"registration failed");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registerReferee.jsp").forward(request, response);
    }
}

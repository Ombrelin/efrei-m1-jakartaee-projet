package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.services.MatchService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/planMatch")
public class CreateMatchController extends HttpServlet {
    @EJB
    private MatchService matchService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
        String court = request.getParameter("court");

        matchService.planMatch(dateTime, court);
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/planMatch.jsp").forward(request, response);
    }
}

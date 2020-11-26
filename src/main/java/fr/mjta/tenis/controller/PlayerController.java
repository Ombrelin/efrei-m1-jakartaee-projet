package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.PlayerService;
import fr.mjta.tenis.models.Result;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/registerPlayer")
public class PlayerController extends HttpServlet {
    @EJB
    private PlayerService playerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String nationality = request.getParameter("nationality");
        int worldRank = Integer.parseInt(request.getParameter("worldrank"));

        boolean result;
        if (!name.isEmpty() && !gender.isEmpty() && !nationality.isEmpty() && worldRank > 0) {
            playerService.register(name, gender, nationality,worldRank);
            result = true;
        } else {
            result = false;
        }

        request.setAttribute("result", new Result<>(result, result ? "Create Successful" : "All fields are required"));
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/registerPlayer.jsp").forward(request, response);
    }
}

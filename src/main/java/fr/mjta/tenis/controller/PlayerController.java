package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.OrganizerService;
import fr.mjta.tenis.domain.services.PlayerService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register-player")
public class PlayerController extends HttpServlet {
    @EJB
    private PlayerService playerService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String nationality = request.getParameter("nationality");

        boolean result;
        if(!name.isEmpty() && !gender.isEmpty() && !nationality.isEmpty()){
            playerService.register(name, gender, nationality);
            result = true;
        }else{
            result = false;
        }

        request.setAttribute("result", result ? "Create Successful" :"All fields are required");
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/register-player.jsp").forward(request, response);
    }
}

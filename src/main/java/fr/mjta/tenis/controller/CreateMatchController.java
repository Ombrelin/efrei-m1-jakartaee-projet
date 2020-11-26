package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.MatchService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Objects;

@WebServlet("/admin/planMatch")
public class CreateMatchController extends HttpServlet {
    @EJB
    private MatchService matchService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Objects.equals(request.getParameter("court"), "") && !Objects.equals(request.getParameter("dateTime"), "")) {
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            String court = request.getParameter("court");
            if(LocalDateTime.now().isBefore(dateTime)){
                matchService.planMatch(dateTime, court);
                request.setAttribute("result", "Sucess");
            }
            else{
                request.setAttribute("result", "Can't create match with this date");
            }

        }
        else {
            request.setAttribute("result", "Failure");
        }
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/planMatch.jsp").forward(request, response);
    }
}

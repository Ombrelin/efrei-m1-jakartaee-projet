package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.entities.Court;
import fr.mjta.tenis.domain.services.CourtService;
import fr.mjta.tenis.domain.services.MatchService;
import fr.mjta.tenis.models.Result;

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

    @EJB
    private CourtService courtService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Objects.equals(request.getParameter("court"), "") && !Objects.equals(request.getParameter("dateTime"), "")) {
            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("dateTime"));
            String courtId = request.getParameter("court");

            Court court;

            try {
                court = courtService.get(courtId);
            }
            catch (Exception e) {
                request.setAttribute("result", new Result<>(true, "This court doesn't exist"));
                return;
            }


            if(LocalDateTime.now().isBefore(dateTime)){
                matchService.planMatch(dateTime, court);
                request.setAttribute("result", new Result<>(true, "Success"));
            }
            else{
                request.setAttribute("result", new Result<>(false, "Can't create match with this date"));
            }
            matchService.planMatch(dateTime, court);
            response.sendRedirect(request.getContextPath() + "/admin/consultMatches");
        }
        else {
            request.setAttribute("result", new Result<>(false, "Failure"));
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("courts", courtService.getAll());
        this.getServletContext().getRequestDispatcher("/WEB-INF/planMatch.jsp").forward(request, response);
    }
}

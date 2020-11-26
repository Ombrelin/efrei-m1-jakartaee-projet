package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.services.MatchService;
import fr.mjta.tenis.models.Result;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Set;

@WebServlet("/admin/resolveMatch")
public class ResolveMatchController extends HttpServlet {
    @EJB
    private MatchService matchService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (Objects.equals(request.getParameter("team1score"), "") || Objects.equals(request.getParameter("team2score"), "") || Objects.equals(request.getParameter("duration"), "")) {
            request.setAttribute("result", "Invalid form");
            this.getServletContext().getRequestDispatcher("/WEB-INF/resolveMatch.jsp").forward(request, response);
            return;
        }

        try {
            int team1score = Integer.parseInt(request.getParameter("team1score"));
            int team2score = Integer.parseInt(request.getParameter("team2score"));
            String durationStr = request.getParameter("duration");
            String matchId = request.getParameter("matchId");
            var duration = Duration.between(LocalTime.MIN, LocalTime.parse(durationStr));

            if(team1score < 0 || team2score < 0){
                request.setAttribute("result", "Invalid scores");
                this.getServletContext().getRequestDispatcher("/WEB-INF/resolveMatch.jsp").forward(request, response);
                return;
            }
            matchService.resolveMatch(matchId, team1score, team2score, duration);
            response.sendRedirect(request.getContextPath() + "/admin/consultMatches");
        } catch (Exception e) {
            request.setAttribute("result", new Result<>(false, "Invalid form : " + e.getMessage()));
            this.getServletContext().getRequestDispatcher("/WEB-INF/resolveMatch.jsp").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchId = request.getParameter("matchId");
        if (matchId == null || matchId.isBlank()) {
            response.sendRedirect(request.getContextPath() + "/error");
            return;
        }

        try{
            var match = matchService.getMatchToResolve(matchId);

            Set<Player> team1 = match.getTeam1();
            Set<Player> team2 = match.getTeam2();

            request.setAttribute("team1", team1);
            request.setAttribute("team2", team2);
            request.setAttribute("matchId", matchId);

            this.getServletContext().getRequestDispatcher("/WEB-INF/resolveMatch.jsp").forward(request, response);
        }catch(Exception e){
            request.setAttribute("errorMessage", e.getMessage());
            this.getServletContext().getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }

    }
}

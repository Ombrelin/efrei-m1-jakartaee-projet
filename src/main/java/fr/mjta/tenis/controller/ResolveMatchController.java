package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.entities.Player;
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
import java.util.Set;

@WebServlet("/resolveMatch")
public class ResolveMatchController extends HttpServlet {
    @EJB
    private MatchService matchService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!Objects.equals(request.getParameter("team1score"), "") && !Objects.equals(request.getParameter("team2score"), "")) {
            int team1score = Integer.parseInt(request.getParameter("team1score"));
            int team2score = Integer.parseInt(request.getParameter("team2score"));
            String matchId = request.getParameter("matchId");

            var result = matchService.resolveMatch(matchId, team1score, team2score);
            //request.setAttribute("result", result ? "Match successfully resolved" :"Error occurred while resolving math");

        }
        response.sendRedirect("/WEB-INF/consultMatches.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchId = request.getParameter("matchId");

        var match = matchService.getMatchToResolve(matchId);

        Set<Player> team1 = match.getTeam1();
        Set<Player> team2 = match.getTeam2();

        request.setAttribute("team1", team1);
        request.setAttribute("team2", team2);

        this.getServletContext().getRequestDispatcher("/WEB-INF/resolveMatch.jsp").forward(request, response);
    }
}

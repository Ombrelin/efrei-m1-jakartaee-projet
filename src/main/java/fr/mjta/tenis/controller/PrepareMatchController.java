package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;
import fr.mjta.tenis.domain.services.MatchService;
import fr.mjta.tenis.domain.services.PlayerService;
import fr.mjta.tenis.domain.services.RefereeService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@WebServlet("/admin/prepareMatch")
public class PrepareMatchController extends HttpServlet {
    @EJB
    private MatchService matchService;
    @EJB
    private PlayerService playerService;
    @EJB
    private RefereeService refereeService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ((!Objects.equals(request.getParameter("team1player1"), "")
                && !Objects.equals(request.getParameter("team2player1"), "")
                && !Objects.equals(request.getParameter("referee"), "")
                && !Objects.equals(request.getParameter("matchId"), ""))) {

            String team1player1 = request.getParameter("team1player1");
            String team2player1 = request.getParameter("team2player1");
            String refereeId = request.getParameter("referee");
            String matchId = request.getParameter("matchId");

            Player player1 = playerService.getById(team1player1);
            Player player2 = playerService.getById(team2player1);
            Set<Player> team1 = new HashSet<>();
            Set<Player> team2 = new HashSet<>();
            team1.add(player1);
            team2.add(player2);

            Referee referee = refereeService.getById(refereeId);

            matchService.prepareMatch(matchId, team1, team2, referee);


        }else if((!Objects.equals(request.getParameter("team1player1"), "")
                && !Objects.equals(request.getParameter("team1player2"), "")
                && !Objects.equals(request.getParameter("team2player1"), "")
                && !Objects.equals(request.getParameter("team2player2"), "")
                && !Objects.equals(request.getParameter("referee"), ""))){

            String team1player1 = request.getParameter("team1player1");
            String team1player2 = request.getParameter("team1player2");
            String team2player1 = request.getParameter("team2player1");
            String team2player2 = request.getParameter("team2player2");
            String refereeId = request.getParameter("referee");
            String matchId = request.getParameter("matchId");

            Player player1 = playerService.getById(team1player1);
            Player player2 = playerService.getById(team1player2);
            Player player3 = playerService.getById(team2player1);
            Player player4 = playerService.getById(team2player2);

            Set<Player> team1 = new HashSet<>();
            Set<Player> team2 = new HashSet<>();
            team1.add(player1);
            team1.add(player2);
            team2.add(player3);
            team2.add(player4);

            Referee referee = refereeService.getById(refereeId);

            matchService.prepareMatch(matchId, team1, team2, referee);
        }else{
            request.setAttribute("result", "Failure");
        }

        response.sendRedirect(request.getContextPath() +"/admin/consultMatches");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matchId = request.getParameter("matchId");

        var match = matchService.getMatchToPrepare(matchId);
        request.setAttribute("match", match);
        request.setAttribute("players", playerService.getAll());
        request.setAttribute("referees", refereeService.getAll());

        this.getServletContext().getRequestDispatcher("/WEB-INF/prepareMatch.jsp").forward(request, response);
    }
}

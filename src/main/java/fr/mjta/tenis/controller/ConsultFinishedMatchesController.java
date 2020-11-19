package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.MatchService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/consultFinishedMatches")
public class ConsultFinishedMatchesController extends HttpServlet {
	@EJB
	private MatchService matchService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("result", matchService.getFinishedMatches());
		this.getServletContext().getRequestDispatcher("/WEB-INF/consultFinishedMatches.jsp").forward(request, response);
	}
}

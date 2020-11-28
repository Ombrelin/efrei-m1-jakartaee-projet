package fr.mjta.tenis.controller;

import fr.mjta.tenis.domain.services.CourtService;
import fr.mjta.tenis.models.Result;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/registerCourt")
public class CourtController extends HttpServlet {

	@EJB
	private CourtService courtService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/registerCourt.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String number = request.getParameter("number");

		if(number == null || number.isBlank()) {
			request.setAttribute("result", new Result<>(false, "You must enter a court number"));
			doGet(request, response);
		}
		else {
			try {
				courtService.create(number);
				response.sendRedirect(request.getContextPath() + "/admin/planMatch");
			}
			catch (Exception e) {
				request.setAttribute("result", new Result<>(false, "This court already exist"));
				doGet(request, response);
			}
		}
	}
}

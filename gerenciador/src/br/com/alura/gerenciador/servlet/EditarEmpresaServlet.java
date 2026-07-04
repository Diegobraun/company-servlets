package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarEmpresaServlet
 */
@WebServlet("/EditarEmpresa")
public class EditarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		Empresa empresa = null;
		for (Empresa e : banco.getEmpresas()) {
			if (e.getId() == id) {
				empresa = e;
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("/EditarEmpresa.jsp");
		request.setAttribute("empresa", empresa);
		rd.forward(request, response);
		
	}

}

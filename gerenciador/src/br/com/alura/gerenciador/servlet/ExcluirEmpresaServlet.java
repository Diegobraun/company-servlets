package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluirEmpresaServlet
 */
@WebServlet("/ExcluirEmpresa")
public class ExcluirEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Banco banco = new Banco();
		Empresa e = null;
		
		for (Empresa empresa  : banco.getEmpresas()) {
			if (empresa.getId() == id) {
				e = empresa;
			}
		}
		
		banco.getEmpresas().remove(e);
		System.out.println(id);
		response.sendRedirect("ListaEmpresas"); 
	}

}

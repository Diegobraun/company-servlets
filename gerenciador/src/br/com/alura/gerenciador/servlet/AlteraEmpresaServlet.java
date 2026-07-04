package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlteraEmpresaServlet
 */
@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Banco banco = new Banco();
		Integer id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String data = req.getParameter("data");
		
		Empresa empresa = new Empresa();
		empresa.setId(id);
		empresa.setNome(nome);

		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(data);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		empresa.setDataAbertura(dataAbertura);
		int index = 0;
		for (int i = 0;i < banco.getEmpresas().size();i++) {
			if (banco.getEmpresas().get(i).getId() == id) {
				index = i;
			}
		}
		
		banco.getEmpresas().set(index, empresa);
		resp.sendRedirect("ListaEmpresas");
		
	}

}

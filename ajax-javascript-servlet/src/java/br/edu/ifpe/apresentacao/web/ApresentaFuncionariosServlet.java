/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.apresentacao.web;

import br.edu.ifpe.controladores.Fachada;
import br.edu.ifpe.negocio.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
@WebServlet(name = "ApresentaFuncionariosServlet", urlPatterns = {"/ApresentaFuncionariosServlet"})
public class ApresentaFuncionariosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Funcionario> funcionarios = Fachada.getInstance().recuperarFuncionarios();
        String json = "{\"funcionarios\":[";
        for (int i = 0; i < funcionarios.size(); i++) {
            Funcionario funcionario = funcionarios.get(i);
            json += "{";
            json += "\"codigo\":\"" + funcionario.getCodigo() + "\",";
            json += "\"nome\":\"" + funcionario.getNome() + "\",";
            json += "\"funcao\":\"" + funcionario.getFuncao() + "\"";
            json += "}";
            if (i < funcionarios.size() - 1) {
                json += ",";
            }
        }
        json += "]}";
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().write(json);
//	response.setContentType("text/html;charset=UTF-8");
//	try (PrintWriter out = response.getWriter()) {
//	    /* TODO output your page here. You may use following sample code. */
//	    out.println("<!DOCTYPE html>");
//	    out.println("<html>");
//	    out.println("<head>");
//	    out.println("<title>ApresentaFuncionarios</title>");
//	    out.println("</head>");
//	    out.println("<body>");
//	    out.println("<h1>Lista dos funcionarios cadastrados</h1>");
//	    out.println("<table border = '2'>");
//	    out.println("<tr>");
//	    out.println("<th>Código</th>");
//	    out.println("<th>Nome</th>");
//	    out.println("<th>Função</th>");
//	    out.println("</tr>");
//	    for (Funcionario funcionario : funcionarios) {
//		out.println("</tr>");
//		out.println("<td>" + funcionario.getCodigo() + "</td>");
//		out.println("<td>" + funcionario.getNome() + "</td>");
//		out.println("<td>" + funcionario.getFuncao() + "</td>");
//		out.println("</tr>");
//	    }
//	    out.println("</table>");
//	    out.println("</body>");
//	    out.println("</html>");
//	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

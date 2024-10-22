package Controllers;

import BancoDeDados.Medico;
import DAO.MedicoDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/modificarMedico")
public class modificarMedico extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apagar = request.getParameter("excluir");
        String alterar = request.getParameter("alterar");
        String crm = request.getParameter("crm");

        if(apagar != null && crm != null) {
            new MedicoDAO("sistemasaude", usuario, senha).delete(Integer.valueOf(crm));
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarMedicos.jsp");
            request.setAttribute("mensagem", "Médico excluído com sucesso!");
            dispatcher.forward(request, response);
        } else if(alterar != null && crm != null){
            Medico medico = new MedicoDAO("sistemasaude", usuario, senha).list_by_crm("medicos", Integer.valueOf(crm));
            RequestDispatcher dispatcher = request.getRequestDispatcher("alterarMedico.jsp");
            request.setAttribute("medico", medico);
            dispatcher.forward(request, response);
        }
    }
}
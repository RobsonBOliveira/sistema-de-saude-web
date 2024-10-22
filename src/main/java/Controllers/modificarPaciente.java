package Controllers;

import BancoDeDados.Paciente;
import DAO.PacienteDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/modificarPaciente")
public class modificarPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apagar = request.getParameter("excluir");
        String alterar = request.getParameter("alterar");
        String cpf = request.getParameter("cpf");

        if(apagar != null && cpf != null) {
            new PacienteDAO("sistemasaude", usuario, senha).delete(cpf);
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarPacientes.jsp");
            request.setAttribute("mensagem", "Paciente excluído com sucesso!");
            dispatcher.forward(request, response);
        } else if(alterar != null && cpf != null){
            Paciente paciente = new PacienteDAO("sistemasaude", usuario, senha).list_by_cpf("pacientes",cpf);
            RequestDispatcher dispatcher = request.getRequestDispatcher("alterarPaciente.jsp");
            request.setAttribute("paciente", paciente);
            dispatcher.forward(request, response);
        }
    }
}

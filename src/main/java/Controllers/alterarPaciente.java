package Controllers;

import BancoDeDados.Paciente;
import DAO.PacienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/alterarPaciente")
public class alterarPaciente extends HttpServlet {

    public alterarPaciente(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpfModificar = request.getParameter("cpfModificar");
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        Paciente paciente = new Paciente(cpf, nome, telefone);
        PacienteDAO pacientedao = new PacienteDAO("sistemasaude", usuario, senha);
        pacientedao.update(paciente, cpfModificar);

        response.sendRedirect("listarPacientes.jsp");
    }

}

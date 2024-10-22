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

@WebServlet("/cadastrarPaciente")
public class cadastrarPaciente extends HttpServlet {

    public cadastrarPaciente(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpfStr = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");

        Paciente paciente = new Paciente(cpfStr, nome, telefone);
        PacienteDAO pacientedao = new PacienteDAO("sistemasaude", usuario, senha);
        pacientedao.insert(paciente);

        response.sendRedirect("listarPacientes.jsp");
    }

}

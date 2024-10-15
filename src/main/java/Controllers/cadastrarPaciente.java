package Controllers;

import BancoDeDados.Paciente;
import DAO.PacienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
        PacienteDAO pacientedao = new PacienteDAO("sistemasaude", "postgres", "luiz2014");
        pacientedao.create_table("paciente");
        pacientedao.insert(paciente, "paciente");
    }

}

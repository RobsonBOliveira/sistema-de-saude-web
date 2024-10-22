package Controllers;


import BancoDeDados.Login;
import BancoDeDados.Medico;
import DAO.LoginDAO;
import DAO.MedicoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/cadastrarUsuarioMedico")
public class cadastrarUsuarioMedico extends HttpServlet {
    public cadastrarUsuarioMedico() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String crmStr = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String especializacao = request.getParameter("especializacao");

        Integer crm = Integer.parseInt(crmStr);

        try {
            LoginDAO logindao = new LoginDAO("sistemasaude", "admin", "admin");
            Login login = new Login(usuario, senha, nome);
            logindao.insert(login);

            MedicoDAO medicodao = new MedicoDAO("sistemasaude", "admin", "admin");
            Medico medico = new Medico(crm, nome, telefone, especializacao);
            medicodao.insert(medico);

            response.sendRedirect("loginUsuarioCadastrado.html");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("cadastrarUsuarioMedicoIncorreto.html");
        }
    }
}



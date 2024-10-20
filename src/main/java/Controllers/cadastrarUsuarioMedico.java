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
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            con = DriverManager.getConnection(URL, usuario, senha);
            Statement stm = con.createStatement();

            LoginDAO logindao = new LoginDAO("sistemasaude", "admin", "admin");
            Login login = new Login(usuario, senha, nome);
            logindao.insert(login);

            ResultSet rs = stm.executeQuery("select exists (select * from pg_tables where schemaname = 'public' " +
                    "and tablename = 'medicos')");
            MedicoDAO medicodao = new MedicoDAO("sistemasaude", "admin", "admin");
            Medico medico = new Medico(crm, nome, telefone, especializacao);
            if(rs.next()) {
                medicodao.create_table();
            }
            medicodao.insert(medico, "medicos");

            response.sendRedirect("loginUsuarioCadastrado.html");
        } catch (Exception e) {
            System.out.println(e);
            response.sendRedirect("cadastrarUsuarioMedicoIncorreto.html");
        }
    }
}



package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Objects;

@WebServlet("/cadastrarUsuario")
public class cadastrarUsuario extends HttpServlet {

    public cadastrarUsuario(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        String confirmarsenha = request.getParameter("confirmarsenha");

        if(Objects.equals(senha, confirmarsenha)){
           Connection con = null;
            try{
                Class.forName("org.postgresql.Driver");
                String URL = String.format("jdbc:postgresql://localhost:5432/sistemasaude");
                con = DriverManager.getConnection(URL, "admin", "admin");
                String sql = String.format("create user %s with password '%s';" +
                        "grant all privileges on schema public to %s", usuario, senha, usuario);
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
                response.sendRedirect("loginUsuarioCadastrado.html");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
            response.sendRedirect("cadastrarUsuarioIncorreto.html");
        }
    }
}

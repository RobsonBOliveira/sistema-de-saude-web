package Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/loginUsuario")
public class loginUsuario extends HttpServlet {

    public loginUsuario() {
        super();
    }

    private Connection con = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean conectado = false;

        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            con = DriverManager.getConnection(URL, login, senha);
            conectado = true;  // Se a conexão for bemsucedida
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erro na conexão: " + e.getMessage());
        }

        // Redireciona com base no status da conexão
        if (conectado) {
            response.sendRedirect("teste.html");
        } else {
            response.sendRedirect("loginUsuarioIncorreto.html");
        }
    }
}
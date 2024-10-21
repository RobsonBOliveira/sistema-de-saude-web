package Controllers;

import DAO.ExameDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/modificarExame")
public class modificarExame extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apagar = request.getParameter("excluir");
        String codigo_exame = request.getParameter("codigo_exame");

        if(apagar != null && codigo_exame != null) {
            new ExameDAO("sistemasaude", usuario, senha).delete(Integer.valueOf(codigo_exame));
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarExames.jsp");
            request.setAttribute("mensagem", "Exame excluído com sucesso!");
            dispatcher.forward(request, response);
        }
    }
}
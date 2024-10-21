package Controllers;

import DAO.ConsultaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/modificarConsulta")
public class modificarConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String apagar = request.getParameter("excluir");
        String codigo = request.getParameter("codigo");

        if(apagar != null && codigo != null) {
            new ConsultaDAO("sistemasaude", usuario, senha).delete(Integer.valueOf(codigo));
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarConsultas.jsp");
            request.setAttribute("mensagem", "Consulta excluída com sucesso!");
            dispatcher.forward(request, response);
        }
    }
}
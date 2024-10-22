package Controllers;

import BancoDeDados.Consulta;
import BancoDeDados.Medico;
import DAO.ConsultaDAO;
import DAO.MedicoDAO;
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
        String alterar = request.getParameter("alterar");
        String codigo = request.getParameter("codigo");

        if(apagar != null && codigo != null) {
            new ConsultaDAO("sistemasaude", usuario, senha).delete(Integer.valueOf(codigo));
            RequestDispatcher dispatcher = request.getRequestDispatcher("listarConsultas.jsp");
            request.setAttribute("mensagem", "Consulta excluída com sucesso!");
            dispatcher.forward(request, response);
        }  else if(alterar != null && codigo != null){
            Consulta consulta = new ConsultaDAO("sistemasaude", usuario, senha).list_by_codigo("consultas", Integer.valueOf(codigo));
            RequestDispatcher dispatcher = request.getRequestDispatcher("alterarConsulta.jsp");
            request.setAttribute("consulta", consulta);
            dispatcher.forward(request, response);
        }
    }
}
package Controllers;


import BancoDeDados.Exame;
import DAO.ExameDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;


@WebServlet("/alterarExame")
public class alterarExame extends HttpServlet {
    public alterarExame() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codigo_exameAlterar = request.getParameter("codigo_exameAlterar");
        String codigo_exameStr = request.getParameter("codigo_exame");
        String nome_paciente = request.getParameter("nome_paciente");
        String resultado = request.getParameter("resultado");

        Integer codigo_exame = Integer.parseInt(codigo_exameStr);
        Exame exame = new Exame(codigo_exame, nome_paciente, resultado);
        ExameDAO examedao = new ExameDAO("sistemasaude", usuario, senha);
        examedao.update(exame, Integer.valueOf(codigo_exameAlterar));
        response.sendRedirect("listarExames.jsp");
    }
}

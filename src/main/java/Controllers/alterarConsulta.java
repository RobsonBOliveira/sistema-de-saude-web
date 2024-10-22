package Controllers;

import BancoDeDados.Consulta;
import DAO.ConsultaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/alterarConsulta")
public class alterarConsulta extends HttpServlet{

    public alterarConsulta(){
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String codigoAlterar = request.getParameter("codigoAlterar");
        String codigoStr = request.getParameter("codigo");
        String data = request.getParameter("data");
        String observacao = request.getParameter("observacao");
        String crmStr = request.getParameter("crm");
        String nome_paciente = request.getParameter("nome_paciente");

        Integer codigo = Integer.parseInt(codigoStr);
        Integer crm = Integer.parseInt(crmStr);
        Consulta consulta = new Consulta(codigo, data, observacao, crm, nome_paciente);
        ConsultaDAO consultadao = new ConsultaDAO("sistemasaude", usuario, senha);
        consultadao.update(consulta, Integer.valueOf(codigoAlterar));
        response.sendRedirect("listarConsultas.jsp");
    }
}

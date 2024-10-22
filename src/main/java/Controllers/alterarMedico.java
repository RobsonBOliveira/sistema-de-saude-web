package Controllers;


import BancoDeDados.Medico;
import DAO.MedicoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/alterarMedico")
public class alterarMedico extends HttpServlet {
    public alterarMedico() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String crmAlterar = request.getParameter("crmAlterar");
        String crmStr = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String especializacao = request.getParameter("especializacao");

        Integer crm = Integer.parseInt(crmStr);

            MedicoDAO medicodao = new MedicoDAO("sistemasaude", usuario, senha);
            Medico medico = new Medico(crm, nome, telefone, especializacao);
            medicodao.update(medico, Integer.valueOf(crmAlterar));

            response.sendRedirect("listarMedicos.jsp");
    }
}
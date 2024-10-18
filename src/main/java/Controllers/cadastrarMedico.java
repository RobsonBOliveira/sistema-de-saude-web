package Controllers;


import BancoDeDados.Medico;
import DAO.MedicoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Controllers.loginUsuario.senha;
import static Controllers.loginUsuario.usuario;

@WebServlet("/cadastrarMedico")
public class cadastrarMedico extends HttpServlet {
    public cadastrarMedico(){
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String crmStr = request.getParameter("crm");
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("telefone");
        String especializacao = request.getParameter("especializacao");

        Integer crm = Integer.parseInt(crmStr);
        Medico medico = new Medico(crm, nome, telefone, especializacao);
        MedicoDAO medicodao = new MedicoDAO("sistemasaude", usuario, senha);
        medicodao.create_table("medicos");
        medicodao.insert(medico, "medicos");
    }
}



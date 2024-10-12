import BancoDeDados.Paciente;
import DAO.PacienteDAO;

import java.util.List;

public class Main {
    public static void main(String[] args){
        PacienteDAO pacientedao = new PacienteDAO("sistemasaude", "postgres", "1406");
        //Paciente paciente1 = new Paciente("111.111.111-11", "paciente1", "(11) 1111-1111");
        //Paciente paciente2 = new Paciente("222.222.222-22", "paciente2", "(22) 2222-2222");
        //Paciente paciente3 = new Paciente("333.333.333-33", "paciente3", "(33) 3333-3333");
        //Paciente paciente4 = new Paciente("444.444.444-44", "paciente4", "(44) 4444-4444");

        //pacientedao.create_table("pacientes_teste");
        //pacientedao.insert(paciente1, "pacientes_teste");
        //pacientedao.insert(paciente2, "pacientes_teste");
        //pacientedao.insert(paciente3, "pacientes_teste");
        //pacientedao.insert(paciente4, "pacientes_teste");

        //pacientedao.delete(paciente1, "pacientes_teste");

        List<Paciente> listadepacientes = pacientedao.list("pacientes_teste");
        for(Paciente paciente : listadepacientes)
                System.out.println(paciente);
    }
}

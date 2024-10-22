package BancoDeDados;

import DAO.PacienteDAO;

public class Paciente {
    private String cpf;
    private String nome;
    private String telefone;

    public Paciente(){
    }

    public Paciente(String cpf, String nome, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Paciente list_by_cpf(String cpf){
        return new PacienteDAO().list_by_cpf("pacientes", cpf);
    }

    @Override
    public String toString(){
        return "cpf="+cpf+" nome="+nome+" telefone="+telefone;
    }
}

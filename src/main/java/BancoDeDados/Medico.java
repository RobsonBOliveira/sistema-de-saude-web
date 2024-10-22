package BancoDeDados;

import DAO.MedicoDAO;

public class Medico {
    private int crm;
    private String nome;
    private String telefone;
    private String especializacao;

    public Medico(){
    }

    public Medico(int crm, String nome, String telefone, String especializacao) {
        this.crm = crm;
        this.nome = nome;
        this.telefone = telefone;
        this.especializacao = especializacao;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Medico list_by_crm(int crm){
        return new MedicoDAO().list_by_crm("medicos", crm);
    }

    @Override
    public String toString(){
        return "crm="+crm+" nome="+nome+" telefone="+telefone+" especializacao="+especializacao;
    }
}

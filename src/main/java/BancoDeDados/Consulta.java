package BancoDeDados;

import DAO.ConsultaDAO;
import DAO.PacienteDAO;

public class Consulta {
    private int codigo;
    private String data;
    private String observacao;
    private int crm;
    private String nome_paciente;

    public Consulta(){
    }

    public Consulta(int codigo, String data, String observacao, int crm, String nome_paciente) {
        this.codigo = codigo;
        this.data = data;
        this.observacao = observacao;
        this.crm = crm;
        this.nome_paciente = nome_paciente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public Consulta list_by_codigo(int codigo) {
        return new ConsultaDAO().list_by_codigo("consultas", codigo);
    }

    @Override
    public String toString(){
        return "codigo="+codigo+" data="+data+" obs="+observacao+" crm="+crm+" nome_paciente="+nome_paciente;
    }
}

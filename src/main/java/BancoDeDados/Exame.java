package BancoDeDados;

public class Exame {
    private int codigo_exame;
    private String nome_paciente;
    private String resultado;

    public Exame(){
    }

    public Exame(int codigo_exame, String nome_paciente, String resultado) {
        this.codigo_exame = codigo_exame;
        this.nome_paciente = nome_paciente;
        this.resultado = resultado;
    }

    public int getCodigo_exame() {
        return codigo_exame;
    }

    public void setCodigo_exame(int codigo_exame) {
        this.codigo_exame = codigo_exame;
    }

    public String getNome_paciente() {
        return nome_paciente;
    }

    public void setNome_paciente(String nome_paciente) {
        this.nome_paciente = nome_paciente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }



    @Override
    public String toString(){
        return "codigo_exame="+codigo_exame+" nome_paciente="+nome_paciente+" resultado="+resultado;
    }
}

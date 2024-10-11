package DAO;

import BancoDeDados.Consulta;
import BancoDeDados.Medico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private Connection con = null;

    public ConsultaDAO() {
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            String user = "postgres";
            String pass = "1406";
            this.con = DriverManager.getConnection(URL, user, pass);
            //System.out.println("Conexao bem sucedida.");
        } catch (Exception e) {
            throw new RuntimeException(e);
            //System.out.println("Conexao falhou.");
        }
    }

    public ConsultaDAO(String database_name, String user, String pass) {
        try {
            Class.forName("org.postgresql.Driver");
            String URL = String.format("jdbc:postgresql://localhost:5432/%s", database_name);
            this.con = DriverManager.getConnection(URL, user, pass);
            //System.out.println("Conexao bem sucedida.");
        } catch (Exception e) {
            throw new RuntimeException(e);
            //System.out.println("Conexao falhou.");
        }
    }

    public boolean create_table(String table_name) {
        String sql = String.format("create table %s (codigo int primary key, data varchar(10) not null," +
                " observacao varchar(100) not null, crm int not null, nome_paciente varchar(100) not null)", table_name);
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            //System.out.println("Tabela criada.");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean drop_table(String table_name) {
        String sql = "drop table " + table_name;
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Consulta> list(String table_name) {
        String sql = String.format("select * from %s order by codigo asc", table_name);
        List<Consulta> retorno = new ArrayList<>();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setCodigo(rs.getInt("codigo"));
                consulta.setData(rs.getString("data"));
                consulta.setObservacao(rs.getString("observacao"));
                consulta.setCrm(rs.getInt("crm"));
                consulta.setNome_paciente(rs.getString("nome_paciente"));
                retorno.add(consulta);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public boolean insert(Consulta consulta, String table_name) {
        String sql = String.format("insert into %s (codigo, data, observacao, crm, nome_paciente) values (%s,'%s'," +
                        "'%s',%s,'%s')", table_name, consulta.getCodigo(), consulta.getData(), consulta.getObservacao(),
                consulta.getCrm(), consulta.getNome_paciente());
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Consulta consulta, String table_name) {
        String sql = String.format("update %s set data='%s', observacao='%s', crm=%s, nome_paciente='%s' where codigo=%s",
                table_name, consulta.getData(), consulta.getObservacao(), consulta.getCrm(),
                consulta.getNome_paciente());
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //resolver esse update(se tiver o mesmo nome muda de todos)
    public boolean update_codigo(Consulta consulta, String table_name) {
        String sql = String.format("update %s set codigo=%s where nome_paciente='%s'",
                table_name, consulta.getData(), consulta.getObservacao(), consulta.getCrm(),
                consulta.getNome_paciente());
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(Consulta consulta, String table_name) {
        String sql = String.format("delete from %s where codigo=%s", table_name, consulta.getCodigo());
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}

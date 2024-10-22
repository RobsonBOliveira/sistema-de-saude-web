package DAO;

import BancoDeDados.Exame;
import BancoDeDados.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExameDAO {

    private Connection con = null;

    public ExameDAO(){
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            String user = "postgres";
            String pass = "luiz2014";
            this.con = DriverManager.getConnection(URL, user, pass);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public ExameDAO(String database_name, String user, String pass){
        try{
            Class.forName("org.postgresql.Driver");
            String URL =String.format( "jdbc:postgresql://localhost:5432/%s", database_name);
            this.con = DriverManager.getConnection(URL, user, pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create_table(){
        String sql = "create table exames(codigo_exame int primary key," +
                "nome_paciente varchar(100) not null, resultado varchar(100));";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean drop_table(String table_name){
        String sql = "drop table " + table_name;
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<Exame> list(String table_name){
        String sql = String.format( "select * from %s order by codigo_exame asc", table_name);
        List<Exame> retorno = new ArrayList<>();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Exame exame = new Exame();
                exame.setCodigo_exame(rs.getInt("codigo_exame"));
                exame.setNome_paciente(rs.getString("nome_paciente"));
                exame.setResultado(rs.getString("resultado"));
                retorno.add(exame);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public Exame list_by_codigo_exame(String table_name, int codigo_exame){
        String sql = String.format( "select * from %s where codigo_exame=%s", table_name, codigo_exame);
        Exame retorno = new Exame();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Exame exame = new Exame();
                exame.setCodigo_exame(rs.getInt("codigo_exame"));
                exame.setNome_paciente(rs.getString("nome_paciente"));
                exame.setResultado(rs.getString("resultado"));
                retorno = exame;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public boolean insert(Exame exame){
        String sql = String.format( "insert into exames(codigo_exame, nome_paciente, resultado) values (%s,'%s','%s')",
                exame.getCodigo_exame(), exame.getNome_paciente(), exame.getResultado());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Exame exame, int codigo_exame){
        String sql = String.format( "update exames set codigo_exame=%s, nome_paciente='%s', resultado='%s' where " +
                "codigo_exame=%s", exame.getCodigo_exame(), exame.getNome_paciente(), exame.getResultado(),  codigo_exame);
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update_codigoexame(Exame exame, String table_name){
        String sql = String.format("update %s set codigo_exame=%s where nome_paciente='%s'",
                table_name, exame.getCodigo_exame(), exame.getNome_paciente());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int codigo_exame) {
        String sql = String.format("delete from exames where codigo_exame=%s",codigo_exame);
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

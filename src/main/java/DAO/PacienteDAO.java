package DAO;

import BancoDeDados.Paciente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Connection con = null;

    public PacienteDAO(){
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            String user = "postgres";
            String pass = "luiz2014";
            this.con = DriverManager.getConnection(URL, user, pass);
            System.out.println("Conexao bem sucedida.");
        }catch (Exception e){
        System.out.println(e);
      }
    }

    public PacienteDAO(String database_name, String user, String pass){
            try{
                Class.forName("org.postgresql.Driver");
                String URL =String.format( "jdbc:postgresql://localhost:5432/%s", database_name);
                this.con = DriverManager.getConnection(URL, user, pass);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public boolean create_table(){
        String sql = "create table pacientes(cpf varchar(14) primary key, " +
                "nome varchar(100) not null, telefone varchar(14));";
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

    public List<Paciente> list(String table_name){
        String sql = String.format("select * from %s order by cpf asc", table_name);
        List<Paciente> retorno = new ArrayList<>();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Paciente paciente = new Paciente();
                paciente.setCpf(rs.getString("cpf"));
                paciente.setNome(rs.getString("nome"));
                paciente.setTelefone(rs.getString("telefone"));
                retorno.add(paciente);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public boolean insert(Paciente paciente){
        String sql = String.format( "insert into pacientes (cpf, nome, telefone) values ('%s','%s','%s')",
                paciente.getCpf(), paciente.getNome(), paciente.getTelefone());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Paciente paciente, String cpf){
        String sql = String.format( "update pacientes set cpf='%s', nome='%s', telefone='%s' where cpf='%s'",
                paciente.getCpf(), paciente.getNome(), paciente.getTelefone(),  cpf);
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update_cpf(Paciente paciente, String table_name){
        String sql = String.format("update %s set cpf='%s' where nome='%s'",
                table_name, paciente.getCpf(), paciente.getNome());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(String cpf) {
        String sql = String.format("delete from pacientes where cpf='%s'", cpf);
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

package DAO;

import BancoDeDados.Medico;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {
    private Connection con = null;

    public MedicoDAO(){
        try{
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

    public MedicoDAO(String database_name, String user, String pass){
        try{
            Class.forName("org.postgresql.Driver");
            String URL =String.format( "jdbc:postgresql://localhost:5432/%s", database_name);
            this.con = DriverManager.getConnection(URL, user, pass);
            //System.out.println("Conexao bem sucedida.");
        } catch (Exception e) {
            throw new RuntimeException(e);
            //System.out.println("Conexao falhou.");
        }
    }

    public boolean create_table(){
        String sql = "create table medicos(crm int primary key, nome varchar(100) not null," +
                "telefone varchar(14) not null, especializacao varchar(100) not null);";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            //System.out.println("Tabela Criada");
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
            //System.out.println("Tabela deletada.");
            return true;
        }catch (Exception e){
            System.out.println(e);
            //System.out.println("Deleção falhou.");
            return false;
        }
    }

    public List<Medico> list(String table_name){
        String sql = "select * from %s order by crm asc" + table_name;
        List<Medico> retorno = new ArrayList<>();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Medico medico = new Medico();
                medico.setCrm(rs.getInt("crm"));
                medico.setNome(rs.getString("nome"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setEspecializacao(rs.getString("especializacao"));
                retorno.add(medico);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public boolean insert(Medico medico, String table_name){
        String sql = String.format( "insert into %s (crm, nome, telefone, especializacao) values (%s,'%s','%s','%s')",
                table_name, medico.getCrm(), medico.getNome(), medico.getTelefone(), medico.getEspecializacao());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Medico medico, String table_name){
        String sql = String.format( "update %s set nome='%s', telefone='%s', especializacao='%s' where crm=%s",
                table_name, medico.getNome(), medico.getTelefone(), medico.getEspecializacao(), medico.getCrm());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update_crm(Medico medico, String table_name){
        String sql = String.format("update %s set crm=%s where nome='%s'", table_name, medico.getCrm(), medico.getNome());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(Medico medico, String table_name) {
        String sql = String.format("delete from %s where crm=%s", table_name, medico.getCrm());
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

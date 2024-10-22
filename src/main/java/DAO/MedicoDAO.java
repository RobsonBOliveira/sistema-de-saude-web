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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public MedicoDAO(String database_name, String user, String pass){
        try{
            Class.forName("org.postgresql.Driver");
            String URL =String.format( "jdbc:postgresql://localhost:5432/%s", database_name);
            this.con = DriverManager.getConnection(URL, user, pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean create_table(){
        String sql = "create table medicos(crm int primary key, nome varchar(100) not null," +
                "telefone varchar(14) not null, especializacao varchar(100) not null);";
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

    public List<Medico> list(String table_name){
        String sql = String.format("select * from %s order by crm asc", table_name);
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

    public Medico list_by_crm(String table_name, int crm){
        String sql = String.format("select * from %s where crm=%s", table_name, crm);
        Medico retorno = new Medico();
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Medico medico = new Medico();
                medico.setCrm(rs.getInt("crm"));
                medico.setNome(rs.getString("nome"));
                medico.setTelefone(rs.getString("telefone"));
                medico.setEspecializacao(rs.getString("especializacao"));
                retorno = medico;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }

    public boolean insert(Medico medico){
        String sql = String.format( "insert into medicos (crm, nome, telefone, especializacao) values (%s,'%s','%s','%s')",
                medico.getCrm(), medico.getNome(), medico.getTelefone(), medico.getEspecializacao());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean update(Medico medico, int crm){
        String sql = String.format( "update medicos set crm=%s, nome='%s', telefone='%s', especializacao='%s' where crm=%s",
                medico.getCrm(), medico.getNome(), medico.getTelefone(), medico.getEspecializacao(), crm);
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

    public boolean delete(int crm) {
        String sql = String.format("delete from medicos where crm=%s",crm);
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

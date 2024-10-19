package DAO;

import BancoDeDados.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
    private Connection con = null;

    public LoginDAO() {
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

    public LoginDAO(String database_name, String user, String pass){
        try{
            Class.forName("org.postgresql.Driver");
            String URL =String.format( "jdbc:postgresql://localhost:5432/%s", database_name);
            this.con = DriverManager.getConnection(URL, user, pass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insert(Login login){
        String sql = String.format( "insert into login (usuario, senha, nome) values ('%s', '%s', '%s')",
                login.getUsuario(), login.getSenha(), login.getNome());
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String select_name(String usuario){
        String sql = String.format( "select nome from login where usuario = '%s'", usuario);
        String retorno = "error";
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            retorno = rs.getString("nome");

        } catch (Exception e) {
            System.out.println(e);
        }
        return retorno;
    }
}

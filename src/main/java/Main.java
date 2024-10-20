import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args){
        //coloque seu usuario do PostgreSQL
        String user = "postgres";
        //Coloque a sua senha do PostgreSQL
        String pass = "1406";

        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            con = DriverManager.getConnection(URL, user, pass);
            System.out.println("Conexão bem sucedida.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Conexão falhou.");
        }

        String criar_tabela_login = "create table login(usuario varchar(100) not null primary key," +
                "senha varchar(100) not null, nome varchar(50) not null)";
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(criar_tabela_login);
            System.out.println("Tabela criada.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Falha ao criar Tabela.");
        }

        String criar_user_admin = "create user admin with password 'admin';" +
                "grant ALL PRIVILEGES ON DATABASE sistemasaude to admin;"+
                "alter user admin createrole";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(criar_user_admin);
            System.out.println("Usuário admin criado com sucesso.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Falha ao criar usuario admin.");
        }

        String adicionar_admin_ao_login = "insert into login values ('admin','admin', 'admin')";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(adicionar_admin_ao_login);
            System.out.println("Adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Falha ao adicionar.");
        }
    }
}

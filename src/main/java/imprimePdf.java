import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static Controllers.cadastrarUsuario.senha;
import static Controllers.cadastrarUsuario.usuario;

@WebServlet("/imprimePdf")
public class imprimePdf extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String sql = "create or replace view visaoexames as select " +
                    "m.nome as nomemedico, " +
                    "p.nome as nomepaciente," +
                    "e.codigo_exame as codigoexame, " +
                    "e.resultado as resultadoexame " +
                    "from medicos m " +
                    "join consultas c on m.crm = c.crm " +
                    "join pacientes p on c.nome_paciente = p.nome " +
                    "join exames e on e.nome_paciente = p.nome ";

            Document doc = new Document();

            try {
                Connection con = null;
                Class.forName("org.postgresql.Driver");
                String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
                con = DriverManager.getConnection(URL, usuario, senha);
                Statement stm = con.createStatement();
                stm.executeUpdate(sql);
                sql = "select * from visaoexames";
                ResultSet rs = stm.executeQuery(sql);

                PdfWriter.getInstance(doc, response.getOutputStream());
                doc.open();
                int n = 1;
                while (rs.next()) {
                    Paragraph topico = new Paragraph("Exame " + n);
                    Paragraph p1 = new Paragraph("NOME MÉDICO: " + rs.getString("nomemedico"));
                    Paragraph p2 = new Paragraph("NOME PACIENTE: " + rs.getString("nomepaciente"));
                    Paragraph p3 = new Paragraph("CÓDIGO EXAME: " + rs.getString("codigoexame"));
                    Paragraph p4 = new Paragraph("RESULTADO: " + rs.getString("resultadoexame"));
                    Paragraph linha = new Paragraph(" ");

                    n++;
                    doc.add(topico);
                    doc.add(p1);
                    doc.add(p2);
                    doc.add(p3);
                    doc.add(p4);
                    doc.add(linha);
                }
                doc.close();
            } catch (Exception e) {
                System.out.println(e);
                response.sendRedirect("paginaPrincipal.jsp");
            }


    }
}

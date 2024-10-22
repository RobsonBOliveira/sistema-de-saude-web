<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page import="java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log</title>
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/listarConsultas.css">
</head>
<body>
<div class="header">
        <h1>Hospital Ufersa</h1>
</div>
<h2>Log:</h2>

<table>
    <tr>
        <th>Data</th>
        <th>Usuário</th>
        <th>Modificação</th>
    </tr>
    <%
        String sql = "select * from changelog";

            Connection con = null;
            Class.forName("org.postgresql.Driver");
            String URL = "jdbc:postgresql://localhost:5432/sistemasaude";
            con = DriverManager.getConnection(URL, usuario, senha);
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

        while(rs.next()){
    %>
    <tr>
            <td><%=rs.getDate("data")%></td>
            <td><%=rs.getString("usuario")%></td>
            <td><%=rs.getString("modificacao")%></td>
    </tr>
    <%}
    %>
</table>
</body>
</html>

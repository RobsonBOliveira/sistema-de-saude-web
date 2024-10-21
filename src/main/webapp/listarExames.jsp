<%@ page import="java.util.List" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page import="DAO.ExameDAO" %>
<%@ page import="BancoDeDados.Exame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Exames</title>
  <link rel="stylesheet" href="Style/listarExames.css">
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
<h2>Exames cadastrados:</h2>
<table>
  <tr>
    <th>CPF</th>
    <th>Nome</th>
    <th>Telefone</th>
  </tr>
  <%
    ExameDAO examedao = new ExameDAO("sistemasaude", usuario, senha);
    List<Exame> exames = examedao.list("pacientes");

    for(Exame exame: exames){
  %>
  <tr>
   <td><%= exame.getCodigo_exame()%></td>
    <td><%= exame.getNome_paciente()%></td>
    <td><%= exame.getResultado()%></td>
  </tr>
  <%}
  %>
</table>
</body>
</html>

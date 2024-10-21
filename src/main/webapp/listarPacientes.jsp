<%@ page import="DAO.PacienteDAO" %>
<%@ page import="BancoDeDados.Paciente" %>
<%@ page import="java.util.List" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pacientes</title>
    <link rel="stylesheet" href="Style/listarPacientes.css">
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
  <h2>Pacientes cadastrados:</h2>
<table>
  <tr>
    <th>CPF</th>
    <th>Nome</th>
    <th>Telefone</th>
  </tr>
  <%
    PacienteDAO pacientedao = new PacienteDAO("sistemasaude", usuario, senha);
    List<Paciente> pacientes = pacientedao.list("pacientes");

    for(Paciente paciente : pacientes){
  %>
  <tr>
    <td><%=paciente.getCpf()%></td>
    <td><%=paciente.getNome()%></td>
    <td><%=paciente.getTelefone()%></td>
  </tr>
  <%}
  %>
</table>
</body>
</html>

<%@ page import="DAO.PacienteDAO" %>
<%@ page import="BancoDeDados.Paciente" %>
<%@ page import="java.util.List" %>
<%@ page import="static Controllers.loginUsuario.usuario" %>
<%@ page import="static Controllers.loginUsuario.senha" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pacientes</title>
    <link rel="stylesheet" href="listarPacientes.css">
</head>
<body>
<table>
  <tr>
    <th>CPF</th>
    <th>Nome</th>
    <th>Telefone</th>
  </tr>
  <%
      System.out.println(usuario);
      System.out.println(senha);
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

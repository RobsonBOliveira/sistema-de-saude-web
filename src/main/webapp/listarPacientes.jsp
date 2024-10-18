<%@ page import="DAO.PacienteDAO" %>
<%@ page import="BancoDeDados.Paciente" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pacientes</title>
</head>
<body>
<table>
  <tr>
    <th>CPF</th>
    <th>Nome</th>
    <th>Telefone</th>
  </tr>
  <%PacienteDAO pacientedao = new PacienteDAO("sistemasaude", "admin", "admin");
    List<Paciente> pacientes = pacientedao.list("pacientes");

    for(Paciente paciente : pacientes){
  %>
  <tr>
    <td><%paciente.getCpf();%></td>
    <td><%paciente.getNome();%></td>
    <td><%paciente.getTelefone();%></td>
  </tr>
  <%}
  %>
</table>
</body>
</html>

<%@ page import="DAO.ConsultaDAO" %>
<%@ page import="BancoDeDados.Consulta" %>
<%@ page import="java.util.List" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Consultas</title>
  <link rel="stylesheet" href="Style/listarConsultas.css">
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
<h2>Consultas cadastradas:</h2>
<table>
  <tr>
    <th>Código</th>
    <th>Data</th>
    <th>Observação</th>
    <th>CRM</th>
    <th>Nome Paciente</th>
  </tr>
  <%
    ConsultaDAO consultadao = new ConsultaDAO("sistemasaude", usuario, senha);
    List<Consulta> consultas = consultadao.list("consultas");

    for(Consulta consulta : consultas) {
  %>
  <tr>
    <td><%=consulta.getCodigo()%></td>
    <td><%=consulta.getData()%></td>
    <td><%=consulta.getObservacao()%></td>
    <td><%=consulta.getCrm()%></td>
    <td><%=consulta.getNome_paciente()%></td>
  </tr>
  <%}
  %>
</table>
</body>
</html>

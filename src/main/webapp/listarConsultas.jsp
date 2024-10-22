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
  <link rel="stylesheet" href="Style/style.css">
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
<h2>Consultas cadastradas:</h2>
<div class="avisoExcluido">
  <%
    String mensagem = (String) request.getAttribute("mensagem");
    if(mensagem != null){%>
  <%=mensagem%>
  <%
    }%>
</div>
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
    <form action="modificarConsulta" method="post">
    <td><%=consulta.getCodigo()%></td>
      <input type="hidden" name="codigo" value="<%=consulta.getCodigo()%>">
    <td><%=consulta.getData()%></td>
    <td><%=consulta.getObservacao()%></td>
    <td><%=consulta.getCrm()%></td>
    <td><%=consulta.getNome_paciente()%></td>

    <td bgcolor="white" style="border: 0; width: 5vh; cursor: pointer;">
      <input id="botaoAlterar" type="submit" name="alterar" value="Alterar"></td>
    <td bgcolor="white" style="border: 0;width: 5vh; cursor: pointer;">
      <input id="botaoExcluir" type="submit" name="excluir" value="Excluir"></td>
    </form>
  </tr>
  <%}
  %>
</table>
</body>
</html>

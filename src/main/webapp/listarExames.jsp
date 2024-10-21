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
    <th>CPF</th>
    <th>Nome</th>
    <th>Telefone</th>
  </tr>
  <%
    ExameDAO examedao = new ExameDAO("sistemasaude", usuario, senha);
    List<Exame> exames = examedao.list("exames");

    for(Exame exame: exames){
  %>
  <tr>
      <form action="modificarExame" method="post">
   <td><%= exame.getCodigo_exame()%></td>
      <input type="hidden" name="codigo_exame" value="<%=exame.getCodigo_exame()%>">
    <td><%= exame.getNome_paciente()%></td>
    <td><%= exame.getResultado()%></td>

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

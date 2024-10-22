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
    <link rel="stylesheet" href="Style/style.css">
</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
  <h2>Pacientes cadastrados:</h2>

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
    PacienteDAO pacientedao = new PacienteDAO("sistemasaude", usuario, senha);
    List<Paciente> pacientes = pacientedao.list("pacientes");

    for(Paciente paciente : pacientes){
  %>
  <tr>
    <form action="modificarPaciente" method="post">
    <td><%=paciente.getCpf()%></td>
    <input type="hidden" name="cpf" value="<%=paciente.getCpf()%>">
    <td><%=paciente.getNome()%></td>
    <td><%=paciente.getTelefone()%></td>

    <td bgcolor="white" style="border: 0; width: 5vh; cursor: pointer;">
      <input id="botaoAlterar" type="submit" name="alterar" value="Alterar"></td>
    <td bgcolor="white" style="border: 0;width: 5vh; cursor: pointer;">
      <input id="botaoExcluir" type="submit" name="excluir" value="Excluir"></td>
    </form>
  </tr>
  <%}
  %>
</table>
<div class="cadastrarNovoPaciente">
  <a href="cadastrarPaciente.html">
    <input type="button" value="Cadastrar novo paciente">
  </a>
</div>
</body>
</html>

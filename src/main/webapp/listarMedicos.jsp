<%@ page import="java.util.List" %>
<%@ page import="static Controllers.cadastrarUsuario.usuario" %>
<%@ page import="static Controllers.cadastrarUsuario.senha" %>
<%@ page import="DAO.MedicoDAO" %>
<%@ page import="BancoDeDados.Medico" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Médicos</title>
  <link rel="stylesheet" href="Style/listarExames.css">
  <link rel="stylesheet" href="Style/testestyle.css">
  <link rel="stylesheet" href="Style/style.css">

</head>
<body>
<div class="header">
  <h1>Hospital Ufersa</h1>
</div>
<h2>Médicos cadastrados:</h2>
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
    <th>CRM</th>
    <th>Nome</th>
    <th>Telefone</th>
    <th>Especialização</th>
  </tr>
  <%
    MedicoDAO medicodao = new MedicoDAO("sistemasaude", usuario, senha);
    List<Medico> medicos = medicodao.list("medicos");

    for(Medico medico : medicos){
  %>
  <tr>
    <form action="modificarMedico" method="post">
      <td><%=medico.getCrm()%></td>
      <input type="hidden" name="crm" value="<%=medico.getCrm()%>">
      <td><%=medico.getNome()%></td>
      <td><%=medico.getTelefone()%></td>
      <td><%=medico.getEspecializacao()%></td>

      <td bgcolor="white" style="border: 0; width: 5vh; cursor: pointer;">
        <input type="checkbox" class="popup-checkbox" id="popup-checkbox" hidden>
        <label class="abrir-popup" for="popup-checkbox">Alterar</label>
        <div class="popup-overlay">
          <div class="popup">
            <div class="form">
              <form action="cadastrarPaciente">
                <h3>CPF:</h3>
                <input type="text" name="cpf" placeholder="CPF"> <br>
                <h3>Nome:</h3>
                <input type="text" name="nome" placeholder="Nome"> <br>
                <h3>Telefone:</h3>
                <input type="text" name="telefone" placeholder="Telefone"> <br>

                <label class="fechar-popup" for="popup-checkbox">Alterar</label>
              </form>
            </div>
          </div>
        </div>
      <td bgcolor="white" style="border: 0;width: 5vh; cursor: pointer;">
        <input id="botaoExcluir" type="submit" name="excluir" value="Excluir"></td>
    </form>
  </tr>
  <%}
  %>
</table>
</body>
</html>


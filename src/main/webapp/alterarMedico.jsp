<%@ page import="BancoDeDados.Medico" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="Style/cadastrarUsuarioMedico.css">
    <link rel="stylesheet" href="Style/style.css">
    <title>Cadastrar Usuário</title>
</head>
<body>
<div class="header">
    <a href="paginaPrincipal.jsp">
        <h1>Hospital Ufersa</h1></a>
</div>
<%
    Medico medico = null;
    if(request.getAttribute("medico") != null){
        medico = (Medico) request.getAttribute("medico");
    }
%>

<div class="main">
    <div class="form">
        <form action="alterarMedico" method="post">
            <input type="hidden" name="crmAlterar" value=<%=medico.getCrm()%>>
            <h3>CRM</h3>
            <input type="text" name="crm" placeholder="CRM" value=<%=medico.getCrm()%>> <br>
            <h3>Nome</h3>
            <input type="text" name="nome" maxlength="100" placeholder="Nome" value=<%=medico.getNome()%>> <br>
            <h3>Telefone</h3>
            <input type="text" name="telefone" maxlength="14" placeholder="(99) 9999-9999" value=<%=medico.getTelefone()%>> <br>
            <h3>Especialização</h3>
            <input type="text" name="especializacao" maxlength="100" placeholder="Especialização" value=<%=medico.getEspecializacao()%>> <br>
            <div class="button"><input type="submit" value="Alterar"></div>
        </form>
    </div>
</div>
</body>
</html>

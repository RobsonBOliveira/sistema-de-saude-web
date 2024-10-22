<%@ page import="BancoDeDados.Paciente" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alterar Paciente</title>
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/cadastrarPaciente.css">
</head>
<body>
<div class="header">
    <a href="paginaPrincipal.jsp">
        <h1>Hospital Ufersa</h1></a>
</div>

<%
    Paciente paciente = null;
    if(request.getAttribute("paciente") != null){
        paciente = (Paciente) request.getAttribute("paciente");
    }
%>

<div class="main">
    <div class="form">
        <form action="alterarPaciente" method="post">
            <input type="hidden" name="cpfModificar" value=<%=paciente.getCpf()%>>
            <h3>CPF:</h3>
            <input type="text" name="cpf" maxlength="14" placeholder="CPF" value=<%=paciente.getCpf()%>> <br>
            <h3>Nome:</h3>
            <input type="text" name="nome" maxlength="100" placeholder="Nome" value=<%=paciente.getNome()%>> <br>
            <h3>Telefone:</h3>
            <input type="text" name="telefone" maxlength="14" placeholder="Telefone" value=<%=paciente.getTelefone()%>> <br>
            <div class="button"><input type="submit"value="Alterar"></div>
        </form>
    </div>
</div>
</body>
</html>

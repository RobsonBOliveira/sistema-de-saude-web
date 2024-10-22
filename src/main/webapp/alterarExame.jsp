<%@ page import="BancoDeDados.Exame" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="Style/cadastrarExame.css">
    <link rel="stylesheet" href="Style/style.css">
    <title>Cadastrar Exame</title>
</head>
<body>
<div class="header">
    <h1>Hospital Ufersa</h1>
</div>

<%
    Exame exame = null;
    if(request.getAttribute("exame") != null){
        exame = (Exame) request.getAttribute("exame");
    }
%>
<div class="main">
    <div class="form">
        <form action="alterarExame" method="post">
            <input type="hidden" name="codigo_exameAlterar" value=<%=exame.getCodigo_exame()%>>
            <h3>Código exame:</h3>
            <input type="text" name="codigo_exame" placeholder="Código exame" value=<%=exame.getCodigo_exame()%>> <br>
            <h3>Nome do paciente:</h3>
            <input type="text" name="nome_paciente" maxlength="100" placeholder="Nome do paciente:" value=<%=exame.getNome_paciente()%>> <br>
            <h3>Resultado</h3>
            <input type="text" name="resultado" maxlength="100" placeholder="Resultado" value=<%=exame.getResultado()%>> <br>
            <div class="button"><input type="submit"value="Alterar"></div>
        </form>
    </div>
</div>
</body>
</html>

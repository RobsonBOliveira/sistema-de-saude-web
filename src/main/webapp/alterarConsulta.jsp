<%@ page import="BancoDeDados.Consulta" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br" xmlns:br="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="Style/cadastrarConsulta.css">
    <link rel="stylesheet" href="Style/style.css">
    <title>Cadastrar Consulta</title>
</head>
<body>
<div class="header">
    <h1>Hospital Ufersa</h1>
</div>

<%
    Consulta consulta = null;
    if(request.getAttribute("consulta") != null){
       consulta = (Consulta) request.getAttribute("consulta");
    }
%>

<div class="main">
    <div class="form">
        <form action="alterarConsulta" method="post">
            <input type="hidden" name="codigoAlterar" value=<%=consulta.getCodigo()%>>
            <h3>Código</h3>
            <input type="text" name="codigo" placeholder="Código" value=<%=consulta.getCodigo()%>><br>
            <h3>Data</h3>
            <input type="text" name="data" maxlength="10" placeholder="Data" value=<%=consulta.getData()%>><br>
            <H3>Observação</H3>
            <input type="text" name="observacao" maxlength="100" placeholder="Observação" value=<%=consulta.getObservacao()%>><br>
            <h3>CRM</h3>
            <input type="text" name="crm" placeholder="CRM" value=<%=consulta.getCrm()%>> <br>
            <h3>Nome do paciente</h3>
            <input type="text" name="nome_paciente" maxlength="100" placeholder="Nome do Paciente" value=<%=consulta.getNome_paciente()%>> <br>
            <div class="button"><input type="submit"value="Alterar"></div>
        </form>
    </div>
</div>

</body>
</html>

<%-- 
    Document   : inicial
    Created on : 11/03/2019, 10:39:14
    Author     : fatec
--%>

<%@page import="entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) session.getAttribute("user");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página de Entrada</title>
        <link rel="stylesheet" type="text/css" href="login.css" />
    </head>
    <body>
        Usuário logado: <%= user.getNome() %>
        <div class="menu" >
            <a href="inicial.jsp"> Home </a> |
            <a href="novoUsuario.jsp"> Novo Usuário </a> |
            <a href="consultarUsuario"> Consultar Usuário </a> |
            <a href="index.jsp"> Sair </a>
        </div>
        
    </body>
</html>

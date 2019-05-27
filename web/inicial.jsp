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
<<<<<<< HEAD
            <a href="consultarUsuario"> Consultar Usuário </a> |
            <a href="index.jsp"> Sair </a>
=======
            <a href="index.jsp"> Clientes </a> |
             <a href="index.jsp"> Fornecedores </a> |
              <a href="index.jsp"> Produtos </a> |
               <a href="index.jsp"> Compra </a> |
                <a href="index.jsp"> Venda </a> |
                <a href="index.jsp"> Gerar relatório</a> |
             <a href="index.jsp"> Sair </a> |
>>>>>>> 167ce7554d810f86394d110770ef3b025a855fcf
        </div>
        
    </body>
</html>

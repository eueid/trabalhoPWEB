<%-- 
    Document   : editar
    Created on : 01/04/2019, 09:58:19
    Author     : fatec
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    LinkedList<Usuario> lista = (LinkedList) session.getAttribute("listaUsuario");
    int index = Integer.parseInt(request.getParameter("index"));
    Usuario local = lista.get(index);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuário</title>
        <link rel="stylesheet" type="text/css" href="login.css" />

    </head>
    <body>
        Usuário logado: <%= user.getNome()%>
        <div class="menu" >
            <a href="inicial.jsp"> Home </a> |
            <a href="novoUsuario.jsp"> Novo Usuário </a> |
            <a href="consultarUsuario"> Consultar Usuário </a> |
            <a href="index.jsp"> Sair </a>
        </div>
        <div class="conteudo">
            <form action="atualizaUsuario" method="POST">
                <input type="hidden" name="index" value="<%=index%>" />
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Login:</td>
                            <td><input type="text" name="usuario" disabled value="<%= local.getLogin() %>" /></td>
                        </tr>
                        <tr>
                            <td>Nome:</td>
                            <td><input type="text" name="nome" value="<%= local.getNome() %>" /></td>
                        </tr>
                        <tr>
                            <td>Senha:</td>
                            <td><input type="password" name="senha" value="" /></td>
                        </tr>
                        <tr>
                            <td colspan="2">
                    <center>
                        <input type="submit" value="Salvar" />
                    </center>
                    </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </body>
</html>

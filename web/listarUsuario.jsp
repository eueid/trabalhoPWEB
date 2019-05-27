<%-- 
    Document   : listarUsuario
    Created on : 25/03/2019, 12:38:16
    Author     : fatec
--%>

<%@page import="java.util.LinkedList"%>
<%@page import="entidades.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Usuario user = (Usuario) session.getAttribute("user");
    LinkedList<Usuario> lista = (LinkedList) session.getAttribute("listaUsuario");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            <table border="1">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Login</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        int i=0;
                        for (Usuario usuario : lista) {


                    %>
                    <tr>
                        <td><%= usuario.getNome()%></td>
                        <td><%= usuario.getLogin()%></td>
                        <td><a href="editar.jsp?index=<%=i++%>"> Editar </a>  </td>
                    </tr>
                    <% }%>

                </tbody>
            </table>

        </div>

    </body>
</html>

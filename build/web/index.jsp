<%-- 
    Document   : index
    Created on : 18/03/2019, 10:52:35
    Author     : fatec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
        <title>JSP Page</title>
=======
        <title>Login</title>
>>>>>>> 167ce7554d810f86394d110770ef3b025a855fcf
    </head>
    <body>
        <h1>Tela de Login</h1>
        <form action="login" method="POST">
            <fieldset>
                <legend>Dados do Login</legend>
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Usuário:</td>
                            <td><input type="text" name="usuario" value="" /></td>
                        </tr>
                        <tr>
                            <td>Senha:</td>
                            <td><input type="password" name="senha" value="" /></td>
                        </tr>
                        <% if(session.getAttribute("msg") != null){ %>
                        <tr>
                            <td colspan="2"> <text style="color:red"><%= session.getAttribute("msg") %> </text></td>
                        </tr>
                        
                        <%   session.invalidate();
                           } %>
                        <tr>
                            <td colspan="2">
                    <center>
                        <input type="submit" value="Entrar" />
<<<<<<< HEAD
=======
                        <a href="register.jsp">Faça seu cadastro</a>
>>>>>>> 167ce7554d810f86394d110770ef3b025a855fcf
                    </center>
                    </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </body>
</html>

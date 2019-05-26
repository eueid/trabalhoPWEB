<%-- 
    Document   : index
    Created on : 18/03/2019, 10:52:35
    Author     : fatec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
         
    
        <form action="register" method="POST">
            <fieldset>
                <legend>Faça seu cadastro</legend>
                <table border="0">
                    <tbody>
                        <tr>
                            <td>Nome:</td>
                            <td><input type="text" name="nome" value="" /></td>
                        </tr>
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
                        <br>
                        <input type="submit" value="Cadastre-se" class="bt"/>  
                        
                        <a href="login.jsp">Faça seu login</a>
                    </center>
                    </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </body>
</html>

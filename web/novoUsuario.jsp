<%-- 
    Document   : novoUsuario
    Created on : 25/03/2019, 11:58:22
    Author     : fatec
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Novo Usuário</title>
    </head>
    <body>        
        <h1>Tela de Novo Usuário</h1>
        <form action="cadastroUsuario" method="POST">
            <fieldset>
                <legend>Dados do Usuário</legend>
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
                        <tr>
                            <td colspan="2">
                    <center>
                        <input type="submit" value="Salvar" />
                    </center>
                    </td>
                    </tr>
                    </tbody>
                </table>
            </fieldset>
        </form>
    </body>
</html>

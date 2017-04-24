<%-- 
    Document   : formAlteraUsuario
    Created on : 22/04/2017, 20:39:38
    Author     : Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Alteração de Usuário</title>
    </head>

    <body>
        <form action="mvc?logica=AlteraUsuarioLogica" method="post">
            ID:<input type="text" name="id" value="${usuario.id}" readonly="readonly">
            </br></br>
            Nome:<input type="text" name="nome" value="${usuario.nome}">
            </br></br>
            Login:<input type="text" name="login" value="${usuario.login}">
            </br></br>
            Senha:<input type="password" name="senha" value="${usuario.senha}">
            </br></br>
            <input type="submit" value="Alterar">
        </form>
    </body>
</html>

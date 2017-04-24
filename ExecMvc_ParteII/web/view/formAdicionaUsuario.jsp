<%-- 
    Document   : formAdicionaUsuario
    Created on : 22/04/2017, 03:12:39
    Author     : Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulário de Cadastro de Usuário</title>
    </head>
    
    <body>
        <form action="../mvc?logica=AdicionaUsuarioLogica" method="post">
            Nome:<input type="text" name="nome">
            </br></br>
            Login:<input type="text" name="login">
            </br></br>
            Senha:<input type="password" name="senha">
            </br></br>
            <input type="submit" value="Adicionar">
        </form>
    </body>
    
</html>

<%-- 
    Document   : listaUsuarios
    Created on : 22/04/2017, 16:10:37
    Author     : Wilson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/estiloTeste.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">            
            <div class="row">
                <div class="col-md-12">
                    
                    <span class="alert alert-success" id="msg">${nome}${mensagem}</span>  
                    
                    <div class="table-responsive">
                        <table class="table table-striped table-striped table-hover">
                            <tr>
                                <th>ID</th>
                                <th>NOME</th>
                                <th>LOGIN</th>
                                <th>SENHA</th>
                                <th colspan="2">ACAO</th>
                            </tr>

                            <c:forEach var="usuario" items="${usuarios}">
                                <tr>
                                    <td>${usuario.id}</td>
                                    <td>${usuario.nome}</td>
                                    <td>${usuario.login}</td>
                                    <td>${usuario.senha}</td>
                                    <td><a class="btn btn-info active" href="mvc?logica=PesquisaUsuarioLogica&id=${usuario.id}"> alterar </a></td>
                                    <td><a class="btn btn-info active" href="mvc?logica=RemoveUsuarioLogica&id=${usuario.id}"> remover </a></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                    
                </div>    
            <div>
        <div>
        
        <script src="js/jquery.js"></script>
        <script src="js/testesript.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>

<%-- 
    Document   : list
    Created on : 20/08/2016, 13:46:33
    Author     : CarlosEduardode
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produtos</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        
        ${sucesso}

        <table>
            <tr>
                <td>Titulo</td>
                <td>Valores</td>
            </tr>
            
            <c:forEach items="${produtos}" var="produtos">
            <tr>
                <td>${produtos.titulo}</td>
                <td>
                    <c:forEach items="${produtos.precos}" var="precos">
                        [${precos.valor} - ${precos.tipoLivro}]                    
                    </c:forEach>                               
                </td>
            </tr>
            </c:forEach>
        </table>    
    </body>
</html>

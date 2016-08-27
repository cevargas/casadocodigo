<%-- 
    Document   : form
    Created on : 20/08/2016, 13:30:23
    Author     : CarlosEduardode
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Cadastro de produtos</title>
    </head>
    <body>
        <form method="post" action="/casadocodigo/produtos">
            <div>
                <label for="titulo">Titulo</label>
                <input type="text" name="titulo" id="titulo"/>
            </div>
            <div>
                <label for="descricao">Descrição</label>
                <textarea rows="10" cols="20" name="descricao" id="descricao"></textarea>
            </div>
            <div>
                <label for="numeroDePaginas">Número de paginas</label>
                <input type="text" name="numeroDePaginas" id="numeroDePaginas"/>
            </div>            

            <c:forEach items="${tipos}" var="tipoLivro" varStatus="status">
                <div>
                    <label for="precos_${tipoLivro}">${tipoLivro}</label>
                    <input type="text" name="precos[${status.index}].valor"
                           id="precos_${tipoLivro}"/>
                    <input type="hidden"
                           name="precos[${status.index}].tipoLivro"
                           value="${tipoLivro}"/>
                </div>
            </c:forEach>

            <div>
                <input type="submit" value="Enviar">
            </div>

        </form>
    </body>
</html>
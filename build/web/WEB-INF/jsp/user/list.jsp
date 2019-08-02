<%-- 
    Document   : list
    Created on : 17/07/2019, 21:22:47
    Author     : Sr. Roosevelt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuários</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista de Usuários</h1>
            <hr>
            <div>
                <spring:url value="/usuario/cadastro" var="cadastro"/>
                <a class="btn btn-default" href="${cadastro}">Novo Usuário</a>
            </div>
            <hr>
            
            <div class="panel-default">
                <div class="panel-heading">
                    <span>${message == null ? '&nbsp;' : message}</span>
                </div>
                <table class="table table-striped table-condensed">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOME</th>
                            <th>DATA DE NASCIMENTO</th>
                            <th>AÇÃO</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuario }">
                            <tr>
				<td>${usuario.id }</td>
				<td>${usuario.nome }&nbsp; ${usuario.sobrenome }</td>
                                <td>
                                    <f:parseDate var="date" value="${usuario.dtNascimento}" pattern="yyyy/MM/dd" type="date" />
                                    <f:formatDate value="${date}" pattern="dd/MM/yyyy" type="date" />
                                </td>
				<td>
                                    <spring:url value="/usuario/update/${usuario.id}" var="update" />
                                    <a class="btn btn-info" href="${update}" >Editar</a>
                                    <spring:url value="/usuario/delete/${usuario.id}" var="delete" />
                                    <a class="btn btn-danger" href="${delete}" >Excluir</a>
				</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <footer class="footer">
                <p>&copy; 2019 DevMedia</p>
            </footer>
        </div>
    </body>
</html>

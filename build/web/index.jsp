<%-- 
    Document   : index
    Created on : 12/10/2016, 14:42:11
    Author     : JM7087-Notbook
--%>

<%
    HttpSession sessao = request.getSession();//pegando a sessão ativa
    if(sessao.getAttribute("statusLogin") == null){
        //dispacha o cabra pra tela de login
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <title>Loja</title>

        
        <%@include file="template/head.jsp" %>
    </head>
    <body>
        <!-- início do corpo do site -->
        <div class="container">
            <%@include file="template/cabecalho.jsp" %>
            
            <%@include file="template/menu.jsp" %>
            
            <%@include file="template/body.jsp" %>
            
            <%@include file="template/rodape.jsp" %>
        </div>
        <!-- fim do corpo do site -->
    </body>
</html>

<%-- 
    Document   : cliente
    Created on : 15/12/2016, 10:34:03
    Author     : JM7087-Notbook
--%>

<%
    HttpSession sessao = request.getSession();//pegando a sessão ativa
    if(sessao.getAttribute("statusLogin") == null){
        //dispacha o cabra pra tela de login
         RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?respCadastro=nãoLogado");
        rd.forward(request, response);
       
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
<div class="container">
       <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
            <li role="presentation"><a href="index.jsp">Inicio</a></li>
            <li role="presentation"><a href="login.jsp">Login</a></li>
            <li role="presentation"><a href="#">Carrinho</a></li>
            <li role="presentation" class="active"><a href="#" >Conta</a></li>
          </ul>
        </nav>
                   <h3 class="text-muted">LOJA</h3>
       </div>
   </div>            
            
            
            <center><a href="CadastroDeProdutosParaVender.jsp" class="btn btn-success" role="button">Cadastro de Produtos para Vender</a></center>
            
            <%@include file="template/rodape.jsp" %>
        </div>
        <!-- fim do corpo do site -->
    </body>
</html>

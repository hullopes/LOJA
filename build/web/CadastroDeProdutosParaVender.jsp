<%-- 
    Document   : CadastroDeProdutosParaVender
    Created on : 04/01/2017, 11:21:19
    Author     : JM7087-Notbook
--%>

<%
    HttpSession sessao = request.getSession();//pegando a sess�o ativa
    if(sessao.getAttribute("statusLogin") == null){
        //dispacha o cabra pra tela de login
         RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?respCadastro=n�oLogado");
        rd.forward(request, response);
       
    }
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <title>JM EXPRESS - CADASTRO DE PRODUTO</title>


        <%@include file="template/head.jsp" %>

    </head>
    <body>

        <form action="./controladorCadastroDeProdutosParaVender" method="POST" enctype="multipart/form-data">

            <div class="container">
                <!-- estas linhas abaixo s�o obrigat�rias para chamar o cabe�alho, passando como par�metro a p�gina atual, para que possamos montar o menu superior -->
                <jsp:include page="template/cabecalho.jsp" >
                    <jsp:param name="atual" value="conta" />
                </jsp:include>

                <div class="form-group">
                    <label for="inputNome">Nome do Produto</label>
                    <input type="text" class="form-control" name="inputNome" placeholder="Nome do Produto" required>
                                    
                    <label for="inputDescricao">Descri��o do Produto</label>
                    <input type="text" class="form-control" name="inputDescricao" placeholder="Descri�ao do Produto" required>

                   <label for="inputValor">Valor do Produto</label>
                    <input type="text" class="form-control" name="inputValor" placeholder="Valor do Produto" required>
                             
                    <label for="inputQuantidade">Quantidade do Produto</label>
                    <input type="text" class="form-control" name="inputQuantidade" placeholder="Quantidade do Produto" required>
                               
                    <label for="inputImagem">Imagem do Produto</label>
                    <input class="btn btn-primary" type="file" name="inputImagem">
                    
                    <label for="inputMarca">Marca do Produto</label>
                    <input type="text" class="form-control" name="inputMarca" placeholder="Marca do Produto" required>
                    
                    <label for="inputCategoria">Categoria do Produto</label>
                    <input type="text" class="form-control" name="inputCategoria" placeholder="Categoria do Produto" required>
                
                
                </div>
                <button class="btn btn-lg btn-primary " type="submit">Cadastrar</button>
                <button class="btn btn-lg btn-primary " type="reset">Limpar</button> 
                <button class="btn btn-lg btn-warning" type="cancel" onclick="history.go(-1)">Cancelar</button>
        </form>

    </div>
                <br></br>
    <%@include file="template/rodape.jsp" %>

</body>
</html>

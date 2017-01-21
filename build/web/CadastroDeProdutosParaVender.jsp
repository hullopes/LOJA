<%-- 
    Document   : CadastroDeProdutosParaVender
    Created on : 04/01/2017, 11:21:19
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

        <title>Loja Cadastro</title>


        <%@include file="template/head.jsp" %>

    </head>
    <body>

        <form action="./controladorCadastroDeProdutosParaVender" method="POST">

            <div class="container">

                <%@include file="template/cabecalho.jsp" %>

                <div class="form-group">
                    <label for="inputNome">Nome do Produto</label>
                    <input type="text" class="form-control" name="inputNome" placeholder="Nome do Produto" required>
                                    
                    <label for="inputDescricao">Descrição do Protudo</label>
                    <input type="text" class="form-control" name="inputDescricao" placeholder="Descriçao do Protudo" required>

                   <label for="inputValor">Valor do Protudo</label>
                    <input type="text" class="form-control" name="inputValor" placeholder="Valor do Protudo" required>
                             
                    <label for="inputQuantidade">Quantidade do Protudo</label>
                    <input type="text" class="form-control" name="inputQuantidade" placeholder="Quantidade do Protudo" required>
                               
                    <label for="inputImagem">Imagem do Protudo</label>
                    <input class="btn btn-primary" type="file" name="inputImagem">
                    
                    <label for="inputMarca">Marca do Protudo</label>
                    <input type="text" class="form-control" name="inputMarca" placeholder="Marca do Protudo" required>
                    
                    <label for="inputCategoria">Gategoria do Protudo</label>
                    <input type="text" class="form-control" name="inputGategoria" placeholder="Gategoria do Protudo" required>
                
                
                </div>
               <button class="btn btn-lg btn-primary " type="submit">Cadastrar</button>

        </form>

    </div>
                <br></br>
    <%@include file="template/rodape.jsp" %>

</body>
</html>

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cdc.util.FotoDAO;
import cdc.util.ProdutoDAO;
import cdc.util.Upload;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Foto;
import model.Produto;

/**
 *
 * @author JM7087-Notbook
 */
@WebServlet(name = "controladorCadastroDeProdutosParaVender", urlPatterns = {"/controladorCadastroDeProdutosParaVender"})
@MultipartConfig
public class controladorCadastroDeProdutosParaVender extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException, Exception {
            request.setCharacterEncoding("ISO-8859-1");
            RequestDispatcher despachador = null;
        
            //buscando o último ID do produto, para compor a pasta de imagem            
            int lastID = ProdutoDAO.pegaUltimoID();
            lastID++;
        
            /* Primeiro faz o upload do arquivo, e depois faz-se o cadastro do produto e da foto */
            Upload upload = new Upload("/img/imgupload/"+lastID+"/");
            try {
		if (upload.anexos(request)) {
			request.setAttribute("arquivo", "Arquivo/foto enviado com sucesso");
                        Map parametros = upload.getParametros();//buscando os parâmetros filtrados pela classe Upload
                        
                        String inputNome = (String) parametros.get("inputNome");
                        String inputDescricao = (String) parametros.get("inputDescricao");
                        String inputValor = (String) parametros.get("inputValor");
                        String inputQuantidade = (String) parametros.get("inputQuantidade");
                        String inputImagem = (String) parametros.get("inputImagem");
                        String inputMarca = (String) parametros.get("inputMarca");
                        String inputCategoria = (String) parametros.get("inputCategoria");
                        Part filePart = request.getPart("inputImagem");
                        
                        ProdutoDAO produtoDAO = new ProdutoDAO(); 

                        Produto pro = new Produto(0, inputNome, inputDescricao, Double.valueOf(inputValor).doubleValue(), Integer.valueOf(inputQuantidade).intValue(), inputMarca, inputCategoria);

                        produtoDAO.salvar(pro);//salva o produto no BD

                        List<Produto> produto = produtoDAO.procura(pro);//capturando o produto no BD para obtermos seu ID (primary key)
                        if (produto.size()>0){           
                            request.setAttribute("mensagem", "Produto cadastrado com sucesso");
                            int id = produto.get(0).getPRO_ID();//pegando o ID do produto (primary key)                            
                            FotoDAO fotoDAO = new FotoDAO();
                            Foto foto = new Foto(0, (String) parametros.get("foto"), id);
                            fotoDAO.salvar(foto);
                       } 
                        
		} else {
			request.setAttribute("arquivo", "Problema no envio da foto");
                        request.setAttribute("mensagem", "Erro no processamento do cadastro do produto!");
		}
            } catch (Exception e) {
                    e.printStackTrace();
            }   
        //usa um dispatcher pra mandar ele de volta pra tela de login.
        despachador = request.getRequestDispatcher("PainelDeControleUsuario.jsp");
        //despachando para a página setada, segundo as opções acima
        despachador.forward(request, response);
    }
  
  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-1");
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroDeProdutosParaVender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("ISO-8859-1");
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroDeProdutosParaVender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

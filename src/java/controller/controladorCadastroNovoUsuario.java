/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author JM7087-Notbook
 */

import cdc.util.LoginDAO;
import cdc.util.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Login;
import model.Usuario;


@WebServlet(name = "controladorCadastro", urlPatterns = {"/controladorCadastro"})
public class controladorCadastroNovoUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException, Exception {
        
        String inputNome = request.getParameter("inputNome");
        String inputTelefone = request.getParameter("inputTelefone");
        String inputSexo = request.getParameter("inputSexo");
        String inputEndereco = request.getParameter("inputEndereco");
        String inputCep = request.getParameter("inputCep");
        String inputCidade = request.getParameter("inputCidade");
        String inputEstado = request.getParameter("inputEstado");
        
        String inputEmail = request.getParameter("inputEmail");
        String inputPassword = request.getParameter("inputPassword");
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        LoginDAO loginDAO = new LoginDAO();        
        
        out.println(inputNome + "--" + inputTelefone+"--"+inputSexo+"--"+inputEndereco+"--"+inputCep+"__"+inputCidade+"__"+inputEstado);

        Usuario usr  = new Usuario(0,inputNome,inputTelefone,inputSexo,inputEndereco,inputCep,inputCidade,inputEstado);            
          
        //salva o usário conforme os dados enviados
        usuarioDAO.salvar(usr);     

        List<Usuario> lista = usuarioDAO.procura(usr);//buscando o usuário recém criado para obter seu id para cadastrar o login 
        //salvando o login
        loginDAO.salvar(new Login(0,inputEmail,inputPassword,lista.get(0).getUSU_ID()));

        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp?respCadastro=ok");
        rd.forward(request, response);
       
        
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroNovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(controladorCadastroNovoUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
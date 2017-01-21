/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cdc.util.LoginDAO;
import com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Login;
import model.Usuario;
import static org.apache.coyote.http11.Constants.a;

/**
 *
 * @author JM7087-Notbook
 */
@WebServlet(name = "controladorLogin", urlPatterns = {"/controladorLogin"})
public class controladorLogin extends HttpServlet {

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
            throws ServletException, IOException {
        String inputEmail = request.getParameter("inputEmail");
        String inputPassword = request.getParameter("inputPassword");
        
        
        RequestDispatcher login = null;
        try {
            LoginDAO loginDao = new LoginDAO();    

            if(loginDao.login(inputEmail, inputPassword, request.getSession())){
                //se for cliente, manda ele pro painel do cliente
                //se for funcionário, manda ele pro painel do funcionário
                  
               HttpSession sessao = request.getSession();
               sessao.setAttribute("inputEmail", inputPassword);
                
                login = request.getRequestDispatcher("PainelDeControleUsuario.jsp");
                login.forward(request, response);
                
            }else{
                //usa um dispatcher pra mandar ele de volta pra tela de login.
              login = request.getRequestDispatcher("login.jsp");
              //despachando para a página setada, segundo as opções acima
              login.forward(request, response);
            }
            
            
        } catch (Exception ex) {
            Logger.getLogger(controladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

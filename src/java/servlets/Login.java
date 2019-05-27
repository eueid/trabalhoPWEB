/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controles.Controlador;
import entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fatec
 */
public class Login extends HttpServlet {
    
    //Esse servlet deve possuir um controlador.
    private Controlador con;

    //Metodo de iniciação do servlet. Chamado automaticamente.
    @Override
    public void init() throws ServletException {
        super.init(); 
        
        //E esse controlador deve ser iniciado junto com o servlet
        con = new Controlador();
    
    }
    
    
    
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
        
        //Pega os paramentros enviados pelo formulario...
        Usuario user = new Usuario();
        user.setLogin(request.getParameter("usuario"));
        user.setSenha(request.getParameter("senha"));
        
        //Verifica se já existe e a senha esta certa.
        user = con.validaUsuario(user);
        
        if(user != null){
            //Tudo certo
            request.getSession().setAttribute("user", user);
            response.sendRedirect("inicial.jsp");
        } else {
            //usuarios invalidos. Não cadastrado no banco.
            request.getSession().setAttribute("msg", "Usuário ou senha inválidos!!!");
            response.sendRedirect("index.jsp");
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

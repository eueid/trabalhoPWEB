/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controles.Controlador;
import entidades.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lucas
 */
public class CadastroUsuario extends HttpServlet {
  private Controlador con;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.

        con = new Controlador();

    }
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        Usuario user = new Usuario();
        user.setLogin(request.getParameter("usuario"));
        user.setSenha(request.getParameter("senha"));
        user.setNome(request.getParameter("nome"));
        
        con.salvarUsuario(user);
        
        response.sendRedirect("consultarUsuario");
        
    }
        }
    

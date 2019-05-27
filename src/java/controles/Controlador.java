/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import entidades.Usuario;
import java.util.LinkedList;

/**
 *
 * @author fatec
 */
public class Controlador {
    
    private Cadastro cad = new Cadastro();
    
    //Esse método verifica se o que foi digitado no campo de login e senha bate com o usuario do banco
    public Usuario validaUsuario(Usuario user){
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Entrou aqui"+user.getLogin()+user.getSenha());
        Usuario novo = cad.consultaUsuario(user.getLogin());
        
        if(novo != null 
                && user.getLogin().equals(novo.getLogin())
               && user.getSenha().equals(novo.getSenha())){
            return novo;
        }
        
        return null;
    }

      public void salvarUsuario(Usuario user) {
        user.setSenha(Funcao.md5(user.getSenha()));
        cad.salvarUsuario(user);
    }

    public LinkedList consultaUsuario() {
        return cad.consultaUsuario();
    }
    
    public void atualizarUsuario(Usuario user){
        if(!user.getSenha().isEmpty()){
            user.setSenha(Funcao.md5(user.getSenha()));
        }
        cad.atualizarUsuario(user);
    }
}

 

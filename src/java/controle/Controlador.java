/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Usuario;
import java.util.LinkedList;

/**
 *
 * @author fatec
 */
public class Controlador {

    private Cadastro cad = new Cadastro();

    public Usuario validaUsuario(Usuario user) {

        //Chamar o banco de dados
        /*Usuario novo = new Usuario();
        novo.setLogin("teste");
        novo.setSenha("teste");
        novo.setNome("Nome do Usuário");
         */
        Usuario novo = cad.consultaUsuario(user.getLogin());

        if (novo != null
                && user.getLogin().equals(novo.getLogin())
                && user.getSenha().equals(novo.getSenha())) {
            return novo;
        }

        return null;
    }

    public void salvarUsuario(Usuario user) {
        user.setSenha(user.getSenha());
        cad.salvarUsuario(user);
    }

    public LinkedList consultaUsuario() {
        return cad.consultaUsuario();
    }
    
    public void atualizarUsuario(Usuario user){
        if(!user.getSenha().isEmpty()){
            user.setSenha(user.getSenha());
        }
        cad.atualizarUsuario(user);
    }
}

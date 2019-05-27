/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fatec
 */
public class Cadastro {

    private Conexao con = new Conexao();

    public void salvarUsuario(Usuario user) {
        PreparedStatement st;
        ResultSet res;

        int i = 1;

        try {
            st = con.getConexao().prepareStatement("insert into"
                    + " usuario (nome, login, senha) values "
                    + " (?, ?, ?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(i++, user.getNome());
            st.setString(i++, user.getLogin());
            st.setString(i++, user.getSenha());

            st.execute();

            res = st.getGeneratedKeys();

            if (res.next()) {
                user.setCod(res.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Usuario consultaUsuario(String login) {
        PreparedStatement st;
        ResultSet res;
        Usuario user = null;

        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select cod,"
                    + "nome, login, senha from  usuario"
                    + " where login = ?");
            st.setString(i++, login);

            res = st.executeQuery();

            if (res.next()) {
                user = new Usuario();
                user.setCod(res.getInt("cod"));
                user.setNome(res.getString("nome"));
                user.setLogin(res.getString("login"));
                user.setSenha(res.getString("senha"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return user;

    }

    public LinkedList consultaUsuario() {
        PreparedStatement st;
        ResultSet res;
        Usuario user = null;
        LinkedList lista = new LinkedList();

        int i = 1;

        try {
            st = con.getConexao().prepareStatement("select cod,"
                    + "nome, login, senha from  usuario");

            res = st.executeQuery();

            while (res.next()) {
                user = new Usuario();
                user.setCod(res.getInt("cod"));
                user.setNome(res.getString("nome"));
                user.setLogin(res.getString("login"));
                user.setSenha(res.getString("senha"));

                lista.add(user);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }

    public void atualizarUsuario(Usuario user) {
        PreparedStatement st;

        int i = 1;

        try {
            st = con.getConexao().prepareStatement("update "
                    + " usuario set nome = ?"
                    + (user.getSenha().isEmpty() ? "" : ", senha = ?")
                    + " where cod = ?");
            st.setString(i++, user.getNome());
            if (!user.getSenha().isEmpty()) {
                st.setString(i++, user.getSenha());
            }
            st.setInt(i++, user.getCod());

            st.execute();


        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

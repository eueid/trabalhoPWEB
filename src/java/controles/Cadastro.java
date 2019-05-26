package controles;

import entidades.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cadastro {
    //Cria um objeto da conexão.
    private Conexao con = new Conexao();
    
    //Metodo para salvar um usuario. Note que deve ser passado como parametro um usuario.
    public void salvarUsuario(Usuario user){
        PreparedStatement st;
        ResultSet res;
        
        int i=1;
        
        //Com a conexão, então é feita a inserção.
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
            
            if(res.next()){
                user.setCod(res.getInt(1));
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    //Metodo para consultar um usuario pelo login.
    public Usuario consultaUsuario(String login){
        PreparedStatement st;
        ResultSet res;
        Usuario user = null;
        
        int i=1;
        
        //Com a conexão faz a select.
        try {
            st = con.getConexao().prepareStatement("select*"
                    + "from  usuario"
                    + " where login = ?");
            st.setString(i++, login);
        
            res = st.executeQuery();
            
            //Verirfica se existe e se existir então retorna esse usuario existente.
            if(res.next()){
                user = new Usuario();
                user.setCod(res.getInt("cod"));
                user.setNome(res.getString("nome"));
                user.setLogin(res.getString("login"));
                user.setSenha(res.getString("senha"));
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Aqui então pode ser 2 opções, null ou o usuairo existente.
        return user;
        
    }

    LinkedList consultaUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void atualizarUsuario(Usuario user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

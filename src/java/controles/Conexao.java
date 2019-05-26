package controles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private Connection con;

    public Conexao() {
        
        //Esse TRY-CATCH verifica se você tem a biblioteca do MYSQL antes de fazer a conexão.
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Aqui começa a parte da conexão de fato. Preencha os dados abaixo.
        
        //Nome do banco
        String nomeBancoDados = "logincombanco";
        
        //Usuário, normalmente root.
        String user = "root";
        
        //Senha do banco, normalmente vazio.
        String password = "senha_da_nasa";
        try {
            //String de conexão, não precisa mexer aqui, só preencher as variaveis em cima.
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nomeBancoDados, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    //Metodo para retornar a conexão que foi criada.
    public Connection getConexao() {
        return con;
    }

}

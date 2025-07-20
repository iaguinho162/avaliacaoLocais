
package conexao;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
    
    
    String drive="com.mysql.jdbc.Driver";
    String caminho="jdbc:mysql://localhost:3306/bancoapp";
    String usuario="root";
    String senha="";
    
    Connection conexao;
    
    public Connection logar (){
        try {
            Class.forName(drive);
            return conexao = DriverManager.getConnection(caminho, usuario, senha);
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }  
}

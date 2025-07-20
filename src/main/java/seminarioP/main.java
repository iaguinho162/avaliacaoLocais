package seminarioP;

import conexao.Conexao;
import java.awt.Desktop;
import java.net.URI;
import java.sql.SQLException;
import java.util.Scanner;
import model.dao.Cadastro_usuario_Dao;

public class main {


    public static void main(String args[]) throws SQLException{
        
        Conexao c = new Conexao();
        usuario u = new usuario(); 
        administrador adm = new administrador();
        Cadastro_usuario_Dao dao = new Cadastro_usuario_Dao();

        Scanner ler = new Scanner(System.in);        
        
        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n[----------------------MENU----------------------]");
            System.out.println("[1]- Cadastrar\n[2]- Realizar Login\n[3]- Visitante\n[4]- Informações sobre a Importancia da Acessibilidade\n[5]- Login ADM\n[6]- Sair");
            opcao = ler.nextInt();
            
            switch (opcao) {
                case 1:
                    
                    u.cadastrar(); 
                    dao.Salvar(u);
                    break;

                case 2:
                   
                   u.entrarNoSistema();
                    
                    
                   
                    break;

                case 3:
                    u.perfilVisitante();
                    
                    break;
                
                case 4:                      

                    System.out.println("Vídeo a ser produzido");
                                        
                    try{
                        URI link = new URI("https://www.youtube.com/watch?v=DxXvxvNvbSU");
                        Desktop.getDesktop().browse(link);
                    } catch(Exception erro){
                        System.out.println("ERRO ao acessar o link");
                    }
                    break;
                    
                case 5: 
                    
                   adm.entrarNoSistemaADM();
                    
                default:
                    System.out.println("Opção Invalida");
                    break;
            }
        }      
   
    }
}

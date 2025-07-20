
package seminarioP;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import model.dao.Cadastro_usuario_Dao;
import model.dao.LocalizacaoDAO;

public class usuario {
    
    private int CPF_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;
    
    LocalizacaoDAO localDAO = new LocalizacaoDAO();
    Cadastro_usuario_Dao cadastroDAO = new Cadastro_usuario_Dao();

    public int getCPF_usuario() {
        return CPF_usuario;
    }

    public void setCPF_usuario(int CPF_usuario) {
        this.CPF_usuario = CPF_usuario;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }
    
    
    Scanner ler = new Scanner(System.in);

    Cadastro_usuario_Dao dao = new Cadastro_usuario_Dao();  
    avaliacao avaliar = new avaliacao();
    
    public void cadastrar(){        
        
        
        System.out.println("Informe seu nome: ");
        this.nome_usuario = ler.next();
        System.out.println("Informe sua CPF: ");
        this.CPF_usuario = ler.nextInt();
        System.out.println("Informe seu senha:: ");
        this.senha_usuario = ler.next();
        System.out.println("Informe seu EMAIL: ");
        this.email_usuario = ler.next();

    } 
    
    
    public void entrarNoSistema() throws SQLException{        
        
        System.out.println("Informa seu CPF: ");
        int cpf = ler.nextInt();
        System.out.println("Informe sua Senha: ");
        String senha = ler.next();
        dao.autenticacaoUsuario(cpf, senha);

    }
    
    public void perfilUsuario(){
        
        
        int opcao = 0;
        while (opcao != 6) {
            
            System.out.println("\n[----------------------Perfil Usuário----------------------]");
            System.out.println("[1]- Pesquisar Locais\n[2]- Gerenciar Perfil\n[3]- Histórico de Avaliação\n[4]- Fazer Avaliação\n[5]- Listar Locais Avaliados\n[6]- Sair");
            opcao = ler.nextInt();
            
            if(opcao == 1){
                
                pesquisarLocais();
                 
            }else if(opcao == 2){
                
                
                
            }else if(opcao == 3){
                
                
            }else if(opcao == 4){
                
                
                
            }else if(opcao == 5){
                
                 localDAO.listarLocais();
                
                 
            }else{
               
            }
            
        }
        
    }
    
   public void perfilVisitante(){
       
        localDAO.listarLocais();
   }
   
   public void pesquisarLocais(){
       
       System.out.println("Digite o nome do local: ");
       String nomeL = ler.next();       
       dao.pesquisarLocal(nomeL);
   }
   

    
}


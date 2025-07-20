
package seminarioP;

import java.sql.SQLException;
import java.util.Scanner;

import model.dao.AvaliacaoDAO;
import model.dao.Cadastro_usuario_Dao;
import model.dao.LocalizacaoDAO;


public class administrador {
    
    private int CPF_ADM;
    private String nome_ADM;
    private String senha_ADM;
    private Cadastro_usuario_Dao dao = new Cadastro_usuario_Dao();
    private AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
    private LocalizacaoDAO localizacaoDAO = new LocalizacaoDAO();
    private Scanner ler = new Scanner(System.in);

    public int getCPF_ADM() {
        return CPF_ADM;
    }

    public void setCPF_ADM(int CPF_ADM) {
        this.CPF_ADM = CPF_ADM;
    }

    public String getNome_ADM() {
        return nome_ADM;
    }

    public void setNome_ADM(String nome_ADM) {
        this.nome_ADM = nome_ADM;
    }

    public String getSenha_ADM() {
        return senha_ADM;
    }

    public void setSenha_ADM(String senha_ADM) {
        this.senha_ADM = senha_ADM;
    }
    

    
    public void perfilADM(){
        
        int opcao=0;
        while(opcao !=6){
        System.out.println("-----------  PERFIL ADMINISTRADOR  -----------");
        System.out.println("[1]- Visualizar Avaliação\n[2]- Listar Todos os Usuário\n[3]- Listar todos os Locais Avaliados\n[4]-Deletar Avaliação\n[5]- Listar avaliações por Usuário e Local\n[6] - Sair: ");
        opcao = ler.nextInt();
        
        if(opcao == 1){   
            
            visualizarrAvaliacao();
            
        }else if(opcao == 2){            
            
            dao.listarUsuario();
            
        }else if(opcao == 3){
            
        	localizacaoDAO.listarLocais();
        
        }else if(opcao == 4){            
            
            deletarAvaliacao();           
            
        }else if (opcao == 5) {
        	System.out.println("Digite o ID da Avaliação:");
            int avaliacaoId = ler.nextInt();
        	avaliacaoDAO.listarAvaliacoesPorUsuarioEPorLocal(avaliacaoId);
        }
        }
    }   
    
    public void visualizarrAvaliacao(){
        System.out.println("Digite o ID da Avaliação: ");
        int op2 = ler.nextInt();
        avaliacao avaliar = new avaliacao();
        avaliar = dao.gerenciarPostagem(op2);
        if(avaliar == null){
            System.out.println("Avaliação não localizado");
        }else{
            System.out.println("Comentário: "+avaliar.getComentario_avaliacao());
            System.out.println("Data: "+avaliar.getData_avaliacao());
            System.out.println("Nota: "+avaliar.getNota());
    
        }   
    }
        
    public void deletarAvaliacao(){
                    System.out.println("Digite o ID da Avaliação:");
            int op3 = ler.nextInt();
            System.out.println("Realmente Desejar Excluir? [1]- Sim [2]- Não");
            int op4 = ler.nextInt();
            
            if(op4 == 1){
                dao.excluirAvaliacao(op3);
                System.out.println("Excluído com Sucesso");
            }
    }
    
        public void entrarNoSistemaADM() throws SQLException{        
        
        System.out.println("Informa seu CPF: ");
        int cpf = ler.nextInt();
        System.out.println("Informe sua Senha: ");
        String senha = ler.next();
        dao.autenticacaoADM(cpf, senha);

    }
}

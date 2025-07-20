
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import seminarioP.administrador;
import seminarioP.avaliacao;
import seminarioP.local;
import seminarioP.usuario;

public class Cadastro_usuario_Dao extends Conexao {

	PreparedStatement pst;
	ResultSet rs;

        
        
        
	public void Salvar(usuario u) {
		try {

			pst = logar().prepareStatement(
					"INSERT INTO usuario(CPF_usuario, nome_usuario, email_usuario, senha_usuario) values (?,?,?,?)");
			pst.setInt(1, u.getCPF_usuario());
			pst.setString(2, u.getNome_usuario());
			pst.setString(3, u.getEmail_usuario());
			pst.setString(4, u.getSenha_usuario());

			pst.executeUpdate();
			System.out.println("Sucesso na transfência de Dados");

		} catch (SQLException ex) {
			System.out.println("Erro na transfência ou usuário já existente!!");
		}

	}

	public void atualizar(usuario u) {
		try {

			pst = logar().prepareStatement(
					"update usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ? where CPF_usuario = ?");
			pst.setString(1, u.getNome_usuario());
			pst.setString(2, u.getEmail_usuario());
			pst.setString(3, u.getSenha_usuario());
			pst.setInt(4, u.getCPF_usuario());

			pst.executeUpdate();

			System.out.println("Atualização feita com sucesso");

		} catch (SQLException ex) {
			System.out.println("Erro na atualização!!");
		}
	}

	Connection conn;
        
	public usuario autenticacaoUsuario(int cpf, String senha) {

		try {
			usuario usuario = new usuario();
			String sql = "select * from usuario where CPF_usuario = " + cpf + " and senha_usuario = '" + senha + "' ";
			pst = logar().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getInt("CPF_usuario") == cpf && rs.getString("senha_usuario").equals(senha)) {
					System.out.println("Login efetuado com sucesso");
                                        usuario.perfilUsuario();
				} else {
					System.out.println("Senha ou usuário Inválido!!");
				}

			}
			rs.close();
			pst.close();
			return usuario;

		} catch (SQLException erro) {
			throw new RuntimeException("Erro ao tentar acessar o banco", erro);

		}

	}	public local pesquisarLocal(String nome) {

		try {

			local local = new local();
			pst = logar().prepareStatement("SELECT * from local where nome_local = ?");
			pst.setString(1, nome);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				local.setId_local(rs.getInt("id_local"));
				local.setNome_local(rs.getString("nome_local"));
				local.setNota_acessibilidade(rs.getInt("nota_acessibilidade"));
				local.setComentario_local(rs.getString("comentario_local"));
				return local;

			} else {
				return null;
			}
		} catch (SQLException ex) {
			return null;
		}
	}
        
        
        

	public avaliacao gerenciarPostagem(int id) {

		try {

			avaliacao avaliar = new avaliacao();
			pst = logar().prepareStatement("SELECT * from avaliacao where id_avaliacao = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				avaliar.setId_avaliacao(rs.getInt("id_avaliacao"));
				avaliar.setComentario_avaliacao(rs.getString("comentario_avaliacao"));
				avaliar.setNota(rs.getInt("nota"));
				avaliar.setData_avaliacao(rs.getDate("data_avaliacao").toLocalDate());
				return avaliar;

			} else {
				return null;
			}
		} catch (SQLException ex) {
			return null;
		}
	}

	public boolean excluirAvaliacao(int id) {

		try {
			pst = logar().prepareStatement("delete from avaliacao where id_avaliacao = ?");
			pst.setInt(1, id);
			pst.executeUpdate();
			return true;
		} catch (SQLException ex) {
			return false;
		}
	}

	public usuario listarUsuario() {

		try {

			usuario usu = new usuario();
			pst = logar().prepareStatement("SELECT * from usuario");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				usu.setCPF_usuario(rs.getInt("CPF_usuario"));
				usu.setNome_usuario(rs.getString("nome_usuario"));
				usu.setEmail_usuario(rs.getString("email_usuario"));
				System.out.println("CPF: " + usu.getCPF_usuario());
				System.out.println("Nome: " + usu.getNome_usuario());
				System.out.println("Email: " + usu.getEmail_usuario());
				System.out.println("------------------------------------------------------------");

			}

			rs.close();
			pst.close();
			return usu;

		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}

	}
        	public administrador autenticacaoADM(int cpf, String senha) {

		try {
			administrador administrador = new administrador();
			String sql = "select * from administador where CPF_ADM = " + cpf + " and senha_ADM = '" + senha + "' ";
			pst = logar().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				if (rs.getInt("CPF_ADM") == cpf && rs.getString("senha_ADM").equals(senha)) {
					System.out.println("Login efetuado com sucesso");
                                        administrador.perfilADM();
				} else {
					System.out.println("Senha ou usuário Inválido!!");
				}

			}
			rs.close();
			pst.close();
			return administrador;

		} catch (SQLException erro) {
			throw new RuntimeException("Erro ao tentar acessar o banco", erro);

		}

	}

}

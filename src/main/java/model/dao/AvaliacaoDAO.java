package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import seminarioP.avaliacao;
import seminarioP.local;

public class AvaliacaoDAO extends Conexao {

	public avaliacao listarAvaliacoes() {

		try {
			PreparedStatement pst;
			avaliacao avaliacao = new avaliacao();
			pst = logar().prepareStatement("SELECT * from avaliacao");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				avaliacao.setId_avaliacao(rs.getInt("id_avaliacao"));
				avaliacao.setComentario_avaliacao(rs.getString("comentario_avaliacao"));
				avaliacao.setNota(rs.getInt("nota"));
				avaliacao.setData_avaliacao(rs.getDate("data_avaliacao").toLocalDate());

				System.out.println("CPF: " + avaliacao.getId_avaliacao());
				System.out.println("Comentário: " + avaliacao.getComentario_avaliacao());
				System.out.println("Nota: " + avaliacao.getNota());
				System.out.println("------------------------------------------------------------");

			}

			rs.close();
			pst.close();
			return avaliacao;

		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}

	}

	public avaliacao listarAvaliacoesPorUsuarioEPorLocal(Integer avaliacaoId) {
		String sql = "select * from avaliacao a " 
					+ "	inner join usuario u " 
					+ "    on a.CPFusuario = u.CPF_usuario "
					+ "    inner join local l on a.idlocal = l.id_local " 
					+ "    where id_avaliacao = " + avaliacaoId;

		try {
			PreparedStatement pst;
			avaliacao avaliacao = new avaliacao();
			seminarioP.usuario usuario = new seminarioP.usuario();
			local local = new local();
			
			pst = logar().prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				avaliacao.setId_avaliacao(rs.getInt("id_avaliacao"));
				avaliacao.setComentario_avaliacao(rs.getString("comentario_avaliacao"));
				avaliacao.setNota(rs.getInt("nota"));
				avaliacao.setData_avaliacao(rs.getDate("data_avaliacao").toLocalDate());
				
				usuario.setCPF_usuario(rs.getInt("CPF_usuario"));
				usuario.setNome_usuario(rs.getString("nome_usuario"));
				usuario.setEmail_usuario(rs.getString("email_usuario"));
				
				local.setNome_local(rs.getString("nome_local"));
				//local.setNome_local(rs.getString("nota_acessibilidade"));
				local.setComentario_local(rs.getString("comentario_local"));

				System.out.println("--------------------------------------");
				System.out.println("Id avaliação: " + avaliacao.getId_avaliacao());
				System.out.println("Comentário: " + avaliacao.getComentario_avaliacao());
				System.out.println("Nota: " + avaliacao.getNota());
				System.out.println("Data Avaliação: " + avaliacao.getData_avaliacao());
				System.out.println("Cpf do Usuario: " + usuario.getCPF_usuario());
				System.out.println("Nome Usuário: " + usuario.getNome_usuario());
				System.out.println("Email Usuário: " + usuario.getEmail_usuario());
				System.out.println("Nome do Local: " + local.getNome_local());
				System.out.println("Comentário sobre o local: " + local.getComentario_local());
				
				
				System.out.println("------------------------------------------------------------");

			}

			rs.close();
			pst.close();
			return avaliacao;

		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}
	}

}

package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.Conexao;
import seminarioP.local;

public class LocalizacaoDAO extends Conexao {

	public local listarLocais() {

		try {
			PreparedStatement pst;
			local local = new local();
			pst = logar().prepareStatement("SELECT * from local");
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				local.setId_local(rs.getInt("id_local"));
				local.setComentario_local(rs.getString("comentario_local"));
				local.setNome_local(rs.getString("nome_local"));
				local.setNota_acessibilidade(rs.getInt("nota_acessibilidade"));

				System.out.println("id: " + local.getId_local());
				//System.out.println("Comentário: " + local.getComentario_local());
				System.out.println("Nome Local: " + local.getNome_local());
				System.out.println("Nota: " + local.getNota_acessibilidade());
				
				System.out.println("------------------------------------------------------------");

			}

			rs.close();
			pst.close();
			return local;

		} catch (SQLException ex) {

			throw new RuntimeException(ex);
		}

	}

}

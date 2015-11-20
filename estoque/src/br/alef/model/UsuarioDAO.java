package br.alef.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

	public static void inserir(String nome, String email, String senha) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexaoBanco.obterConexao();
			ps = con.prepareStatement("insert into usuario(nome,email,senha) values(?,?,?)");
			ps.setString(1, nome);
			ps.setString(2, email);
			ps.setString(3, senha);

			ps.executeUpdate();
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConexaoBanco.fecharConexao(con);
		}
	}

}

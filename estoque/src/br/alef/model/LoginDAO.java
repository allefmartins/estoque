package br.alef.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

	public static String validar(String email, String senha) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexaoBanco.obterConexao();
			ps = con.prepareStatement("select nome from usuario where email = ? and senha = ?");
			ps.setString(1, email);
			ps.setString(2, senha);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getString("nome");
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return null;
		} finally {
			ConexaoBanco.fecharConexao(con);
		}
		return null;
	}
}
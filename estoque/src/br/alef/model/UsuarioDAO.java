package br.alef.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public static List<Usuario> pesquisarUsuarios(Usuario usuario) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = ConexaoBanco.obterConexao();
			ps = con.prepareStatement("select * from usuario where nome LIKE ?");
			String nome = "";
			if (usuario.getNome() != null) {
				nome = usuario.getNome();
			}
			ps.setString(1, "%" + nome + "%");

			ResultSet rs = ps.executeQuery();
			List<Usuario> usuarios = new ArrayList<Usuario>();
			while (rs.next()) {
				Usuario usuarioLocal = new Usuario();
				usuarioLocal.setNome(rs.getString("nome"));
				usuarioLocal.setEmail(rs.getString("email"));
				usuarioLocal.setId(rs.getInt("id"));
				usuarioLocal.setSenha(rs.getString("senha"));
				usuarios.add(usuarioLocal);
			}
			return usuarios;
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return null;
		} finally {
			ConexaoBanco.fecharConexao(con);
		}
	}

	public static void excluir(Usuario usuario) {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexaoBanco.obterConexao();
			ps = con.prepareStatement("delete from usuario where id = ?");
			ps.setInt(1, usuario.getId());

			ps.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
		} finally {
			ConexaoBanco.fecharConexao(con);
		}

	}

}

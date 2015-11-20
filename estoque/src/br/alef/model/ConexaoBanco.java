package br.alef.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

	 
	    public static Connection obterConexao() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/sisec", "root", "");
	            return con;
	        } catch (Exception ex) {
	            System.out.println("Database.getConnection() Error -->"
	                    + ex.getMessage());
	            return null;
	        }
	    }
	 
	    public static void fecharConexao(Connection con) {
	        try {
	            con.close();
	        } catch (Exception ex) {
	        }
	    }
}

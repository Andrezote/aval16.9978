package univel.br.prova;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDao {
	
	private static final String SQL_BUSCA_TODOS = "SELECT * FROM CONTATO";

	public List<Produto> getTodos() {
		
		Connection con = ConexaoDB
				.getInstance()
				.getConnection();
		
		List<Produto> lista = new ArrayList<>();
		try (PreparedStatement ps = con
					.prepareStatement(SQL_BUSCA_TODOS);
				ResultSet rs = ps.executeQuery()) {
			
			while (rs.next()) {
				Produto c = new Produto();
				c.setId(rs.getLong(1));
				c.setNome(rs.getString(2));
				c.setQualidade(rs.getString(3));
				c.setQuantidade(rs.getInt(4));
				lista.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public void insere(Produto c) {
		Connection con = ConexaoDB
				.getInstance()
				.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("insert into pessoa (id, nome, qualidade,quantidade");
		sb.append(c.getId()).append(",");
		sb.append("'").append(c.getNome()).append("',");
		sb.append("'").append(c.getQualidade()).append("',");
		sb.append(c.getQuantidade());
		try {
			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void atualiza(int id, Produto c) {
		Connection con = ConexaoDB
				.getInstance()
				.getConnection();
		
		StringBuilder sb = new StringBuilder();
		sb.append("update produto set id = ").append(c.getId());
		sb.append(",set nome = ").append(c.getNome());
		sb.append(",set qualidade = ").append(c.getQualidade());
		sb.append(",set quantidade = ").append(c.getQuantidade());
		sb.append("WHERE id = ").append(id);
		try {
			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void exclui(int id) {
		Connection con = ConexaoDB
				.getInstance()
				.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM produto WHERE id =").append(id);
		
		try {
			PreparedStatement ps = con.prepareStatement(sb.toString());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

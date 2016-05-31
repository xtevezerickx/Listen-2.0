package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.listen.model.Artista;

public class ArtistaDB extends Conexao{

	
	public int buscaQuantidaePorArtista(String artista) throws Exception{
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("SELECT COUNT(*) AS total FROM cd WHERE nomeArtista LIKE ?");
			pst.setString(1,artista);
			rs = pst.executeQuery();
			if(rs.next()){
				return rs.getInt("total");
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} finally {
			if (rs != null)
				rs.close();
			this.close();
		}
		return 0;
		
	}
	
	
	public int descobreId(Artista artista) throws SQLException, Exception {
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		Statement stm = null;
		try {
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM artista");
			while (rs.next()) {
				if(artista.getNomeArtista().equals(rs.getString("nomeArtista"))){
					return rs.getInt("idArtista");
				}
			}
			return 0;
		} catch (Exception e) {
			throw e;
		}

	}

	public int descobreUltimoId() throws Exception {
		Connection con= null;
		try{
			con=this.getConexao();
		}catch(Exception e){
			throw e;
		}
		ResultSet rs = null;
		Statement stm=null;
		try{
			stm=con.createStatement();
			rs=stm.executeQuery("SELECT MAX(idArtista)FROM artista");
			if(rs.next()){
				return rs.getInt(1);
			}else{
				return 0;
			}
		}catch(Exception e){
			throw e;
		}
	}
}

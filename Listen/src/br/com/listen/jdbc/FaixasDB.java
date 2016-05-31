package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.listen.model.Faixas;

public class FaixasDB extends Conexao {
	public void insert(Faixas faixa) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO faixa(numFaixa,dscFaixa,idCd) VALUES ( ?,?, ?)";
			pst = con.prepareStatement(stn);
			pst.setInt(1, faixa.getNumFaixa());
			pst.setString(2, faixa.getDscFaixa());
			pst.setInt(3, faixa.getIdCd());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
	
	public List<Faixas> buscaPorIdCd(int idCd) throws Exception{
		List<Faixas> listaDeFaixas = new ArrayList<Faixas>();
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("select dscFaixa from faixa where idCd = ?");
			pst.setInt(1, idCd);
			rs = pst.executeQuery();
			while(rs.next()){
				Faixas f= new Faixas();
				f.setDscFaixa(rs.getString("dscFaixa"));
				listaDeFaixas.add(f);
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} 
		return listaDeFaixas;
		
	}
	
	public ArrayList<Faixas> listarTodasFaixas() throws SQLException, Exception {
		ArrayList<Faixas> lista = new ArrayList<Faixas>();
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
			rs = stm.executeQuery("SELECT * FROM faixa");
			while (rs.next()) {
				Faixas faixa = new Faixas();
				faixa.setNumFaixa(rs.getInt("numFaixa"));
				faixa.setDscFaixa(rs.getString("dscFaixa"));
				faixa.setIdCd(rs.getInt("idCd"));
				lista.add(faixa);
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
		return lista;
	}

	public int descobreUltimaFaixa(int cdId) throws SQLException,Exception{
		Connection con = null;
		try{
			con=this.getConexao();
		}catch(Exception e){
			throw e;
		}

		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			pst = con.prepareStatement("SELECT MAX(numFaixa) FROM Faixa WHERE idCd = ?");
			pst.setInt(1, cdId);
			rs = pst.executeQuery();
			if(rs.next()){
				return rs.getInt(1) + 1;
			}else{
				return 1;
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	public void update(String faixa,int idCd) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "UPDATE faixa SET dscFaixa=? WHERE idCd=?";
			pst = con.prepareStatement(stn);
			pst.setString(1, faixa);
			pst.setInt(2, idCd);
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
	

}
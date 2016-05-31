package br.com.listen.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.listen.model.Usuario;

public class UsuarioDB extends Conexao {
	public UsuarioDB() {
		super();
	}

	public ArrayList<Usuario> findAll() throws SQLException, Exception {
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			statement = con.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM Usuario");
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(resultSet.getString("nome"));
				usuario.setCep(resultSet.getString("cep"));
				usuario.setCidade(resultSet.getString("cidade"));
				usuario.setCpf(resultSet.getString("cpf"));
				usuario.setCodUsuario(resultSet.getLong("codUsuario"));
				usuario.setDataNascimento(resultSet.getDate("dataNascimento"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setEstado(resultSet.getString("estado"));
				usuario.setRg(resultSet.getString("rg"));
				usuario.setRua(resultSet.getString("rua"));
				usuario.setTelefone(resultSet.getString("telefone"));
				usuario.setLogin(resultSet.getString("login"));
				listaUsuario.add(usuario);
			}
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} finally {
			resultSet.close();
			this.close();
		}
		return listaUsuario;
	}

	public Usuario findByPrimaryKey(long valorChave) throws Exception {
		Usuario usuario = new Usuario();
		PreparedStatement preparedStatement = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet resultSet = null;
		try {
			preparedStatement = con.prepareStatement("select * from Usuario where codUsuario = ? ");
			preparedStatement.setLong(1, valorChave);
			resultSet = preparedStatement.executeQuery();
			usuario.setNome(resultSet.getString("nome"));
			usuario.setCep(resultSet.getString("cep"));
			usuario.setCidade(resultSet.getString("cidade"));
			usuario.setCpf(resultSet.getString("cpf"));
			usuario.setCodUsuario(resultSet.getLong("codUsuario"));
			usuario.setDataNascimento(resultSet.getDate("dataNascimento"));
			usuario.setEmail(resultSet.getString("email"));
			usuario.setEstado(resultSet.getString("estado"));
			usuario.setRg(resultSet.getString("rg"));
			usuario.setRua(resultSet.getString("rua"));
			usuario.setTelefone(resultSet.getString("telefone"));
			usuario.setLogin(resultSet.getString("login"));
			return usuario;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			System.out.println("Erro Desconhecido" + e.getMessage());
			throw e;
		} finally {

			resultSet.close();
			this.close();
		}
	}

	public void insert(Usuario usuario) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "INSERT INTO Usuario(nome, rg, cpf, rua, cep, cidade, estado, dataNasicmento, email, telefone, login, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Date dataNascimento = new Date(usuario.getDataNascimento().getTime());
			pst = con.prepareStatement(stn);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getRg());
			pst.setString(3, usuario.getCpf());
			pst.setString(4, usuario.getRua());
			pst.setString(5, usuario.getCep());
			pst.setString(6, usuario.getCidade());
			pst.setString(7, usuario.getEstado());
			pst.setDate(8, dataNascimento);
			pst.setString(9, usuario.getEmail());
			pst.setString(10, usuario.getTelefone());
			pst.setString(11, usuario.getLogin());
			pst.setString(12, usuario.getSenha());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.close();
		}
	}
	
	public void update(Usuario usuario) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
			String stn = "UPDATE Usuario SET nome = ?, rg = ?, cpf = ?, rua = ?, cep = ?, cidade = ?, estado = ?, dataNascimento = ?, email = ?, telefone = ?, login = ?, senha = ? WHERE codUsuario = ?";
			pst = con.prepareStatement(stn);
			pst.setString(1, usuario.getNome());
			pst.setString(2, usuario.getRg());
			pst.setString(3, usuario.getCpf());
			pst.setString(4, usuario.getRua());
			pst.setString(5, usuario.getCep());
			pst.setString(6, usuario.getCidade());
			pst.setString(7, usuario.getEstado());
			pst.setDate(8, (Date) usuario.getDataNascimento());
			pst.setString(9, usuario.getEmail());
			pst.setString(10, usuario.getTelefone());
			pst.setString(11, usuario.getLogin());
			pst.setString(12, usuario.getSenha());
			pst.setLong(13, usuario.getCodUsuario());
			pst.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			con.close();
			this.close();
		}
	}

	public void delete(long valorChave) throws Exception {
		PreparedStatement pst = null;
		Connection con = null;
		try {
			con = this.getConexao();
		} catch (Exception e) {
			throw e;
		}
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("DELETE FROM Usuario WHERE codUsuario = ?");
			pst.setLong(1, valorChave);
			rs = pst.executeQuery();
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
	}
	
}

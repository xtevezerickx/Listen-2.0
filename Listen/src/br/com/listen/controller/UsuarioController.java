package br.com.listen.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.listen.jdbc.UsuarioDB;
import br.com.listen.model.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("cadastrarUsuario")
	public String formCadastrarUsuario() {
		return "usuario/cadastrarUsuario";
	}

	@RequestMapping("login")
	public String formFazerLogin() {
		return "usuario/login";
	}

	@RequestMapping("adicionarUsuario")
	public String adiciona(@Valid Usuario usuario) throws Exception {
		try {
			UsuarioDB dao = new UsuarioDB();
			dao.insert(usuario);
			return "usuario/cadastrarUsuario";
		} catch (Exception e) {
			throw e;
		}

	}
}

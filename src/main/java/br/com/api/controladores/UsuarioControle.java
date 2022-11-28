package br.com.api.controladores;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.dto.UsuarioDto;
import br.com.api.interfaces.UsuarioRepositorio;
import br.com.api.modelos.Usuario;
import br.com.api.servicos.UsuarioServicos;

// CHAMADA DA CLASSE
@RestController
@RequestMapping("/usuarios")
public class UsuarioControle {

	private static final int Usuario = 0;
	// INSTANCIANDO O REPOSITORIO
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private UsuarioServicos usuarioServicos;


	// CHAMADA DO METODO PARA INCLUIR USUARIO
	@PostMapping
	public @ResponseBody Usuario novoUsuario(@Valid Usuario usuario) {
		usuarioRepositorio.save(usuario);
		return usuario;

	}

	// CHAMADA DO METODO PARA OBTER TODOS OS USUARIOS
	@GetMapping
	public Iterable<Usuario> obterUsuarios() {
		return usuarioRepositorio.findAll();

	}

	// CHAMADA DO METODO PELO IDENTIFICADOR
	@GetMapping(path = "/{id}")
	public UsuarioDto obterUsuarioId(@PathVariable int id) {
		return usuarioServicos.findById(id);
	}

	// CHAMADA DO METODO PARA ALTERAR USUARIO
	@PutMapping("/alterarusuario")
	public @ResponseBody Usuario alterarUsuario(@Valid Usuario usuario) {
		usuarioRepositorio.save(usuario);
		return usuario;

	}

	// CHAMADA DO METODO PARA DELETAR USUARIO
	@DeleteMapping(path = "/{id}")
	public void excluirUsuarioId(@PathVariable int id) {
		usuarioRepositorio.deleteById(id);
	}

	// CHAMADA DO METODO PARA COLOCAR A QUANTIDADE DE USUARIO POR PAGINA
	@GetMapping(path = "/pagina/{numeroPagina}/{qtdePagina}")
	public Iterable<Usuario> obterUsuarioPagina(@PathVariable int numeroPagina, @PathVariable int qtdePagina) {
		if (qtdePagina >= 5)
			qtdePagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdePagina);
		return usuarioRepositorio.findAll(page);
	}

	// CHAMADA DO METODO PARA LOCALIZAR USUARIO PELO NOME
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Usuario> obterUsuariosNome(@PathVariable String parteNome) {
		return usuarioRepositorio.findByNomeContainingIgnoreCase(parteNome);

	}

	//// CHAMADA DO METODO LOGIN
	@GetMapping(path = "/{email}/{senha}")
	public Optional<Usuario> logar(@PathVariable String email, @PathVariable String senha) {
		Optional<Usuario> usuario = usuarioRepositorio.findByEmailAndSenha(email, senha);
		return usuario;

	}

}

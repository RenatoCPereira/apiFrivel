package br.com.api.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.dto.UsuarioDto;
import br.com.api.interfaces.UsuarioRepositorio;
import br.com.api.modelos.Usuario;

@Service
public class UsuarioServicos {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	public UsuarioDto findById(int id) {
		Usuario usuario = usuarioRepositorio.findById(id).get();
		UsuarioDto dto = new UsuarioDto(usuario);
		return dto;

	}

}

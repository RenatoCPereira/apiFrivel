package br.com.api.interfaces;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.api.modelos.Usuario;

public interface UsuarioRepositorio extends PagingAndSortingRepository<Usuario, Integer> {

	public Iterable<Usuario> findByNomeContainingIgnoreCase(String parteNome);
	
	public Optional<Usuario> findByEmailAndSenha(String email, String senha);

}

package br.com.api.interfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.api.modelos.Receita;

public interface ReceitaRepositorio extends PagingAndSortingRepository<Receita, Integer> {
	


}

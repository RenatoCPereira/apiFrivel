package br.com.api.interfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.api.modelos.Meta;

public interface MetaRepositorio extends PagingAndSortingRepository<Meta, Integer> {

	public Iterable<Meta> findByNomeContainingIgnoreCase(String parteNome);

}

package br.com.api.interfaces;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.api.modelos.Gastos;

public interface GastosRepositorio extends PagingAndSortingRepository<Gastos, Integer>{

}

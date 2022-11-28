package br.com.api.dto;

import br.com.api.modelos.Usuario;

public class UsuarioDto {

	private Integer id;
	private String nome;
	private String senha;
	private String email;

	public UsuarioDto() {

	}

	public UsuarioDto(Integer id, String nome, String senha, String email) {

		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
	}

	public UsuarioDto(Usuario usuario) {

		id = usuario.getId();
		nome = usuario.getNome();
		senha = usuario.getSenha();
		email = usuario.getEmail();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

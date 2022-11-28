package br.com.api.modelos;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Nome")
	@NotBlank(message = "Informe o nome")
	private String nome;

	@Column(name = "Senha")
	@NotBlank(message = "Informe a senha")
	private String senha;

	@Column(name = "Email")
	@NotBlank(message = "Informe o email")

	private String email;

	@Column(name = "DataNascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date nascimento;

	@Column(name = "Estado")
	@NotBlank(message = "Informe o estado")
	private String estado;

	@Column(name = "Cidade")
	@NotBlank(message = "Informe a cidade")
	private String cidade;

	@OneToMany(mappedBy = "usuario")
	private List<Meta> meta;

	@OneToMany(mappedBy = "usuario")
	private List<Receita> receita;

	@OneToMany(mappedBy = "usuario")
	private List<Gastos> gastos;

	public Usuario() {
	}

	public Usuario(int id, @NotBlank(message = "Informe o nome") String nome,
			@NotBlank(message = "Informe a senha") String senha,
			@NotBlank(message = "Informe o email") @Email String email, Date nascimento,
			@NotBlank(message = "Informe o estado") String estado,
			@NotBlank(message = "Informe a cidade") String cidade, List<Meta> meta, List<Receita> receita,
			List<Gastos> gastos) {
		this.id = id;
		this.nome = nome;
		this.senha = senha;
		this.email = email;
		this.nascimento = nascimento;
		this.estado = estado;
		this.cidade = cidade;
		this.meta = meta;
		this.receita = receita;
		this.gastos = gastos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Meta> getMeta() {
		return meta;
	}

	public void setMeta(List<Meta> meta) {
		this.meta = meta;
	}

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

	public List<Gastos> getGastos() {
		return gastos;
	}

	public void setGastos(List<Gastos> gastos) {
		this.gastos = gastos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, email, estado, gastos, id, meta, nascimento, nome, receita, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cidade, other.cidade) && Objects.equals(email, other.email)
				&& Objects.equals(estado, other.estado) && Objects.equals(gastos, other.gastos) && id == other.id
				&& Objects.equals(meta, other.meta) && Objects.equals(nascimento, other.nascimento)
				&& Objects.equals(nome, other.nome) && Objects.equals(receita, other.receita)
				&& Objects.equals(senha, other.senha);
	}
	
	

}

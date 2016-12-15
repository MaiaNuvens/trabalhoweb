package br.ufc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@Entity(name = "USUARIO")
public class Usuario {
	
	@Id
	@Column(name = "USU_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long usuId;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "IDADE")
	private int idade;
	
	//-------------------- Amizade ---------------------
	@OneToMany(mappedBy="usuarioFonte")
	private Set<Amizade> amizades = new HashSet<Amizade>();
	
	//---------------------One to many - Album---------------------------
	
	@OneToMany(mappedBy = "usuario",
			   targetEntity = Album.class,
			   fetch = FetchType.EAGER)
	private Set <Album> albuns;
	
	//---------------------One to many - Album---------------------------
	
	//--------------------Many to many - Comunidade --------------------- 
	//pq aqui tem esse aviso???
	
	@ManyToMany(mappedBy = "usuarios", fetch = FetchType.EAGER)
	private Set <Comunidade> comunidades;
	
	//--------------------Many to many - comunidade ---------------------
	
	//-------------------One to many - Mensagem --------------------
	
	@OneToMany(mappedBy = "usuario",
			   targetEntity = Mensagem.class,
			   fetch = FetchType.EAGER)
	private Set <Mensagem> mensagens;
	
	//-------------------One to many - Mensagem --------------------
	
	//-------------------One to many - Comentario-------------------
	
	@OneToMany(mappedBy = "usuario",
			   targetEntity = Comentario.class,
			   fetch = FetchType.EAGER)
	private Set <Comentario> comentarios;
	
	//-------------------One to many - Comentario-------------------
	
	//-------------------One to many - Forum------------------------
	
	@OneToMany(mappedBy = "usuario",
			   targetEntity = Forum.class,
			    fetch = FetchType.EAGER)
	private Set <Forum> foruns;
	
	//-------------------One to many - Forum------------------------

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Album> getAlbuns() {
		return albuns;
	}

	public void setAlbuns(Set<Album> albuns) {
		this.albuns = albuns;
	}

	public Set<Comunidade> getComunidades() {
		return comunidades;
	}

	public void setComunidades(Set<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}

	public Set<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Set<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Set<Forum> getForuns() {
		return foruns;
	}

	public void setForuns(Set<Forum> foruns) {
		this.foruns = foruns;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Set<Amizade> getAmizades() {
		return amizades;
	}

	public void setAmizades(Set<Amizade> amizades) {
		this.amizades = amizades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuId == null) ? 0 : usuId.hashCode());
		return result;
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
		if (usuId == null) {
			if (other.usuId != null)
				return false;
		} else if (!usuId.equals(other.usuId))
			return false;
		return true;
	}
	
	
	

}

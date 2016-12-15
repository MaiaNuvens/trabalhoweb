package br.ufc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity (name = "CATEGORIA")
public class Categoria {
	
	@Id
	@Column(name = "CAT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long catId;
	
	@Column(name = "NOME")
	private String nome;
	
	//---------------------One to many - Comunidade------------------------
	@OneToMany(mappedBy = "categoria",
			   targetEntity = Comunidade.class, 
			   fetch = FetchType.EAGER)
	private Set <Comunidade> comunidades;
	
	//--------------------One to many - Comunidade------------------------

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Comunidade> getComunidades() {
		return comunidades;
	}

	public void setComunidades(Set<Comunidade> comunidades) {
		this.comunidades = comunidades;
	}
	
	
	

}

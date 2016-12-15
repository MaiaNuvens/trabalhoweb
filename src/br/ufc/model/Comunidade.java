package br.ufc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "COMUNIDADE")
public class Comunidade {
	
	@Id
	@Column(name = "COM_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comId;
	
	@Column(name = "NOME")
	private String nome;
	
	//-----------Many to one - Categoria---------------------
	
	@Column(name = "CAT_ID", insertable = false, updatable = false, nullable = false)
	private Long catId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "CAT_ID", referencedColumnName = "CAT_ID")
	private Categoria categoria;
	
	//----------Many to one - Categoria-----------------------
	
	//----------One to many - Forum---------------------------
	
	@OneToMany(mappedBy = "comunidade",
			   targetEntity = Forum.class,
			   fetch = FetchType.EAGER)
	private Set <Forum> foruns;
	
	//---------One to many - Forum------------------------------
	
	//-------------Many to many - Usuario-----------------
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USUARIO_COMUNIDADE", 
	   joinColumns=@JoinColumn(name = "COM_ID", referencedColumnName = "COM_ID"),
	   inverseJoinColumns=@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID"))
	private Set <Usuario> usuarios;
	
	//-------------many to many - Usuario------------------

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCatId() {
		return catId;
	}

	public void setCatId(Long catId) {
		this.catId = catId;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Forum> getForuns() {
		return foruns;
	}

	public void setForuns(Set<Forum> foruns) {
		this.foruns = foruns;
	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
	
	

}

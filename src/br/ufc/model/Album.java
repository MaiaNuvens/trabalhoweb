package br.ufc.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "ALBUM")
public class Album {
	
	@Id
	@Column(name = "ALB_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long albId;
	
	//---------------------Many to one - Usuario---------------
	
	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
	private Usuario usuario;
	
	//---------------------Many to one - Usuario---------------
	
	//---------------------One to many- Fotos--------------
	
	@OneToMany(mappedBy = "album",
			   targetEntity = Fotos.class,
			   fetch = FetchType.EAGER)
	private Set <Fotos> fotos;
	
	//---------------------One to many- Fotos--------------

	public Long getAlbId() {
		return albId;
	}

	public void setAlbId(Long albId) {
		this.albId = albId;
	}

	public Long getUsuId() {
		return usuId;
	}

	public void setUsuId(Long usuId) {
		this.usuId = usuId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Fotos> getFotos() {
		return fotos;
	}

	public void setFotos(Set<Fotos> fotos) {
		this.fotos = fotos;
	}
	
	
	
	

}
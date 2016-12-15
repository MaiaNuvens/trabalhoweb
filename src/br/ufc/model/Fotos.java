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

@Entity(name = "FOTOS")
public class Fotos {
    
	@Id
	@Column(name = "FOT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long fotId;
	
	//-----------------------Many to one - Album--------
	
	@Column(name = "ALB_ID", insertable = false, updatable = false, nullable = false)
	private Long albId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "ALB_ID", referencedColumnName = "ALB_ID")
	private Album album;
	
	//-----------------------Many yo one - Album--------
	
	//-------------------One to many - Comentario-----------
	
	@OneToMany(mappedBy = "foto",
			   targetEntity = Comentario.class,
			   fetch = FetchType.EAGER)
	private Set <Comentario> comentarios;
	
	//-------------------One to many - Comentario-----------

	public Long getFotId() {
		return fotId;
	}

	public void setFotId(Long fotId) {
		this.fotId = fotId;
	}

	public Long getAlbId() {
		return albId;
	}

	public void setAlbId(Long albId) {
		this.albId = albId;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	
	
	
}

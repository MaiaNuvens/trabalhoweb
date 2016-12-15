package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "COMENTARIO")
public class Comentario {
	
	@Id
	@Column(name = "COM_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comId;
	
	@Column(name = "TEXTO")
	private String texto;
	
	//------------------Many to one - Fotos---------
	
	@Column(name = "FOT_ID", insertable = false, updatable = false, nullable = false)
	private Long fotId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "FOT_ID", referencedColumnName = "FOT_ID")
	private Fotos foto;
	
	//------------------Many to one - Fotos---------
	
	//-----------------Many to one - Usuario---------------
	
	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
	private Usuario usuario;
	
	//-----------------Many to one - Usuario---------------

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getFotId() {
		return fotId;
	}

	public void setFotId(Long fotId) {
		this.fotId = fotId;
	}

	public Fotos getFoto() {
		return foto;
	}

	public void setFoto(Fotos foto) {
		this.foto = foto;
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
	
	
	
	

}
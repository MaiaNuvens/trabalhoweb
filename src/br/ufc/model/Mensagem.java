package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "MENSAGEM")
public class Mensagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MEN_ID", nullable = false)
	private Long menId;
	
	@Column(name = "TEXTO")
	private String texto;
	
	//-----------------Many to one - Forum-----------------
	@Column(name = "FOR_ID", insertable = false, updatable = false, nullable = false)
	private Long forId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "FOR_ID", referencedColumnName = "FOR_ID")
	private Forum forum;
	
	//-----------------Many to one - Forum-----------------
	
	//----------------Many to one - Usuario----------------
	
	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
	private Usuario usuario;
	
	//----------------Many to one - Usuario----------------

	public Long getMenId() {
		return menId;
	}

	public void setMenId(Long menId) {
		this.menId = menId;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getForId() {
		return forId;
	}

	public void setForId(Long forId) {
		this.forId = forId;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menId == null) ? 0 : menId.hashCode());
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
		Mensagem other = (Mensagem) obj;
		if (menId == null) {
			if (other.menId != null)
				return false;
		} else if (!menId.equals(other.menId))
			return false;
		return true;
	}
	
	
	
	

}

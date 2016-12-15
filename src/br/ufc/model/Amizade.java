package br.ufc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="AMIZADE")
public class Amizade {

	@Id
	@Column(name="AMI_ID",nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long amiId;
	
	//VER SE ESSA PARTE É ASSIM MESMO OS JOINCOLUMN
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="USUARIO_ID")
	private Usuario usuarioFonte;
	
	@ManyToOne(optional=false, fetch = FetchType.EAGER)
	@JoinColumn(name="AMIGO_ID")
	private Usuario usuarioAlvo;

	public Long getAmiId() {
		return amiId;
	}

	public void setAmiId(Long amiId) {
		this.amiId = amiId;
	}

	public Usuario getUsuarioFonte() {
		return usuarioFonte;
	}

	public void setUsuarioFonte(Usuario usuarioFonte) {
		this.usuarioFonte = usuarioFonte;
	}

	public Usuario getUsuarioAlvo() {
		return usuarioAlvo;
	}

	public void setUsuarioAlvo(Usuario usuarioAlvo) {
		this.usuarioAlvo = usuarioAlvo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amiId == null) ? 0 : amiId.hashCode());
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
		Amizade other = (Amizade) obj;
		if (amiId == null) {
			if (other.amiId != null)
				return false;
		} else if (!amiId.equals(other.amiId))
			return false;
		return true;
	}
	
	
	
}

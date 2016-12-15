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

@Entity (name = "FORUM")
public class Forum {

	@Id
	@Column(name = "FOR_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long forId;
	
	@Column(name = "TITULO")
	private String titulo;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	//----------------------Many to one - Comunidade---------------------
	@Column(name = "COM_ID", insertable = false, updatable = false, nullable = false)
	private Long comId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "COM_ID", referencedColumnName = "COM_ID")
	private Comunidade comunidade;
	//---------------------Many to one - Comunidade----------------------
	
	//------------------One to many - Mensagem---------------------
	
	@OneToMany(mappedBy = "forum",
			   targetEntity = Mensagem.class,
			   fetch = FetchType.EAGER)
	private Set <Mensagem> mensagens;
	
	//------------------One to many - Mensagem---------------------
	
	//------------------Many to one - Usuario----------------------
	
	@Column(name = "USU_ID", insertable = false, updatable = false, nullable = false)
	private Long usuId;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "USU_ID", referencedColumnName = "USU_ID")
	private Usuario usuario;
	
	//------------------Many to one - Usuario----------------------

	public Long getForId() {
		return forId;
	}

	public void setForId(Long forId) {
		this.forId = forId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public Comunidade getComunidade() {
		return comunidade;
	}

	public void setComunidade(Comunidade comunidade) {
		this.comunidade = comunidade;
	}

	public Set<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(Set<Mensagem> mensagens) {
		this.mensagens = mensagens;
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
		result = prime * result + ((forId == null) ? 0 : forId.hashCode());
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
		Forum other = (Forum) obj;
		if (forId == null) {
			if (other.forId != null)
				return false;
		} else if (!forId.equals(other.forId))
			return false;
		return true;
	}
	
	
    
	
	
	
}

package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Mensagem;
import br.ufc.model.Usuario;

@Repository
public class MensagemDAOHib implements IMensagemDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(Mensagem mensagem) {
		
		entityManager.persist(mensagem);
		
	}

	@Override
	public void alterar(Mensagem mensagem) {
		
		entityManager.merge(mensagem);
		
	}

	@Override
	public Mensagem recuperar(Long id) {
		
		return entityManager.find(Mensagem.class, id);
	}

	@Override
	public void remover(Long id) {
		
		Mensagem m = this.recuperar(id);
		entityManager.remove(m);
		
	}

	@Override
	public List<Mensagem> listar() {
		
		String hql = "select m from MENSAGEM as m";
		return entityManager.createQuery(hql, Mensagem.class).getResultList();
		
	}

}

package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Comentario;

@Repository
public class ComentarioDAOHib implements IComentarioDAO{

	@PersistenceContext
	private EntityManager entityManager;

	
	@Override
	public void inserir(Comentario comentario) {
		
		entityManager.persist(comentario);
	
	}

	@Override
	public void alterar(Comentario comentario) {
		
		entityManager.merge(comentario);
		
	}

	@Override
	public Comentario recuperar(Long id) {
		
		return entityManager.find(Comentario.class, id);
	}

	@Override
	public void remover(Long id) {
		
		Comentario c = this.recuperar(id);
        entityManager.remove(c);	
        
	}

	@Override
	public List<Comentario> listar() {
		
		String hql = "select c from COMENTARIO as c";
		return entityManager.createQuery(hql, Comentario.class).getResultList();
		
	}

}

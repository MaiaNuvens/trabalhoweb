package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Fotos;
import br.ufc.model.Usuario;

@Repository
public class FotosDAOHib implements IFotosDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(Fotos foto) {
		
		entityManager.persist(foto);
		
	}

	@Override
	public void alterar(Fotos foto) {
		
		entityManager.merge(foto);
		
	}

	@Override
	public Fotos recuperar(Long id) {
		
		return entityManager.find(Fotos.class, id);
	}

	@Override
	public void remover(Long id) {
		
		Fotos f = this.recuperar(id);
		entityManager.refresh(f);
		
	}

	@Override
	public List<Fotos> listar() { //funciona isso?
		
		String hql = "select f from FOTOS as f";
		return entityManager.createQuery(hql, Fotos.class).getResultList();
		
	}

}

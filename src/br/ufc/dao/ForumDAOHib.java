package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Forum;


@Repository
public class ForumDAOHib implements IForumDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(Forum forum) {
		
		entityManager.persist(forum);
		
	}

	@Override
	public void alterar(Forum forum) {
		
		entityManager.merge(forum);
		
	}

	@Override
	public Forum recuperar(Long id) {
		
		return entityManager.find(Forum.class, id);
	}

	@Override
	public Forum recuperar(String titulo) { //em f.titulo tem q set f.Titulo?
		
		String hql = "select f from FORUM as f " + "where f.TITULO = :var_titulo";
		Query query = entityManager.createQuery(hql,Forum.class);
		query.setParameter("var_titulo", titulo);
		 
		List<Forum> list = query.getResultList();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		
		Forum f = this.recuperar(id);
		entityManager.remove(f);
		
	}

	@Override
	public List<Forum> listar() {
		
		String hql = "select f from FORUM as f";
		return entityManager.createQuery(hql, Forum.class).getResultList();
		
	}

}

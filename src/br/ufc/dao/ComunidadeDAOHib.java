package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;
import br.ufc.model.Usuario;


@Repository
public class ComunidadeDAOHib implements IComunidadeDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(Comunidade comunidade) {
		
		entityManager.persist(comunidade);
		
	}

	@Override
	public void alterar(Comunidade comunidade) {
		
		entityManager.merge(comunidade);
		
	}

	@Override
	public Comunidade recuperar(Long id) {
		
		return entityManager.find(Comunidade.class, id);
	}

	@Override
	public Comunidade recuperar(Categoria categoria) { // FALTA AQUI :)
		
		return null;
		
	}

	@Override
	public Comunidade recuperar(String Nome) { // nome em c.nome tem q ser c.Nome??
		
		String hql = "select c from COMUNIDADE as c " + "where c.nome = :var_nome";
		Query query = entityManager.createQuery(hql,Usuario.class);
		query.setParameter("var_nome", Nome);
		 
		List<Comunidade> list = query.getResultList();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		
		Comunidade c = this.recuperar(id);
		entityManager.remove(c);
		
	}

	@Override
	public List<Comunidade> listar() {
		
		String hql = "select c from COMUNIDADE as c";
		return entityManager.createQuery(hql, Comunidade.class).getResultList();
		
	}
	
	

}

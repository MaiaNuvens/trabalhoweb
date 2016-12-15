package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Categoria;



@Repository
public class CategoriaDAOHib implements ICategoriaDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(Categoria categoria) {
		
		entityManager.persist(categoria);
		
	}

	@Override
	public void alterar(Categoria categoria) {
		
		entityManager.merge(categoria);
		
	}

	@Override
	public Categoria recuperar(Long id) { //pra q??
		
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public Categoria recuperar(String nome) {  //c.nome ou c.Nome?? Mas pra q essa?? acho q nao precisa, nao faz sentido
		
		String hql = "select c from CATEGORIA as c " + "where u.NOME = :var_nome";
		Query query = entityManager.createQuery(hql,Categoria.class);
		query.setParameter("var_nome", nome);
		 
		List<Categoria> list = query.getResultList();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		
		Categoria c = this.recuperar(id);
		entityManager.remove(c);
		
	}

	@Override
	public List<Categoria> listar() {
		
		String hql = "select c from CATEGORIA as c";
		return entityManager.createQuery(hql, Categoria.class).getResultList();
		
	}

}

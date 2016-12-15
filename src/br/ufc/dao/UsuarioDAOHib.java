package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.ufc.model.Usuario;

@Repository
public class UsuarioDAOHib implements IUsuarioDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void inserir(Usuario usuario) {
		
		entityManager.persist(usuario);
		
	}

	@Override
	public void alterar(Usuario usuario) { //testar um this.
		
		entityManager.merge(usuario);
		
	}

	@Override
	public Usuario recuperar(Long id) {
		
		return entityManager.find(Usuario.class, id);
		
	}

	@Override
	public Usuario recuperar(String login) {  //entender esse aqui-ver se preciso colocar Login com L no u.login
		
		String hql = "select u from USUARIO as u " + "where u.login = :var_login";
		Query query = entityManager.createQuery(hql,Usuario.class);
		query.setParameter("var_login", login);
		 
		List<Usuario> list = query.getResultList();
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void remover(Long id) {
		
		Usuario u = this.recuperar(id);
		entityManager.remove(u);
		
	}

	@Override
	public List<Usuario> listar() {
		
        String hql = "select u from USUARIO as u";
		return entityManager.createQuery(hql, Usuario.class).getResultList();
	}

}

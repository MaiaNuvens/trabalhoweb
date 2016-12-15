package br.ufc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.ufc.model.Album;
import br.ufc.model.Usuario;

@Repository
public class AlbumDAOHib implements IAlbumDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void inserir(Album album) {
		
		entityManager.persist(album);
		
	}

	@Override
	public void alterar(Album album) {
	
		entityManager.merge(album);
		
	}

	@Override
	public Album recuperar(Long id) {
		
		return entityManager.find(Album.class, id);
	}

	@Override
	public Album recuperar(Usuario usuario) { //FALTA AQUI
		
		return null;
	}

	@Override
	public void remover(Long id) {
		
		Album a = this.recuperar(id);
		entityManager.remove(a);
		
	}

	@Override
	public List<Album> listar() {
		
		String hql = "select a from ALBUM as a";
		return entityManager.createQuery(hql, Album.class).getResultList();
		
	}

}

package br.ufc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufc.model.Amizade;

public class AmizadeDAOHib implements IAmizadeDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public void inserir(Amizade amizade) {
	        
		manager.merge(amizade);
		
	}

}

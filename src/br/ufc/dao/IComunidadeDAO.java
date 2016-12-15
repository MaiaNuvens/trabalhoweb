package br.ufc.dao;

import java.util.List;

import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;

public interface IComunidadeDAO {
	
	public void inserir(Comunidade comunidade);
	public void alterar(Comunidade comunidade);
	public Comunidade recuperar(Long id);
	public Comunidade recuperar(Categoria categoria); //pode ser? como?
	public Comunidade recuperar(String Nome);
	public void remover(Long id);
	public List<Comunidade> listar();

}

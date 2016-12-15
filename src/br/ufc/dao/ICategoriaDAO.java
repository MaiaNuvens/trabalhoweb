package br.ufc.dao;

import java.util.List;

import br.ufc.model.Categoria;

public interface ICategoriaDAO { // precisa disso tudo?
	
	public void inserir(Categoria categoria);
	public void alterar(Categoria categoria);
	public Categoria recuperar(Long id);
	public Categoria recuperar(String nome); // necessario??
	public void remover(Long id);
	public List<Categoria> listar();

}

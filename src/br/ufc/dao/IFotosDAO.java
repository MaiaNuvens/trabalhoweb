package br.ufc.dao;

import java.util.List;

import br.ufc.model.Fotos;

public interface IFotosDAO {
	
	public void inserir(Fotos foto);
	public void alterar(Fotos foto);
	public Fotos recuperar(Long id);
	public void remover(Long id);
	public List<Fotos> listar();

}

package br.ufc.dao;

import java.util.List;

import br.ufc.model.Album;
import br.ufc.model.Usuario;

public interface IAlbumDAO {

	public void inserir(Album album);
	public void alterar(Album album);
	public Album recuperar(Long id);
	public Album recuperar(Usuario usuario); //pode?como?
	public void remover(Long id);
	public List<Album> listar(); // isso recupera todos os albuns existentes?
	
}

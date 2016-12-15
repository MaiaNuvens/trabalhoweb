package br.ufc.dao;

import java.util.List;

import br.ufc.model.Usuario;

public interface IUsuarioDAO { // PODE SER UMA UNICA INTERFACE PRA TODOS??
	
	public void inserir(Usuario usuario);
	public void alterar(Usuario usuario);
	public Usuario recuperar(Long id);
	public Usuario recuperar(String login);
	public void remover(Long id);
	public List<Usuario> listar();

}

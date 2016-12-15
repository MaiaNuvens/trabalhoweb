package br.ufc.dao;

import java.util.List;

import br.ufc.model.Forum;

public interface IForumDAO {
	
	public void inserir(Forum forum);
	public void alterar(Forum forum);
	public Forum recuperar(Long id);
	public Forum recuperar(String titulo); //pode ter um por comunidade? ou nao ne? comunidade pode recuperar seus foruns la
	public void remover(Long id);
	public List<Forum> listar();

}

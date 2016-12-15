package br.ufc.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.ufc.model.Album;
import br.ufc.model.Categoria;
import br.ufc.model.Comentario;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;
import br.ufc.model.Fotos;
import br.ufc.model.Mensagem;
import br.ufc.model.Usuario;

public class TestarRelacionamento {
	
public static void main(String[] args) {
		
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("teste_aula_rc");
		EntityManager manager = factory.createEntityManager(); 
		
		//cria usuario
		/*
				Usuario u = new Usuario();
				u.setNome("Chuck Noland");
			
				manager.getTransaction().begin();
				manager.persist(u);
			    manager.getTransaction().commit();
				//cria usuario
		*/
		//cria categoria
		/*
				Categoria c = new Categoria();
				c.setNome("Local");
				
				Categoria c2 = new Categoria();
				c2.setNome("Outros");
				
				manager.getTransaction().begin();
				manager.persist(c2);
				manager.getTransaction().commit();
			
				manager.getTransaction().begin();
				manager.persist(c);
				manager.getTransaction().commit();
				
				*/   //cria categoria
		
		// Testa relacionamento usuario-comunidade-categoria?? cria comunidade
		/*Usuario usu = manager.find(Usuario.class, 1L);
		System.out.println("->"+usu.getNome());
		
		Categoria cat = manager.find(Categoria.class, 1L);
		System.out.println("->"+cat.getNome());
		
		Comunidade comunidade = new Comunidade();
		comunidade.setNome("Ilha");
		comunidade.setCategoria(cat);
		List<Comunidade> com = new ArrayList<Comunidade>();
		com.add(comunidade);
		usu.setComunidades(com);
		
		manager.getTransaction().begin();
		manager.persist(comunidade);
		manager.getTransaction().commit();*/
		
		
		
		// testa relacionamento comunidade-forum cria forum
		/*Comunidade com = manager.find(Comunidade.class, 1L);
		System.out.println("->"+com.getNome());
		
		Usuario us = manager.find(Usuario.class, 1L);
		
		
        Forum forum = new Forum();
		forum.setTitulo("amizade");
		forum.setComunidade(com);
		forum.setUsuario(us);
		
		manager.getTransaction().begin();
		manager.persist(forum);
		manager.getTransaction().commit();*/
		
		// testa relacionamento forum-mensagem AQUI DEU ERRO
		  /*
		  Forum foru = manager.find(Forum.class, 1L);
		 
		  Usuario us = manager.find(Usuario.class, 1L);
		  System.out.println("->"+us.getNome());
		  
		  Mensagem mensagem = new Mensagem();
		  mensagem.setTexto("me desculpe, wilson");
		  mensagem.setUsuario(us);
		  mensagem.setForum(foru);
		  
		  manager.getTransaction().begin();
		  manager.persist(mensagem);
		  manager.getTransaction().commit();*/
		
		
		//testa relacionamento usuario-album
		  
		   /*Usuario usua = manager.find(Usuario.class, 1L);
		   System.out.println("->"+usua.getNome());
		   
		   Album album = new Album();
		   album.setUsuario(usua);
		  
		   manager.getTransaction().begin();
		   manager.persist(album);
		   manager.getTransaction().commit();*/
		 
		
		  // testa relacionamento album-fotos
		 //foto so tem id
		 
		 /* Album al = manager.find(Album.class, 1L);
		  
		  Fotos fotos = new Fotos();
		  fotos.setAlbum(al);
		 
		  manager.getTransaction().begin();
		  manager.persist(fotos);
		  manager.getTransaction().commit();*/
		 
		
		//testa relacionamento fotos-comentarios
		  
		  Fotos fot = manager.find(Fotos.class, 1L);
		  
		  
		  Usuario us1 = manager.find(Usuario.class, 1L);
		  System.out.println("->"+us1.getNome());
		  
		  Comentario comentario = new Comentario();
		  comentario.setTexto("meu amigo");
		  comentario.setFoto(fot);
		  comentario.setUsuario(us1);
		 
		  manager.getTransaction().begin();
		  manager.persist(comentario);
		  manager.getTransaction().commit();
		
		
}		

}

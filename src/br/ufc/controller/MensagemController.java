package br.ufc.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IForumDAO;
import br.ufc.dao.IMensagemDAO;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;
import br.ufc.model.Mensagem;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class MensagemController {

	@Autowired
	@Qualifier(value = "mensagemDAOHib")
	private IMensagemDAO mensagemDAO;
	
	@Autowired
	@Qualifier(value = "forumDAOHib")
	private IForumDAO forumDAO;
	
	@Autowired
	@Qualifier(value = "comunidadeDAOHib")
	private IComunidadeDAO comunidadeDAO;
	
	@RequestMapping("/cadastrarMensagem")
	public String cadastrarForum(Long id, HttpSession session, Mensagem mensagem){
		//recuperando forum e usuario logado
		Forum f = forumDAO.recuperar(id);
		Usuario us = (Usuario) session.getAttribute("usuario_logado");
		//verificando se usuario logado participa da comunidade
		Comunidade com = comunidadeDAO.recuperar(f.getComId());
		Set<Usuario> usuarios = new HashSet<Usuario>();
		usuarios = com.getUsuarios();
		if(usuarios.contains(us)){
			//criando a mensagem
			mensagem.setForum(f);
			mensagem.setUsuario(us);
			mensagemDAO.inserir(mensagem);
			return "redirect:mostrarPerfilForum?id="+f.getForId();
		}
		
		return "redirect:mensagemDeErroMensagem";
	}
	
	@RequestMapping("/mensagemDeErroMensagem")
	public String mensagemDeErro(){
		return "mensagens/mensagem_erro";
	}
	
	@RequestMapping("/apagarMensagem")
	public String apagarMensagem(Long id) { 
        Mensagem men = mensagemDAO.recuperar(id);
		mensagemDAO.remover(id);
		return "redirect:mostrarPerfilForum?id="+men.getForId();
        
	}
	
}

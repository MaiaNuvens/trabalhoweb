package br.ufc.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IForumDAO;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;
import br.ufc.model.Mensagem;
import br.ufc.model.Usuario;


@Transactional
@Controller
public class ForumController {
	
	@Autowired
	@Qualifier(value = "forumDAOHib")
	private IForumDAO forumDAO;
	
	@Autowired
	@Qualifier(value = "comunidadeDAOHib")
	private IComunidadeDAO comunidadeDAO;
	
	
	@RequestMapping("/cadastrarForum")
	public String cadastrarForum(Long id,Forum forum, HttpSession session){
		//recuperando comunidade e usuario logado
		Comunidade com = comunidadeDAO.recuperar(id);
		Usuario us = (Usuario) session.getAttribute("usuario_logado");
		//verificando se usuario existe na comunidade
		Set<Usuario> usuarios = new HashSet<Usuario>();
		usuarios = com.getUsuarios();
		if(usuarios.contains(us)){
			//essa parte persiste o forum
			forum.setComunidade(com);
			forum.setUsuario(us);
			forumDAO.inserir(forum);
			return "redirect:mostrarPerfilComunidade?id="+com.getComId();
		}
		return "redirect:mensagemDeErroForum";
		
	}
	
	@RequestMapping("/mensagemDeErroForum")
	public String mensagemDeErro(){
		return "foruns/mensagem_erro";
	}
	
	@RequestMapping("/mostrarPerfilForum")
	public String mostrarPerfilComunidade (Long id,Model model, HttpSession session){
		Usuario us = (Usuario) session.getAttribute("usuario_logado");
		Forum f = forumDAO.recuperar(id);
		Set<Mensagem> mensagens = f.getMensagens();
		Comunidade com = comunidadeDAO.recuperar(f.getComId());
		model.addAttribute("forum", f);
		model.addAttribute("mensagens", mensagens);
		model.addAttribute("comunidade", com);
		model.addAttribute("usuario", us);
		return "foruns/perfil";
	}
	
	@RequestMapping("/apagarForum")
	public String apagarForum(Long id) { // TENHO QUE APAGAR MENSAGENS TBM :(
        Forum f = forumDAO.recuperar(id);
        
		forumDAO.remover(id);
		return "redirect:mostrarPerfilComunidade?id="+f.getComId();
        
	}
	
	

}

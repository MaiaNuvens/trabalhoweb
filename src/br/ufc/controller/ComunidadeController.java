package br.ufc.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ICategoriaDAO;
import br.ufc.dao.IComunidadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Categoria;
import br.ufc.model.Comunidade;
import br.ufc.model.Forum;
import br.ufc.model.Usuario;



@Transactional
@Controller
public class ComunidadeController {


	@Autowired
	@Qualifier(value = "comunidadeDAOHib")
	private IComunidadeDAO comunidadeDAO;
	
	@Autowired
	@Qualifier(value = "categoriaDAOHib")
	private ICategoriaDAO categoriaDAO;
	
	@Autowired
	@Qualifier(value = "usuarioDAOHib")
	private IUsuarioDAO usuarioDAO;
	
	@RequestMapping("/mostrarPerfilComunidade")
	public String mostrarPerfilComunidade (Long id,Model model, HttpSession session){
		Usuario us = (Usuario) session.getAttribute("usuario_logado");
		Comunidade c = comunidadeDAO.recuperar(id);
		Set<Usuario> usuarios = c.getUsuarios();
		Set<Forum> foruns = c.getForuns();
		boolean pertence = usuarios.contains(us);
		model.addAttribute("comunidade", c);
		model.addAttribute("usuarios",usuarios);
		model.addAttribute("foruns", foruns);
		model.addAttribute("usuario", us);
		model.addAttribute("pertence", pertence);
		return "comunidades/perfil";
	}
	
	@RequestMapping("/cadastrarComunidadeFormulario")
	public String cadastrarComunidadeFormulario(Model model){
		model.addAttribute("categorias", categoriaDAO.listar());
		return "comunidades/cadastrar_comunidade_formulario";
	}
	
	@RequestMapping("/cadastrarComunidade")
	public String cadastrarUsuario(Comunidade comunidade, Long cat, HttpSession session){
		Usuario usuario = (Usuario) session.getAttribute("usuario_logado");
		Set<Usuario> u = new HashSet<Usuario>();
		u.add(usuario);
		Categoria categoria = categoriaDAO.recuperar(cat);
		comunidade.setCategoria(categoria);
		comunidade.setUsuarios(u);
		comunidadeDAO.inserir(comunidade);
		/*Usuario alterado = usuarioDAO.recuperar(usuario.getUsuId());
		session.setAttribute("usuario_logado", alterado);*/
		return "redirect:mostrarPerfilComunidade?id="+comunidade.getComId();
	}
	
	@RequestMapping("/listarComunidades")
	public String listarComunidade(Model model){  //MOSTRAR ENTRAR SO PARA QUEM NAO PARTICIPA--meio complicado :(
		List<Comunidade> comunidades = comunidadeDAO.listar();
		model.addAttribute("comunidades", comunidades);
		return "comunidades/listar_comunidades";
	}
	
	@RequestMapping("/adicionarUsuario")
	public String adicionarUsuario(Long id, HttpSession session){
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		Comunidade com = comunidadeDAO.recuperar(id);
		Set<Usuario> us = com.getUsuarios();
		us.add(u);
		comunidadeDAO.alterar(com);
		return "redirect:mostrarPerfilComunidade?id="+com.getComId();
		
	}
	
}

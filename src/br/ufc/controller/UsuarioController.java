package br.ufc.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IAmizadeDAO;
import br.ufc.dao.IUsuarioDAO;
import br.ufc.form.AmizadeCheckboxForm;
import br.ufc.model.Amizade;
import br.ufc.model.Comunidade;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class UsuarioController {
	
	// comentario teste git
	
	@Autowired
	@Qualifier(value = "usuarioDAOHib")
	private IUsuarioDAO usuarioDAO;
	
	@Autowired
	@Qualifier(value = "amizadeDAOHib")
	private IAmizadeDAO amizadeDAO;
	
	@RequestMapping("/cadastrarUsuario")
	public String cadastrarUsuario(Usuario usuario){
		
		usuarioDAO.inserir(usuario);
		return "usuarios/cadastro_ok";
	}
	
	@RequestMapping("/mostrarPerfil")
	public String mostrarPerfil (Long id, Model model, HttpSession session){
		Usuario u = usuarioDAO.recuperar(id);
		if(u.getUsuId() != ((Usuario)session.getAttribute("usuario_logado")).getUsuId()){
			Set<Comunidade> com = u.getComunidades();
			Set<Amizade> amigos = u.getAmizades();
			model.addAttribute("usuario", u);
			model.addAttribute("comunidades", com);
			model.addAttribute("amigos", amigos);
			return "usuarios/perfil";
		}
		
		return "redirect:mostrarPerfilLogado";
	}
	
	@RequestMapping("/mostrarPerfilLogado")
	public String mostrarPerfilLogado (HttpSession session ,Model model){
		
		Usuario u = (Usuario) session.getAttribute("usuario_logado");
		Usuario alterado = usuarioDAO.recuperar(u.getUsuId());
		
		Set<Comunidade> com = alterado.getComunidades();
		Set<Amizade> amigos = alterado.getAmizades();
		
		model.addAttribute("comunidades", com);
		model.addAttribute("usuario", u);
		model.addAttribute("amigos", amigos);
		return "usuarios/perfil_logado";
	}
	
	@RequestMapping("/alterarUsuario")  
	public String alterarUsuario(Usuario u, HttpSession session) {
		
		usuarioDAO.alterar(u);
		Usuario alterado = usuarioDAO.recuperar(u.getUsuId());
		session.setAttribute("usuario_logado", alterado);
		return "redirect:mostrarPerfil?id="+u.getUsuId();
	}
	
	@RequestMapping("/listarUsuarios")
	public String listarUsuarios (Model model){
		
		List<Usuario> usuarios = usuarioDAO.listar();
		model.addAttribute("usuarios", usuarios);
		return "usuarios/listar_usuarios";
	}
	
	@RequestMapping("/voltarPaginaInicial")
	public String voltarPaginaInicial (){
		return "pagina_inicial";
	}
	
	@RequestMapping("/inserirAmizadeFormulario")
	public String inserirAmizadeFormulario(Long id, Model model){
		Usuario usuario = usuarioDAO.recuperar(id);
		List<Usuario> potenciaisAmigos = usuarioDAO.listar();
		potenciaisAmigos.remove(usuario);
		
		AmizadeCheckboxForm acf = new AmizadeCheckboxForm();
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("potenciais_amigos",potenciaisAmigos);
		model.addAttribute("amizade",acf);
		
		return "usuarios/inserir_amizade_formulario";
	}
	
	@RequestMapping("/inserirAmizade")
	public String inserirAmizade(HttpSession session, AmizadeCheckboxForm amizades){
		
		Usuario amigoFonte = (Usuario)session.getAttribute("usuario_logado");
		
		for(Long id:amizades.getAmigos()){
			Usuario amigoAlvo = usuarioDAO.recuperar(id);
			Amizade amizade = new Amizade();
			amizade.setUsuarioFonte(amigoFonte);
			amizade.setUsuarioAlvo(amigoAlvo);
			amizadeDAO.inserir(amizade);
		}
		
		return "redirect:listarUsuarios";
	}
	
	@RequestMapping("/irParaInicio")
	public String irParaInicio (){
		return "inicio";
	}

}

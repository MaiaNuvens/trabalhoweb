package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.IUsuarioDAO;
import br.ufc.model.Usuario;

@Transactional
@Controller
public class LoginController {
	
	@Autowired
	@Qualifier(value = "usuarioDAOHib")
	private IUsuarioDAO usuarioDAO;
	
	@RequestMapping("/login")
	public String login(HttpSession session, Usuario usuario){
			Usuario u = this.usuarioDAO.recuperar(usuario.getLogin());
			if(u!=null){
				if(u.getSenha().equals(usuario.getSenha())){
					session.setAttribute("usuario_logado", u);
					return "pagina_inicial"; //fazer menu e mudar aqui para (perfil??)
				}
			}
			
			return "redirect:index";
	}
	
	@RequestMapping("/logout")
	public String logout (HttpSession session){
		
		session.invalidate();
		return "login_ok";
		
	}

}

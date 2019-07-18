package com.demo.app.custumer;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.app.customer.CustomerService;
import com.demo.app.usuario.Usuario;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;
    Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/listar")
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("listar");
		
		List<Usuario> listUsuario = service.listAll();
		
		mav.addObject("listUsuarios", listUsuario);
		
		
		return mav;
	}
	
	@RequestMapping(value = "/home", method =RequestMethod.GET)
	public String adentro(ModelMap model) {
		model.put("usuario", new Usuario());
		return "home";
	}

	
	@RequestMapping(value = "/logout", method =  RequestMethod.GET)
	public String logOut(ModelMap model, HttpSession session) {
		session.removeAttribute("usuario");
		return "redirect:/";
	}
	
	@RequestMapping("/")
	public String home() {
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String newUsuarioForm(Map<String,Object> model) {
		model.put("usuario", new Usuario());
		
		return "crear";
	}
	
	@RequestMapping(value="/iniciar" , method = RequestMethod.POST)
	public String Inicio(ModelMap model,@ModelAttribute("usuario")Usuario usuario, HttpSession session) {

			usuario= CustomerService.validar(usuario.getNombreUsuario(), usuario.getContrasenia());
			
			if(usuario!=null) {
				session.setAttribute("usuario", usuario);
				return "redirect:home";
			}else {
				model.put("falied", "Login Falied");
				return "iniciar";
			}

	
		
	}
	
	@RequestMapping(value="/iniciar" , method = RequestMethod.GET)
	public String InicioForm(Locale locale, ModelMap model, HttpSession session) {
		if(session.getAttribute("usuario")==null) {
			model.put("usuarioData", new Usuario());
			return "iniciar";
		}else {
			return "redirect:home";
		}

		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUsuario(@ModelAttribute("usuario") Usuario usuario) {
		List<Usuario> listUsuario = service.listAll();
		if(service.duplicado(usuario.getCorreo(),listUsuario)) {
			return "duplicado";
		}else {
			service.save(usuario);
		}
		
		return "redirect:/";
	}
	
	
}

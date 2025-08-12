package com.cibertec.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.security.entity.Usuario;
import com.cibertec.security.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/")
    public String index() {
        return "publico/index";
    }
	
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    
    @PostMapping("/registrar")
    public String registrar(Usuario usuario) {
        usuarioService.registrarUsuario(usuario);
        return "redirect:/login";
    }
}


package com.cibertec.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cibertec.security.entity.Usuario;

public interface UsuarioService {
	
    Usuario buscarPorUsername(String username);
    
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
    void registrarUsuario(Usuario usuario);
}
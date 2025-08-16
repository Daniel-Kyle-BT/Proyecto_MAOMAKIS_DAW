package com.cibertec.security.service;

import com.cibertec.security.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> buscarPorUsername(String username);
    
    Usuario registrarUsuario(Usuario usuario);
    
    List<Usuario> listarUsuarios();
}

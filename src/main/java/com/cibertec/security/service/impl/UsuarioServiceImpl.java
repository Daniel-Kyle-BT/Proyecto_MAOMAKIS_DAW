package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Usuario;
import com.cibertec.security.repository.UsuarioRepository;
import com.cibertec.security.service.UsuarioService;
import com.cibertec.security.entity.Rol;
import com.cibertec.security.repository.RolRepository;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, org.springframework.security.core.userdetails.UserDetailsService  {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RolRepository rolRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        // Convertimos el rol único a una lista de GrantedAuthority
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getDescripcion().toUpperCase());
        boolean enabled = Boolean.TRUE.equals(usuario.getEstado());

        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                enabled,    // enabled
                true,       // accountNonExpired
                true,       // credentialsNonExpired
                true,       // accountNonLocked
                Collections.singletonList(authority)
        );
    }

	@Override
	public void registrarUsuario(Usuario usuario) {
	     // Encriptar contraseña
	     usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
	     Rol rolUser = rolRepository.findByDescripcion("USER");
	     usuario.setRol(rolUser);
	     usuarioRepository.save(usuario);
	}
}

package com.cibertec.security.service.impl;

import com.cibertec.security.entity.Usuario;
import com.cibertec.security.entity.Empleado;
import com.cibertec.security.repository.UsuarioRepository;
import com.cibertec.security.repository.EmpleadoRepository;
import com.cibertec.security.repository.RolRepository;
import com.cibertec.security.service.UsuarioService;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    
    private final  EmpleadoRepository empleadoRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository,
                              RolRepository rolRepository,
                              PasswordEncoder passwordEncoder,
                              EmpleadoRepository empleadoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.empleadoRepository = empleadoRepository;
    } 

    @Override
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario, String codigoEmpleado) {
        if (usuarioRepository.existsByUsername(usuario.getUsername())) {
            throw new IllegalArgumentException("Username ya existe");
        }

        Empleado empleado = empleadoRepository.findByCodigo(codigoEmpleado)
        		.orElseThrow(() -> new NoSuchElementException("Empleado no encontrado"));
        
        if (empleado.getCargo().getId() > 4) {
            throw new SecurityException("Cargo no autorizado");
        }
    	
    	usuario.setEmpleado(empleado);
        usuario.setRol(rolRepository.findById(empleado.getCargo().getId())
                .orElseThrow(() -> new NoSuchElementException("Rol no encontrado")));
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        
        return usuarioRepository.save(usuario);
    }

    // Security
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("usuario no encontrado"));
        var authority = new SimpleGrantedAuthority("ROLE_" + u.getRol().getDescripcion().toUpperCase());
        return new User(u.getUsername(), u.getPassword(), u.getEstado(), true, true, true,
                Collections.singletonList(authority));
    }

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}
}
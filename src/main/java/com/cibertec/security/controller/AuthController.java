package com.cibertec.security.controller;

import com.cibertec.security.dto.RolDTO;
import com.cibertec.security.dto.UsuarioDTO;
import com.cibertec.security.entity.Usuario;
import com.cibertec.security.jwt.JwtUtil;
import com.cibertec.security.service.UsuarioService;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private final UsuarioService usuarioService;

    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil,
                          UserDetailsService userDetailsService, UsuarioService usuarioService) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String,String> body) {
        var username = body.get("username");
        var password = body.get("password");
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        var token = jwtUtil.generarToken(username, new HashMap<>()); 
        
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        
        return ResponseEntity.ok(response);
    }

	@PostMapping("/register/{codigoEmpleado}")
	public ResponseEntity<?> register(@RequestBody Usuario usuario, @PathVariable String codigoEmpleado) {
		try {
			Usuario saved = usuarioService.registrarUsuario(usuario, codigoEmpleado);
	        // Construir DTO seguro
			UsuarioDTO response = new UsuarioDTO(
					null,
					null,
					null,
		            new RolDTO(null, null),
		            saved.getEmpleado().getNombre(),
		            saved.getEmpleado().getApellido()
	        );
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (NoSuchElementException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empleado no encontrado");
		} catch (SecurityException e) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Empleado no autorizado para registrarse");
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			if ("El nombre de usuario ya está en uso".equals(msg)
					|| "El empleado ya tiene un usuario registrado".equals(msg)) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(msg);
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(msg);
		}
	}
    
    @GetMapping("/me")
    public ResponseEntity<UsuarioDTO> getCurrentUser(Authentication authentication) {
        var username = authentication.getName();
        var usuario = usuarioService.buscarPorUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        var dto = new UsuarioDTO(
            usuario.getUsername(),
            usuario.getEmpleado().getId(),
            usuario.getEmpleado().getCodigo(),
            new RolDTO(usuario.getRol().getId(), usuario.getRol().getDescripcion()),
            usuario.getEmpleado().getNombre(),
            usuario.getEmpleado().getApellido()
        );
        return ResponseEntity.ok(dto);
    }
}

package com.cibertec.security.controller;

import com.cibertec.security.entity.Usuario;
import com.cibertec.security.jwt.JwtUtil;
import com.cibertec.security.service.UsuarioService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    public ResponseEntity<Map<String,String>> login(@RequestBody Map<String,String> body) {
        var username = body.get("username");
        var password = body.get("password");
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        var token = jwtUtil.generarToken(username, new HashMap<>());
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        var saved = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    
    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
    	List<Usuario> usuarios = usuarioService.listarUsuarios();
    	return ResponseEntity.ok(usuarios);
    }
}

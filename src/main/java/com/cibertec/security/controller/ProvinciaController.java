package com.cibertec.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.security.entity.Provincia;
import com.cibertec.security.service.ProvinciaService;

import java.util.List;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;
    @GetMapping
    public ResponseEntity<List<Provincia>> buscarDistritosFiltro(
            @RequestParam(required = false, defaultValue = "0") Integer idDepartamento)
             {
        return ResponseEntity.ok(provinciaService.listarPorDepatamentoId(idDepartamento));
    }
    
}

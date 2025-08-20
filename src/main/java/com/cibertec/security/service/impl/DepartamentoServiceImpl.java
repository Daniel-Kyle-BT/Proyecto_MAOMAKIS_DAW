package com.cibertec.security.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.security.entity.Departamento;
import com.cibertec.security.repository.DepartamentoRepository;
import com.cibertec.security.service.DepartamentoService;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository repo;

    public DepartamentoServiceImpl(DepartamentoRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Departamento> listarTodo() {
        return repo.findAll();
    }

    @Override
    public Departamento buscarPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Departamento registrar(Departamento departamento) {
        return repo.save(departamento);
    }

    @Override
    public Departamento actualizar(Departamento departamento) {
        return repo.save(departamento);
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}

package com.cibertec.security.controller;

import com.cibertec.security.service.DistritoService;
import com.cibertec.security.service.ProvinciaService;
import com.cibertec.security.service.DepartamentoService;
import com.cibertec.security.service.CargoEmpleadoService;
import com.cibertec.security.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/privado/empleado")
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private CargoEmpleadoService cargoEmpleadoService;

	@Autowired
	private DistritoService distritoService;

	@Autowired
	private ProvinciaService provinciaService;

	@Autowired
	private DepartamentoService departamentoService;

	int temporal = 0;

	@GetMapping
	public String listarEmpleados(@RequestParam(defaultValue = "true") boolean estado,
			@RequestParam(defaultValue = "0") int idCargo, @RequestParam(defaultValue = "0") int idDistrito,
			@RequestParam(defaultValue = "0") int idProvincia, @RequestParam(defaultValue = "0") int idDepartamento,
			@RequestParam(required = false) String keyword, Model model) {

		if (temporal != idDepartamento) {
			idProvincia = 0;
			idDistrito = 0;
			temporal = idDepartamento;
		}

		model.addAttribute("listaEmpleados",empleadoService.listarEmpleadoPorFiltros(estado, idCargo, idDistrito, idProvincia, idDepartamento));
		model.addAttribute("listaCargos", cargoEmpleadoService.listarTodo());
		model.addAttribute("listaDistrito", distritoService.listartPorProvinciaId(idProvincia));
		model.addAttribute("listaProvincia", provinciaService.listarPorDepatamentoId(idDepartamento));
		model.addAttribute("listaDepartamento", departamentoService.listarTodo());
		model.addAttribute("estadoActual", estado);
		model.addAttribute("idCargo", idCargo);
		model.addAttribute("idDistrito", idDistrito);
		model.addAttribute("idProvincia", idProvincia);
		model.addAttribute("idDepartamento", idDepartamento);

		return "/privado/empleado/index";
	}

	@PostMapping("/{id}/estado")
	public String cambiarEstadoEmpleado(@PathVariable Long id, @RequestParam boolean estadoActual,
			@RequestParam boolean estadoFiltro, @RequestParam int idArea, @RequestParam int idCargo) {

		empleadoService.cambiarEstadoEmpleado(id, !estadoActual);

		return "redirect:/privado/empleado?estado=" + estadoFiltro + "&idArea=" + idArea + "&idCargo=" + idCargo;
	}

	@GetMapping("/new")
	public String mostrarFormularioNuevo(Model model) {
		return "/privado/empleado/create";
	}

	@GetMapping("/edit/{id}")
	public String mostrarEditar(@PathVariable Long id, Model model) {
		return "/privado/empleado/edit";
	}

	@GetMapping("/info/{id}")
	public String mostrarDetalle(@PathVariable Long id, Model model) {
		return "/privado/empleado/info";
	}
}
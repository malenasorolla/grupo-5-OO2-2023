package com.unla.grupo5OO22023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo5OO22023.entity.Dispositivo;
import com.unla.grupo5OO22023.entity.SensorLuz;
import com.unla.grupo5OO22023.entity.SensorProximidad;
import com.unla.grupo5OO22023.helpers.ViewRouteHelper;
import com.unla.grupo5OO22023.models.DispositivoModel;
import com.unla.grupo5OO22023.services.IDispositivoService;
import com.unla.grupo5OO22023.services.ISensorLuzService;
import com.unla.grupo5OO22023.services.ISensorProximidadService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {

	@Autowired
	@Qualifier("sensorluzService")
	private ISensorLuzService sensorluzService;

	@Autowired
	@Qualifier("sensorProximidadService")
	private ISensorProximidadService sensorProximidadService;
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	@GetMapping("/listar")
	public String listarDispositivos(Model model) {
		// List<Dispositivo> dispositivos = dispositivoService.getAll();
		List<SensorLuz> sensoresLuz = sensorluzService.getAll();
		List<SensorProximidad> sensoresProximidad = sensorProximidadService.getAll();
		model.addAttribute("titulo", "Lista de dispositivos");
		model.addAttribute("tituloSLuz", "Sensores luz");
		model.addAttribute("tituloSensorProximidad", "Sensores Proximidad");
		model.addAttribute("sensoresLuz", sensoresLuz);
		model.addAttribute("sensoresProximidad", sensoresProximidad);
		return ViewRouteHelper.DISPOSITIVO_INDEX;
	}

	@PostMapping("/editar")
	public RedirectView create(@ModelAttribute("dispositivo") DispositivoModel dispositivoModel) {
		dispositivoService.insertOrUpdate(dispositivoModel);
		return new RedirectView(ViewRouteHelper.DISPOSITIVO_RUTA);
	}

	// ************************SENSORLUZ***********************************************************

	@GetMapping("/newsluz")
	public String agregar(Model model) {
		SensorLuz sensorluz = new SensorLuz();
		model.addAttribute("sensorluz", sensorluz);
		return ViewRouteHelper.FORM_SENSORLUZ;
	}

	@PostMapping("/savesluz")
	public String save(@Valid SensorLuz sensorluz, Model model) {
		sensorluzService.save(sensorluz);
		return "redirect:/dispositivo/listar";
	}

	
	// ************************SENSORPROXIMIDAD***********************************************************

	@GetMapping("/newsproxi")
	public String agregarProximidad(Model model) {
		SensorProximidad sensorProximidad = new SensorProximidad();
//    	model.addAttribute("sensorProximidad",sensorProximidad);
		model.addAttribute("sensorproximidad", sensorProximidad);
		return ViewRouteHelper.FORM_SENSORPROXIMIDAD;
	}

	@PostMapping("/savesproxi")
	public String saveProximidad(@Valid SensorProximidad sensorProximidad, Model model) {
		sensorProximidadService.save(sensorProximidad);
		return "redirect:/dispositivo/listar";
	}

}
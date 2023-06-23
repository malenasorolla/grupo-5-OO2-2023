package com.unla.grupo5OO22023.controllers;

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
import com.unla.grupo5OO22023.helpers.ViewRouteHelper;
import com.unla.grupo5OO22023.models.DispositivoModel;
import com.unla.grupo5OO22023.services.IDispositivoService;
import com.unla.grupo5OO22023.services.ISensorLuzService;

@Controller
@RequestMapping("/dispositivo")
public class DispositivoController {
	@Autowired
	@Qualifier("dispositivoService")
	private IDispositivoService dispositivoService;

	@Autowired
	@Qualifier("sensorluzService")
	private ISensorLuzService sensorluzService;

	
    @GetMapping("/listar")
    public String index(Model model){
       model.addAttribute("dispositivos", dispositivoService.getAll());
       return ViewRouteHelper.DispositivoIndex;
    }

    @PostMapping("/editar")
    public RedirectView create(@ModelAttribute("dispositivo") DispositivoModel dispositivoModel){
        dispositivoService.insertOrUpdate(dispositivoModel);
        return new RedirectView(ViewRouteHelper.DispositivoRuta);
    }
    
    // ************************SENSORLUZ***********************************************************
    
    @GetMapping("/newsluz")
    public String agregar(Model model) {
    	SensorLuz sensorluz = new SensorLuz();
    	model.addAttribute("sensorluz",sensorluz);
    	return ViewRouteHelper.FORM_SENSORLUZ;
    }
    
    @PostMapping("/savesluz")
    public String save(Dispositivo dispositivo, Model model) {
    	sensorluzService.save((SensorLuz)(dispositivo));
    	return "redirect:/listar";
    }
    
    
}
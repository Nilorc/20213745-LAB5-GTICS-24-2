package com.example.lab5_gtics.controllers;

import com.example.lab5_gtics.entity.*;
import com.example.lab5_gtics.repository.ViajeRepository;
import com.example.lab5_gtics.repository.PersonaRespository;
import com.example.lab5_gtics.repository.LugarRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/viajes")
public class ViajeController {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private PersonaRespository personaRepository;

    @Autowired
    private LugarRespository lugarRepository;

    // Muestra la lista de viajes
    @GetMapping
    public String listaViajes(Model model) {
        List<Viaje> viajes = viajeRepository.findAll();
        model.addAttribute("viajes", viajes);
        return "viajes/lista";
    }

    // Formulario para crear un nuevo viaje
    @GetMapping("/new")
    public String FormularioDecreaciondeViaje(Model model) {
        List<Persona> personas = personaRepository.findAll();
        List<Lugar> lugares = lugarRepository.findAll();
        model.addAttribute("viaje", new Viaje());
        model.addAttribute("personas", personas); //para seleccionar el titular
        model.addAttribute("lugares", lugares);   // Para seleccionar el destino
        return "viajes/form_nuevo";
    }

    // Guardar un nuevo viaje
    @PostMapping("/save")
    public String guardarViaje(@ModelAttribute Viaje viaje) {
        viajeRepository.save(viaje);
        return "redirect:/viajes";
    }

    // Muestra los detalles de un viaje
    @GetMapping("/detalles/{id}")
    public String mostrarDetallesDeViaje(@PathVariable("id") Integer id, Model model) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        model.addAttribute("viaje", viaje);
        return "viajes/detalles";
    }

    // Editar un viaje
    @GetMapping("/editar/{id}")
    public String Mostarformulariodedicion(@PathVariable("id") Integer id, Model model) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        List<Persona> personas = personaRepository.findAll();
        List<Lugar> lugares = lugarRepository.findAll();
        model.addAttribute("viaje", viaje);
        model.addAttribute("personas", personas);
        model.addAttribute("lugares", lugares);
        return "viajes/editar";
    }

    // Actualizar un viaje
    @PostMapping("/update/{id}")
    public String actualizarViaje(@PathVariable("id") Integer id, @ModelAttribute Viaje viaje) {
        viajeRepository.save(viaje);
        return "redirect:/viajes";
    }

    // Eliminar un viaje
    @GetMapping("/eliminar/{id}")
    public String eliminarViaje(@PathVariable("id") Integer id) {
        Viaje viaje = viajeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("ID inválido"));
        viajeRepository.delete(viaje);
        return "redirect:/viajes";
    }
}

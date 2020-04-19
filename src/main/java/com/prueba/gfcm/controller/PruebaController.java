package com.prueba.gfcm.controller;

import com.prueba.gfcm.exception.ResourceNotFoundException;
import com.prueba.gfcm.model.Prueba;
import com.prueba.gfcm.repository.PruebaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Esta clase contiene el Controlador principal y los respectivos metodos de 
 * implementaciòn de REST 
 * @author German Francisco Cuellar
 * @version 1.0
 * 
 */


@RestController
@RequestMapping("/microservicio")
public class PruebaController {
    
    
    /**
     * Metodo constructor parametrizado
     * Mapeo a ruta /personas
     * Ningun parametro relacionado
     * @return Regresa todas las personas creadas
     */
    
    @Autowired
    PruebaRepository pruebaRepository;
    
    @GetMapping("/personas")
    public List<Prueba> getAllPersona() {
        return pruebaRepository.findAll();
    }
    
      /**
     * Metodo constructor parametrizado
     * Mapeo a ruta /personas
     * Ningun parametro relacionado
     * @param persona objeto tipo persona
     * @return Regresa objeto creado
     */

    @PostMapping("/personas")
    public Prueba createPersona(@Valid @RequestBody Prueba persona) {
        return pruebaRepository.save(persona);
    }
    
    
      /**
     * Metodo constructor parametrizado
     * Mapeo a ruta /personas
     * Ningun parametro relacionado
     * @param personaId Recibe id e la persona
     * @return Regresa objeto consultado
     */
    
    @GetMapping("/personas/{id}")
    public Prueba getPersonaById(@PathVariable(value = "id") Long personaId) {
        return pruebaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));
    }
    
    /**
     * Metodo constructor parametrizado
     * Mapeo a ruta /personas/id
     * Ningun parametro relacionado
     * @param personaId Recibe id e la persona
     * @param personaDetalle Recibe informacion de la persona
     * @return Regresa objeto consultado
     */
    
    @PutMapping("/personas/{id}")
    public Prueba updatePersona(@PathVariable(value = "id") Long personaId,
                                           @Valid @RequestBody Prueba personaDetalle) {

        Prueba persona = pruebaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));

        persona.setNombre(personaDetalle.getNombre());
        persona.setApellidos(personaDetalle.getApellidos());
        persona.setCedula(personaDetalle.getCedula());
        persona.setDireccion(personaDetalle.getDireccion());
        persona.setTelefono(personaDetalle.getTelefono());
       
        Prueba updatedpersona = pruebaRepository.save(persona);
        return updatedpersona;
    }
    
      /**
     * Metodo constructor parametrizado
     * Mapeo a ruta /personas/id
     * Ningun parametro relacionado
     * @param personaId Recibe id e la persona
     * @return Objeto Borrado
     */
    
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable(value = "id") Long personaId) {
        Prueba persona = pruebaRepository.findById(personaId)
                .orElseThrow(() -> new ResourceNotFoundException("Persona", "id", personaId));

        pruebaRepository.delete(persona);

        return ResponseEntity.ok().build();
    }
}

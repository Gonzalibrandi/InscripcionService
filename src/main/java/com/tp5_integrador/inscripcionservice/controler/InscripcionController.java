package com.tp5_integrador.inscripcionservice.controler;

import com.tp5_integrador.inscripcionservice.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.tp5_integrador.inscripcionservice.entity.Inscripcion;


import java.util.List;

@RestController
@RequestMapping("/api/incripcion")
public class InscripciomController {
    private final InscripcionService inscripcionService;

    @Autowired
    public InscripcionController(InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping("/{dni}")
    public ResponseEntity<Inscripcion> obtenerEstudiantePorDNI(@PathVariable Long dni) {
        Inscripcion inscripcion = inscripcionService.findByDNI(dni);
        return ResponseEntity.ok(inscripcion);
    }

    @PostMapping
    public ResponseEntity<Inscripcion> crearEstudiante(@RequestBody Inscripcion inscripcion) {
        Inscripcion inscripcionAux = inscripcionService.guardarEstudiante(inscripcion);
        return new ResponseEntity<Inscripcion>(inscripcionAux, HttpStatus.CREATED);
    }
}

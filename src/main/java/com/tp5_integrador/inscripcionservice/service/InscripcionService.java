package com.tp5_integrador.inscripcionservice.service;

import com.tp5_integrador.inscripcionservice.entity.Inscripcion;
import com.tp5_integrador.inscripcionservice.repository.InscripcionRepository;

import java.util.List;

public class InscripcionService {

    // Instancia del repositorio de Inscripcion
    private final InscripcionRepository inscripcionRepository;

    // Constructor que inicializa el repositorio
    public InscripcionService() {
        this.inscripcionRepository = InscripcionRepository.getInstance();
    }

    // Método para guardar una nueva Inscripcion
    public Inscripcion guardarInscripcion(Inscripcion inscripcion) {
        try {
            return inscripcionRepository.persist(inscripcion);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la inscripción: " + e.getMessage());
        }
    }

    // Método para actualizar una Inscripcion existente
    public Inscripcion actualizarInscripcion(Inscripcion inscripcion) {
        try {
            return inscripcionRepository.merge(inscripcion);
        } catch (Exception e) {
            throw new RuntimeException("Error al actualizar la inscripción: " + e.getMessage());
        }
    }

    // Método para eliminar una Inscripcion
    public void eliminarInscripcion(Long id) {
        try {
            Inscripcion inscripcion = inscripcionRepository.findById(id);
            if (inscripcion != null) {
                inscripcionRepository.delete(inscripcion);
            } else {
                throw new RuntimeException("Inscripción no encontrada con ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la inscripción: " + e.getMessage());
        }
    }

    // Método para obtener una lista de todas las Inscripciones
    public List<Inscripcion> obtenerTodasLasInscripciones() {
        try {
            return inscripcionRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener las inscripciones: " + e.getMessage());
        }
    }

    // Método para encontrar una Inscripcion por ID
    public Inscripcion obtenerInscripcionPorId(Long id) {
        try {
            return inscripcionRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener la inscripción: " + e.getMessage());
        }
    }
}

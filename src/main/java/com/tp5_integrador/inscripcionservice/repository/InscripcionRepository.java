package com.tp5_integrador.inscripcionservice.repository;

import com.tp5_integrador.inscripcionservice.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // Método para encontrar todas las inscripciones ordenadas por fecha
    @Query("SELECT i FROM Inscripcion i ORDER BY i.fechaAlta")
    List<Inscripcion> findAllOrderByFecha();

    // Método para encontrar inscripciones por ID de estudiante
    @Query("SELECT i FROM Inscripcion i WHERE i.estudiante.id = :estudianteId")
    List<Inscripcion> findAllByEstudianteId(Long estudianteId);

    // Método para encontrar inscripciones por carrera
    @Query("SELECT i FROM Inscripcion i WHERE i.carrera = :carrera")
    List<Inscripcion> findAllByCarrera(String carrera);
}

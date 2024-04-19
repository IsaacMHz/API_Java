package com.curso.spring.repository;

import com.curso.spring.model.Personas;
import com.curso.spring.response.DatosPersonaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepository extends JpaRepository<Personas,Long> {

    @Query(value = "SELECT p.nombre FROM Personas p WHERE p.genero = :genero")
    List<String> personasByGenero(@Param("genero") String genero);

    @Query(value = "SELECT p.nombre AS nombre, e.titulo AS titulo, e.salario AS salario "
            + "FROM personas "
            + "JOIN empleos e ON p.empleo_id = e.empleo_id "
            + "WHERE p.persona_id = :idPersona ", nativeQuery = true)
    DatosPersonaResponse getInfoPersonas(@Param("idPersona") Integer idPersona);

}

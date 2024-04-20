package com.curso.spring.repository;

import com.curso.spring.dto.request.PersonaRequest;
import com.curso.spring.model.Personas;
import com.curso.spring.response.DatosPersonaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonasRepository extends JpaRepository<Personas,Long> {

    @Query(value = "SELECT p.nombre FROM Personas p WHERE p.genero = :genero")
    List<String> personasByGenero(@Param("genero") String genero);

    @Query(value = "SELECT p.nombre AS nombre, e.titulo AS titulo, e.salario AS salario "
            + "FROM personas AS p "
            + "JOIN empleos e ON p.empleo_id = e.empleo_id "
            + "WHERE p.persona_id = :idPersona ", nativeQuery = true)
    DatosPersonaResponse getInfoPersonas(@Param("idPersona") Integer idPersona);

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO personas (nombre, edad, genero, direccion_id, empleo_id) "
            + "VALUES (:#{#request.nombre}, :#{#request.edad}, :#{#request.genero}, :#{#request.idDireccion}, :#{#request.idEmpleo} )", nativeQuery = true)
    Integer savePersonaNativa(@Param("request") PersonaRequest request);

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE personas SET nombre = :#{#request.nombre} WHERE persona_id = :#{#request.idPersona} ",nativeQuery = true)
    Integer actualizarPersonaNative(@Param("request") PersonaRequest request) throws Exception;

    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM personas WHERE persona_id = :id",nativeQuery = true)
    void deletePersonaNative(@Param("id") Long id);

}

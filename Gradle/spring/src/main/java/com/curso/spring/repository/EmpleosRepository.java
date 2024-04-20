package com.curso.spring.repository;

import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Empleos;
import com.curso.spring.response.DatosEmpleosResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleosRepository extends JpaRepository<Empleos,Long> {

    //Consultas realizadas mediante JPQL

    //Consulta realizada para obtener toda la información de un empleo mediante JPQL, se usó la clase Empleos
    @Query(value = "SELECT e.empleo_id AS empleo_id, e.titulo AS titulo, e.empresa AS empresa, e.salario AS salario FROM Empleos e WHERE e.empleo_id = :id")
    DatosEmpleosResponse obtenerEmpleoJPQL(@Param("id") Long id);

    //Consulta realizada para actualizar la información de un empleo mediante JPQL, se usó la clase Empleos
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Empleos e "
            + "SET e.titulo = :#{#request.titulo}, e.empresa = :#{#request.empresa}, e.salario = :#{#request.salario} "
            + "WHERE e.empleo_id = :#{#request.empleo_id}",nativeQuery = false)
    Integer actualizarEmpleoJPQL(@Param("request") EmpleoRequest request);

    //Consulta realizada para eliminar un empleo de la base de datos mediante JPQL, se usó la clase Empleos
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM Empleos WHERE empleo_id = :id")
    void eliminarEmpleoJPQL(@Param("id") Long id);


    //Consultas realizadas mediante NativeQuery

    //Consulta realizada para obtener toda la información de un empleo mediante NativeQuery, se usó la entidad empleos
    @Query(value = "SELECT empleo_id ,titulo, empresa, salario FROM empleos WHERE empleo_id = :id", nativeQuery = true)
    DatosEmpleosResponse obtenerEmpleoQueryNative(@Param("id") Integer id);

    //Consulta realizada para insertar un nuevo empleo en la base de datos mediante NativeQuery, se usó la entidad empleos
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO empleos (titulo, empresa, salario) "
            + "VALUES (:#{#request.titulo}, :#{#request.empresa}, :#{#request.salario})",nativeQuery = true)
    Integer insertarEmpleoQueryNative(@Param("request") EmpleoRequest request);

    //Consulta realizada para actualizar la información de un empleo mediante NativeQuery, se usó la entidad empleos
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE empleos "
            + "SET titulo = :#{#request.titulo}, empresa = :#{#request.empresa}, salario = :#{#request.salario} "
            + "WHERE empleo_id = :#{#request.empleo_id}",nativeQuery = true)
    Integer actualizarEmpleoQueryNative(@Param("request") EmpleoRequest request);

    //Consulta realizada para eliminar un empleo de la base de datos mediante NativeQuery, se usó la entidad empleos
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM empleos WHERE empleo_id = :id",nativeQuery = true)
    void eliminarEmpleoQueryNative(@Param("id") Long id);

}

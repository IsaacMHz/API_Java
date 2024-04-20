package com.curso.spring.repository;

import com.curso.spring.dto.request.DireccionRequest;
import com.curso.spring.dto.request.EmpleoRequest;
import com.curso.spring.model.Direcciones;
import com.curso.spring.response.DatosDireccionesResponse;
import com.curso.spring.response.DatosEmpleosResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionesRepository extends JpaRepository<Direcciones,Long> {

    //Consultas realizadas mediante JPQL

    //Consulta realizada para obtener toda la información de una dirección mediante JPQL, se usó la clase Direcciones
    @Query(value = "SELECT d.direccion_id AS direccion_id, d.calle AS calle, d.ciudad AS ciudad, d.estado AS estado, d.codigo_postal AS codigo_postal "
            + "FROM Direcciones d WHERE d.direccion_id = :id")
    DatosDireccionesResponse obtenerDireccionJPQL(@Param("id") Long id);

    //Consulta realizada para actualizar la información de una dirección mediante JPQL, se usó la clase Direcciones
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE Direcciones d "
            + "SET d.calle = :#{#request.calle}, d.ciudad = :#{#request.ciudad}, d.estado = :#{#request.estado}, d.codigo_postal = :#{#request.codigo_postal} "
            + "WHERE d.direccion_id = :#{#request.direccion_id}",nativeQuery = false)
    Integer actualizarDireccionJPQL(@Param("request") DireccionRequest request);

    //Consulta realizada para eliminar una dirección de la base de datos mediante JPQL, se usó la clase Direcciones
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM Direcciones WHERE direccion_id = :id")
    void eliminarDireccionJPQL(@Param("id") Long id);


    //Consultas realizadas mediante NativeQuery

    //Consulta realizada para obtener toda la información de una dirección mediante NativeQuery, se usó la entidad direcciones
    @Query(value = "SELECT direccion_id, calle, ciudad, estado, codigo_postal "
            + "FROM direcciones WHERE direccion_id = :id", nativeQuery = true)
    DatosDireccionesResponse obtenerDireccionQueryNative(@Param("id") Integer id);

    //Consulta realizada para insertar una nueva dirección en la base de datos mediante NativeQuery, se usó la entidad direcciones
    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO direcciones (calle, ciudad, estado, codigo_postal) "
            + "VALUES (:#{#request.calle}, :#{#request.ciudad}, :#{#request.estado}, :#{#request.codigo_postal})",nativeQuery = true)
    Integer insertarDireccionQueryNative(@Param("request") DireccionRequest request);

    //Consulta realizada para actualizar la información de una dirección mediante NativeQuery, se usó la entidad direcciones
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE direcciones "
            + "SET calle = :#{#request.calle}, ciudad = :#{#request.ciudad}, estado = :#{#request.estado}, codigo_postal = :#{#request.codigo_postal} "
            + "WHERE direccion_id = :#{#request.direccion_id}",nativeQuery = true)
    Integer actualizarDireccionQueryNative(@Param("request") DireccionRequest request);

    //Consulta realizada para eliminar una dirección de la base de datos mediante NativeQuery, se usó la entidad direcciones
    @Modifying(clearAutomatically = true)
    @Query(value = "DELETE FROM direcciones WHERE direccion_id = :id",nativeQuery = true)
    void eliminarDireccionQueryNative(@Param("id") Long id);

}

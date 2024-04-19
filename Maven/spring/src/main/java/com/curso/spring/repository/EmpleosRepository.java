package com.curso.spring.repository;

import com.curso.spring.model.Empleos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmpleosRepository extends JpaRepository<Empleos,Long> {
}

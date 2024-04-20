package com.curso.spring.service;

import com.curso.spring.response.Post;

import java.util.List;
public interface IEjerciciosService {
    List<String> getNombres();

    Post getPost(Integer id);
}

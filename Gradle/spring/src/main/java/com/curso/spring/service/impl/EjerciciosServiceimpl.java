package com.curso.spring.service.impl;

import com.curso.spring.response.Post;
import com.curso.spring.service.IEjerciciosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EjerciciosServiceimpl implements IEjerciciosService {

    @Override
    public List<String> getNombres() {
        log.info("Entro al metodo getNombre");

        List<String> listaNombre = new ArrayList<>();
        List<String> listaresponse = new ArrayList<>();

        listaNombre.add("Isaac");
        listaNombre.add("Carlos");
        listaNombre.add("Juan");
        listaNombre.add("Omar");

        /*for (String nombre: listaNombre){
            if (nombre.contains("o") || nombre.contains("O")){
                log.info("El nombre es: " + nombre);
                listaresponse.add(nombre);
            }
        }*/

        /*int index = 0;
        while(index < listaNombre.size()) {
            String nombre = listaNombre.get(index);
            if (nombre.toLowerCase().contains("o")){
                listaresponse.add(nombre);
            }
            index++;
        }*/

        /*int index = 0;
        do{
            String nombre = listaNombre.get(index);
            if(nombre.toLowerCase().contains("i")){
                listaresponse.add(nombre);
            }
            index++;
        }while(index < listaNombre.size());*/


        listaresponse = listaNombre.stream()
                .filter(nombre -> nombre.toLowerCase().contains("i"))
                .collect(Collectors.toList());
        return listaresponse;
    }

    @Override
    public Post getPost(Integer id) {

        ResponseEntity<Post> resultPost = null;

        try {
            String url = "https://jsonplaceholder.typicode.com/todos/" + id ;
            RestTemplate restTemplate = new RestTemplate();

             resultPost = restTemplate.exchange(url, HttpMethod.GET,null,Post.class);

             Post response = restTemplate.getForObject(url, Post.class);
             resultPost = ResponseEntity.ok(response);

        }catch (Exception e){
            log.info("Error");
        }
        return resultPost.getBody() ;
    }
}

package com.curso.spring.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString

public class Post {

    private int userId;
    private int id;
    private String title;
    private boolean completed;
}

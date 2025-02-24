package com.example.demo.sportsapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerDTO {
    // Геттеры и сеттеры
    private Long id;
    private String name;
    private int age;
    private Long teamId; // ID команды, к которой принадлежит игрок

}

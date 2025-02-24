package com.example.demo.sportsapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MatchDTO {
    // Геттеры и сеттеры
    private Long id;
    private Long homeTeamId;  // ID домашней команды
    private Long awayTeamId;  // ID гостевой команды
    private String date;  // Дата матча

}
package com.example.demo.sportsapp.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoachDTO {
    private Long id;
    private String name;
    private Long teamId; // ID команды, которой он тренирует

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getTeamId() { return teamId; }
    public void setTeamId(Long teamId) { this.teamId = teamId; }
}

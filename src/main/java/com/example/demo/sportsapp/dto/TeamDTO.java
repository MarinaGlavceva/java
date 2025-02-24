package com.example.demo.sportsapp.dto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeamDTO {
    private Long id;
    private String name;
    private Long leagueId;

    // Геттеры и сеттеры
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getLeagueId() { return leagueId; }
    public void setLeagueId(Long leagueId) { this.leagueId = leagueId; }
}

package com.example.demo.sportsapp.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamDTO {
    private Long id;
    private String name;
    private Long leagueId;
}


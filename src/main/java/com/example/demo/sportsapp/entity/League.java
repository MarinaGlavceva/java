package com.example.demo.sportsapp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "leagues")
public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Team> teams;

    @OneToMany(mappedBy = "league", cascade = CascadeType.ALL)
    private List<Match> matches;

    // Геттеры и сеттеры
}
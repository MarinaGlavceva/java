package com.example.demo.sportsapp.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "team_id")
    private Team team;

    // Геттеры и сеттеры
}
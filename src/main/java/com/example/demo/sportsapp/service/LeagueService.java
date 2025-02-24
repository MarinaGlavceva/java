package com.example.demo.sportsapp.service;

import com.example.demo.sportsapp.entity.dto.LeagueDTO;
import com.example.demo.sportsapp.entity.League;
import com.example.demo.sportsapp.repository.LeagueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public List<LeagueDTO> getAllLeagues() {
        return leagueRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public LeagueDTO getLeagueById(Long id) {
        return leagueRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("League not found"));
    }

    public LeagueDTO createLeague(LeagueDTO leagueDTO) {
        League league = new League();
        league.setName(leagueDTO.getName());
        leagueRepository.save(league);
        return convertToDTO(league);
    }

    public LeagueDTO updateLeague(Long id, LeagueDTO leagueDTO) {
        League league = leagueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("League not found"));
        league.setName(leagueDTO.getName());
        leagueRepository.save(league);
        return convertToDTO(league);
    }

    public void deleteLeague(Long id) {
        leagueRepository.deleteById(id);
    }

    private LeagueDTO convertToDTO(League league) {
        LeagueDTO dto = new LeagueDTO();
        dto.setId(league.getId());
        dto.setName(league.getName());
        return dto;
    }
}
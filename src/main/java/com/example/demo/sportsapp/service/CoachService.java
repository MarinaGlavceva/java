package com.example.demo.sportsapp.service;

import com.example.demo.sportsapp.dto.CoachDTO;
import com.example.demo.sportsapp.entity.Coach;
import com.example.demo.sportsapp.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoachService {

    private final CoachRepository coachRepository;

    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<CoachDTO> getAllCoaches() {
        return coachRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public CoachDTO getCoachById(Long id) {
        return coachRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Coach not found"));
    }

    public CoachDTO createCoach(CoachDTO coachDTO) {
        Coach coach = new Coach();
        coach.setName(coachDTO.getName());
        coachRepository.save(coach);
        return convertToDTO(coach);
    }

    public CoachDTO updateCoach(Long id, CoachDTO coachDTO) {
        Coach coach = coachRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coach not found"));
        coach.setName(coachDTO.getName());
        coachRepository.save(coach);
        return convertToDTO(coach);
    }

    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }

    private CoachDTO convertToDTO(Coach coach) {
        CoachDTO dto = new CoachDTO();
        dto.setId(coach.getId());
        dto.setName(coach.getName());
        return dto;
    }
}
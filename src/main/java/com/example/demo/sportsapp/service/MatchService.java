package com.example.demo.sportsapp.service;

import com.example.demo.sportsapp.entity.dto.MatchDTO;
import com.example.demo.sportsapp.entity.Match;
import com.example.demo.sportsapp.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public List<MatchDTO> getAllMatches() {
        return matchRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public MatchDTO getMatchById(Long id) {
        return matchRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public MatchDTO createMatch(MatchDTO matchDTO) {
        Match match = new Match();
        matchRepository.save(match);
        return convertToDTO(match);
    }

    public MatchDTO updateMatch(Long id, MatchDTO matchDTO) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));
        matchRepository.save(match);
        return convertToDTO(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }

    private MatchDTO convertToDTO(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        return dto;
    }
}

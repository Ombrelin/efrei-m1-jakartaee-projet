package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Match;

import javax.ejb.Local;
import java.time.LocalDateTime;
import java.util.List;

@Local
public interface MatchService {
    void planMatch(LocalDateTime dateTime, String court);

    List<Match> getMatches();

    List<Match> getFinishedMatches();
}

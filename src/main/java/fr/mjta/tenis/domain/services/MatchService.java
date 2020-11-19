package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Match;

import javax.ejb.Local;
import java.time.LocalDateTime;

@Local
public interface MatchService {
    void planMatch(LocalDateTime dateTime, String court);
}

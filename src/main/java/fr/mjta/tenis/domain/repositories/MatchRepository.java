package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
public interface MatchRepository {
    Match insertMatch(Match match);
}

package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MatchRepository {
    Match insertMatch(Match match);

    List<Match> getMatches();

    List<Match> getFinishedMatches();

    Match getMatchToResolve(String id);

    Boolean resolveMatch(String id, int team1score, int team2score);
}

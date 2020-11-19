package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Local;
import java.time.Duration;
import java.util.List;
import java.util.Set;

@Local
public interface MatchRepository {
    Match insertMatch(Match match);

    List<Match> getMatches();

    List<Match> getFinishedMatches();

    Match getMatchToResolve(String id);

    Match getMatchToPrepare(String id);

    Match getById(String id);
}

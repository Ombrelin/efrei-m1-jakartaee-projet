package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Court;
import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Local;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Local
public interface MatchService {
    void planMatch(LocalDateTime dateTime, Court court);

    List<Match> getMatches();

    List<Match> getFinishedMatches();

    Match getMatchToResolve(String id);

    Boolean resolveMatch(String id, int team1score, int team2score, Duration duration);

    Match getMatchToPrepare(String id);

    void prepareMatch(String id, Set<Player> team1, Set<Player> team2, Referee referee);
}

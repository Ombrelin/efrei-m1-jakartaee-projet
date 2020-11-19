package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;
import fr.mjta.tenis.domain.repositories.MatchRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Stateless
public class MatchServiceImpl implements MatchService {

    @EJB
    private MatchRepository matchRepository;


    @Override
    public void planMatch(LocalDateTime dateTime, String court) {
        var match = new Match();
        match.setDateTime(dateTime);
        match.setCourt(court);

        matchRepository.insertMatch(match);
    }

    @Override
    public List<Match> getMatches() {
        return matchRepository.getMatches();
    }

    @Override
    public List<Match> getFinishedMatches() {
        return matchRepository.getFinishedMatches();
    }

    @Override
    public Match getMatchToResolve(String id) {
        return matchRepository.getMatchToResolve(id);
    }

    @Override
    public Boolean resolveMatch(String id, int team1score, int team2score, Duration duration) {
        return matchRepository.resolveMatch(id, team1score, team2score, duration);
    }

    @Override
    public Match getMatchToPrepare(String id) {
        return matchRepository.getMatchToPrepare(id);
    }

    @Override
    public void prepareMatch(String id, Set<Player> team1, Set<Player> team2, Referee referee) {
        var match = matchRepository.getById(id);
        team1.forEach(team -> team.getMatches().add(match));
        team2.forEach(team -> team.getMatches().add(match));
        match.getTeam1().addAll(team1);
        match.getTeam2().addAll(team2);
        match.setReferee(referee);
        match.setPrepared(true);
    }
}

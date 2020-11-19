package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.repositories.MatchRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.List;

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
    public Boolean resolveMatch(String id, int team1score, int team2score) {
        return matchRepository.resolveMatch(id, team1score, team2score);
    }
}

package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Participation;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;
import fr.mjta.tenis.domain.repositories.MatchRepository;
import fr.mjta.tenis.domain.repositories.ParticipationRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
public class MatchServiceImpl implements MatchService {

    @EJB
    private MatchRepository matchRepository;

    @EJB
    private ParticipationRepository participationRepository;

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
        var match = matchRepository.getById(id);
        match.setTeam1Score(team1score);
        match.setTeam2Score(team2score);
        match.setDuration(duration);
        match.setFinished(true);

        return true;
    }

    @Override
    public Match getMatchToPrepare(String id) {
        return matchRepository.getMatchToPrepare(id);
    }

    @Override
    public void prepareMatch(String id, Set<Player> team1, Set<Player> team2, Referee referee) {
        if(team2.size() > 2 || team2.size() == 0 || team1.size() > 2 || team1.size() == 0){
            throw new IllegalArgumentException("One or both of the teams have to many or no player");
        }
        if(team1.size() != team2.size()){
            throw new IllegalArgumentException("Both teams do not have the same number of players");
        }
        if((team1.size() == 2 && team1.toArray(new Player[]{})[0].getId().equals(team1.toArray(new Player[]{})[1].getId()))
            ||(team2.size() == 2 && team2.toArray(new Player[]{})[0].getId().equals(team2.toArray(new Player[]{})[1].getId()))){
            throw new IllegalArgumentException("One or both of the teams has twice the same player");
        }
        team1.forEach(player1 -> {
            team2.forEach(player2 ->{
                if(player1.getId().equals(player2.getId())){
                    throw new IllegalArgumentException("A player cannot be in two different teams");
                }
            });
        });
        var match = matchRepository.getById(id);

        match.setReferee(referee);
        match.setPrepared(true);

        var participations = new ArrayList<Participation>();

        participations.addAll(
                team1.stream()
                     .map(player -> new Participation(match, player, 1))
                     .collect(Collectors.toList())
        );

        participations.addAll(team2.stream().map(player -> new Participation(match, player, 2)).collect(Collectors.toList()));

        for(Participation p:participations){
            participationRepository.insert(p);
        }
        match.getParticipants().addAll(participations);
    }
}

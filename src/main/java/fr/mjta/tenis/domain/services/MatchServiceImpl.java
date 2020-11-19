package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.repositories.MatchRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;

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
}

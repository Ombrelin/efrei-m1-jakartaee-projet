package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Organizer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class MatchRepositoryImpl implements MatchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Match insertMatch(Match match) {
        this.entityManager.persist(match);
        return match;
    }

    @Override
    public List<Match> getMatches() {
        return entityManager.createQuery("SELECT m FROM Match m", Match.class).getResultList();
    }

    @Override
    public List<Match> getFinishedMatches() {
        return entityManager.createQuery("SELECT m FROM Match m", Match.class).getResultList();
    }
}

package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class MatchRepositoryImpl implements MatchRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Match insertMatch(Match match) {
        this.entityManager.persist(match);
        return match;
    }
}

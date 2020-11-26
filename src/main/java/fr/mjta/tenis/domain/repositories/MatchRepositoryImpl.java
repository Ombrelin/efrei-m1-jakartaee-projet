package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

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
        return entityManager.createQuery("SELECT m FROM Match m where m.finished = true", Match.class).getResultList();
    }

    @Override
    public Match getMatchToResolve(String id) {
        TypedQuery<Match> query = entityManager.createQuery("SELECT m FROM Match m WHERE m.id = :id AND m.finished = false AND m.prepared = true", Match.class);
        try{
            return query.setParameter("id", id).getSingleResult();
        }catch(Exception e){
            throw new IllegalArgumentException("No such Match to resolve");
        }
    }
    @Override
    public Match getMatchToPrepare(String id) {
        TypedQuery<Match> query = entityManager.createQuery("SELECT m FROM Match m WHERE m.id = :id AND m.finished = false AND m.prepared = false", Match.class);
        try{
            return query.setParameter("id", id).getSingleResult();
        }catch(Exception e){
            throw new IllegalArgumentException("No such Match to prepare");
        }
    }

    @Override
    public Match getById(String id){
        return this.entityManager.find(Match.class, id);
    }
}

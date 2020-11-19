package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Boolean resolveMatch(String id, int team1score, int team2score, Duration duration) {
        TypedQuery<Match> query = entityManager.createQuery("UPDATE Match m SET m.finished = true, m.team1Score = :team1score, m.team2Score = :team2score, m.duration = :duration WHERE m.id = :id", Match.class);
        query.setParameter("id", id);
        query.setParameter("team1score", team1score);
        query.setParameter("team2score", team2score);
        query.setParameter("duration", duration);
        int rowUpdated = query.executeUpdate();
        if(rowUpdated == 1){
            return true;
        }
        return false;
    }

    @Override
    public Match getMatchToPrepare(String id) {
        TypedQuery<Match> query = entityManager.createQuery("SELECT m FROM Match m WHERE m.id = :id AND m.finished = false AND m.prepared = false", Match.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Match getById(String id){
        return this.entityManager.find(Match.class, id);
    }
}

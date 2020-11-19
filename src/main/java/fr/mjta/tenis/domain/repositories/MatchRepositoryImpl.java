package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Match;

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
        return entityManager.createQuery("SELECT m FROM Match m where m.finished = true", Match.class).getResultList();
    }

    @Override
    public Match getMatchToResolve(String id) {
        TypedQuery<Match> query = entityManager.createQuery("SELECT m FROM Match m WHERE m.id = :id AND m.finished = false", Match.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Override
    public Boolean resolveMatch(String id, int team1score, int team2score) {
        TypedQuery<Match> query = entityManager.createQuery("UPDATE Match m SET m.finished = true, m.team1Score = :team1score, m.team2Score = :team2score WHERE m.id = :id", Match.class);
        query.setParameter("id", id);
        query.setParameter("team1score", team1score);
        query.setParameter("team2score", team2score);
        int rowUpdated = query.executeUpdate();
        if(rowUpdated == 1){
            return true;
        }
        return false;
    }
}

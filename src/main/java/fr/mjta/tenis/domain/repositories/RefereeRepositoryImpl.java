package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RefereeRepositoryImpl implements RefereeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Referee getById(String id) {
        return entityManager.find(Referee.class, id);
    }

    @Override
    public Referee getByName(String name) {
        TypedQuery<Referee> query = entityManager.createQuery("SELECT r FROM Referee r WHERE r.name = :name", Referee.class);
        return query.setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Referee> getByNationality(String nationality) {
        TypedQuery<Referee> query = entityManager.createQuery("SELECT r FROM Referee r WHERE r.nationality = :nationality", Referee.class);
        return query.setParameter("nationality", nationality).getResultList();
    }

    @Override
    public void registerReferee(String name, String nationality) {
        Referee referee = new Referee(name, nationality);
        entityManager.persist(referee);
    }
}

package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Participation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ParticipationRepositoryImpl implements ParticipationRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Participation p) {
        entityManager.persist(p);
    }
}

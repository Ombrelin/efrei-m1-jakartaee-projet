package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Organizer;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Stateless
public class OrganizerRepositoryImpl implements OrganizerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Organizer getById(String id) {
        return entityManager.find(Organizer.class, id);
    }

    @Override
    public Organizer getByLogin(String login) {
        TypedQuery<Organizer> query = entityManager.createQuery("SELECT o FROM Organizer o WHERE o.login = :login", Organizer.class);
        return query.setParameter("login", login).getSingleResult();
    }
}

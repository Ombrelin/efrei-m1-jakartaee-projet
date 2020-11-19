package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Organizer;
import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PlayerRepositoryImpl implements PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Player register(Player p) {
        entityManager.persist(p);
        return p;
    }

    @Override
    public Player getById(String id) {
        return entityManager.find(Player.class, id);
    }

    @Override
    public List<Player> getAll() {
        var query = entityManager.createQuery("SELECT p FROM Player p",Player.class);
        return query.getResultList();
    }
}

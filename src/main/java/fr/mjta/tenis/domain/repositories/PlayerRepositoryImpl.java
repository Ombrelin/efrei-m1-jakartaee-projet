package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Gender;
import fr.mjta.tenis.domain.entities.Organizer;
import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PlayerRepositoryImpl implements PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Player register(String name, String gender, String nationality) {
        Player player = new Player(name, Gender.valueOf(gender), nationality);
        entityManager.persist(player);
        return player;
    }
}

package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Gender;
import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlayerRepositoryImpl implements PlayerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean register(String name, String gender, String nationality) {
        Player player = new Player(name, Gender.valueOf(gender), nationality);
        entityManager.persist(player);
        return entityManager.contains(player);
    }
}

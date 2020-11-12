package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Gender;
import fr.mjta.tenis.domain.entities.Organizer;
import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Local;

@Local
public interface PlayerRepository {
    Player register(String name, String gender, String nationality);
}

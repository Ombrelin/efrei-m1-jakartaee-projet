package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Local;

@Local
public interface PlayerRepository {
    Player register(Player player);
}

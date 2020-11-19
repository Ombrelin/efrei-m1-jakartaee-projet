package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PlayerRepository {
    Player register(Player player);

    Player getById(String id);

    List<Player> getAll();
}

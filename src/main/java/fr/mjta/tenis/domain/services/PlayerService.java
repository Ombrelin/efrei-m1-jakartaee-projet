package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Local;
import java.util.List;

@Local
public interface PlayerService {

    void register(String name, String gender, String nationality, int worldRank);

    Player getById(String id);

    List<Player> getAll();
}

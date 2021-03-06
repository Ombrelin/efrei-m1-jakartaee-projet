package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Gender;
import fr.mjta.tenis.domain.entities.Organizer;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.repositories.PlayerRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PlayerServiceImpl implements PlayerService {
    @EJB
    private PlayerRepository playerRepository;

    @Override
    public void register(String name, String gender, String nationality, int worldRank) {
        var player = new Player();
        player.setName(name);
        player.setNationality(nationality);
        player.setGender(Gender.valueOf(gender));
        player.setWorldRank(worldRank);
        playerRepository.register(player);
    }

    @Override
    public Player getById(String id) {
        return playerRepository.getById(id);
    }

    @Override
    public List<Player> getAll() {
        return playerRepository.getAll();
    }
}

package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Gender;
import fr.mjta.tenis.domain.entities.Organizer;
import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.repositories.OrganizerRepository;
import fr.mjta.tenis.domain.repositories.PlayerRepository;
import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PlayerServiceImpl implements PlayerService {
    @EJB
    private PlayerRepository playerRepository;

    @Override
    public boolean register(String name, String gender, String nationality) {
        playerRepository.registerPlayer(name, gender, nationality);
        return true;
    }
}

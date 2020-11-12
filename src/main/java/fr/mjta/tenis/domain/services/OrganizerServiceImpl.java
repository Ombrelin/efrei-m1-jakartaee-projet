package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Organizer;
import fr.mjta.tenis.domain.repositories.OrganizerRepository;
import org.mindrot.jbcrypt.BCrypt;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrganizerServiceImpl implements OrganizerService {
    @EJB
    private OrganizerRepository organizerRepository;

    @Override
    public boolean login(String login, String password) {
        Organizer organizer = organizerRepository.getByLogin(login);
        return BCrypt.checkpw(password,organizer.getPassword());
    }
}

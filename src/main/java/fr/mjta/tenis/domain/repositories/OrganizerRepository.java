package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Organizer;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface OrganizerRepository {
    Organizer getById(String id);

    Optional<Organizer> getByLogin(String login);
}

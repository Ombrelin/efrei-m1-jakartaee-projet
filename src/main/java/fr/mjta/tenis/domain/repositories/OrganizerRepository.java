package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Organizer;

import javax.ejb.Local;

@Local
public interface OrganizerRepository {
    Organizer getById(String id);

    Organizer getByLogin(String login);
}

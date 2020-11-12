package fr.mjta.tenis.domain.services;

import javax.ejb.Local;

@Local
public interface OrganizerService {

    boolean login(String login, String password);

}

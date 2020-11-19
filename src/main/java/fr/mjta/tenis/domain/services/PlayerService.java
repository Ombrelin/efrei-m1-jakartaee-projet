package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Local;

@Local
public interface PlayerService {

    void register(String name, String gender, String nationality);

    Player getById(String id);

}

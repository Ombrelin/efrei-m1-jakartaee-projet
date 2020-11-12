package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Gender;
import fr.mjta.tenis.domain.entities.Player;

import javax.ejb.Local;

@Local
public interface PlayerService {

    boolean register(String name, String gender, String nationality);

}

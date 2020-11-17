package fr.mjta.tenis.domain.repositories;

import javax.ejb.Local;

@Local
public interface PlayerRepository {
    boolean register(String name, String gender, String nationality);
}

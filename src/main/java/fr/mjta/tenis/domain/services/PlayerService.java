package fr.mjta.tenis.domain.services;

import javax.ejb.Local;

@Local
public interface PlayerService {

    void register(String name, String gender, String nationality);

}

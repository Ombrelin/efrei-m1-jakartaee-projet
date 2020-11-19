package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RefereeService {
    boolean registerReferee(String name, String nationality);

    Referee getById(String id);
    List<Referee> getAll();
}

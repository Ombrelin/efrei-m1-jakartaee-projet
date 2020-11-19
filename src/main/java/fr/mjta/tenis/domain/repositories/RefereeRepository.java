package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Referee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface RefereeRepository {
    Referee getById(String id);

    Referee getByName(String name);

    List<Referee> getByNationality(String nationality);

    void registerReferee(String name, String Nationality);
}

package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Referee;
import fr.mjta.tenis.domain.repositories.RefereeRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RefereeServiceImpl implements RefereeService {

    @EJB
    private RefereeRepository refereeRepository;

    @Override
    public boolean registerReferee(String name, String nationality) {
        refereeRepository.registerReferee(name, nationality);
        return refereeRepository.getByName(name) != null;
    }

    @Override
    public Referee getById(String id) {
        return refereeRepository.getById(id);
    }

    @Override
    public List<Referee> getAll() {
        return refereeRepository.getAll();
    }
}

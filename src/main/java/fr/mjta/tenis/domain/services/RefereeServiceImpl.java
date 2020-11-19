package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Referee;
import fr.mjta.tenis.domain.repositories.OrganizerRepository;
import fr.mjta.tenis.domain.repositories.RefereeRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RefereeServiceImpl implements RefereeService{

    @EJB
    private RefereeRepository refereeRepository;

    @Override
    public boolean registerReferee(String name, String nationality) {
        refereeRepository.registerReferee(name, nationality);
        return refereeRepository.getByName(name) != null;
    }
}

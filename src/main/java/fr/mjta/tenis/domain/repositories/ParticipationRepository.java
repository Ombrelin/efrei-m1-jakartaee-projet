package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Participation;

import javax.ejb.Local;

@Local
public interface ParticipationRepository {

    void insert(Participation p);

}

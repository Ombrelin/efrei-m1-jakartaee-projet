package fr.mjta.tenis.domain.services;

import javax.ejb.Local;

@Local
public interface RefereeService {
    boolean registerReferee(String name, String nationality);
}

package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Court;
import fr.mjta.tenis.domain.repositories.CourtRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CourtServiceImpl implements CourtService {

	@EJB
	private CourtRepository courtRepository;

	@Override
	public Court create(String number) {
		var court = new Court();
		court.setNumber(number);
		courtRepository.insert(court);
		return court;
	}
}
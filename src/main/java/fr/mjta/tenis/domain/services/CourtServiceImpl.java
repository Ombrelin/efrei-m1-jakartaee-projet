package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Court;
import fr.mjta.tenis.domain.repositories.CourtRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.List;

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

	@Override
	public List<Court> getAll() {
		return courtRepository.getAll();
	}

	@Override
	public boolean isAvailable(Court court, LocalDateTime matchDate) {
		return courtRepository.isAvailable(court, matchDate);
	}

	@Override
	public Court get(String id) {
		return courtRepository.getById(id);
	}
}

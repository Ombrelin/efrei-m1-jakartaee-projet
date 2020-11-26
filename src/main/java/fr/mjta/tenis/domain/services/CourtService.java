package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Court;

import java.util.List;

public interface CourtService {
	Court create(String number);

	List<Court> getAll();

	Court get(String id);
}

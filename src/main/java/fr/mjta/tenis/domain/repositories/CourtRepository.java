package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Court;

import java.util.List;

public interface CourtRepository {
	Court insert(Court court);

	List<Court> getAll();

	Court getById(String id);
}

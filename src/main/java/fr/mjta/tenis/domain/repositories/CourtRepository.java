package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Court;

import java.time.LocalDateTime;
import java.util.List;

public interface CourtRepository {
	Court insert(Court court);

	List<Court> getAll();

	boolean isAvailable(Court court, LocalDateTime matchDate);

	Court getById(String id);
}

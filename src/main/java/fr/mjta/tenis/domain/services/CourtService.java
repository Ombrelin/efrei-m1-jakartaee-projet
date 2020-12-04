package fr.mjta.tenis.domain.services;

import fr.mjta.tenis.domain.entities.Court;

import java.time.LocalDateTime;
import java.util.List;

public interface CourtService {
	Court create(String number);

	List<Court> getAll();

	boolean isAvailable(Court court, LocalDateTime matchDate);

	Court get(String id);
}

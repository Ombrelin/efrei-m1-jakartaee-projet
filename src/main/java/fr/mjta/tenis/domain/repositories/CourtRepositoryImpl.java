package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Court;
import fr.mjta.tenis.domain.entities.Match;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;
import java.util.List;

@Stateless
public class CourtRepositoryImpl implements CourtRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Court insert(Court court) {
		this.entityManager.persist(court);
		return court;
	}

	@Override
	public List<Court> getAll() {
		return this.entityManager.createQuery("SELECT c FROM Court c", Court.class).getResultList();
	}

	@Override
	public boolean isAvailable(Court court, LocalDateTime matchDate) {

		var date = matchDate.minus(4, ChronoUnit.HOURS);
		var query = this.entityManager.createQuery("SELECT m.court.id FROM Match m WHERE m.court.id = :court AND m.finished = false AND m.dateTime > :date", String.class);
		return query
			.setParameter("court", court.getId())
			.setParameter("date", date)
			.getResultList().size() == 0;
	}

	@Override
	public Court getById(String id) {
		return this.entityManager.find(Court.class, id);
	}
}

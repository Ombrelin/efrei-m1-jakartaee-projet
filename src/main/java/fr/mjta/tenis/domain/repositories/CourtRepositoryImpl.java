package fr.mjta.tenis.domain.repositories;

import fr.mjta.tenis.domain.entities.Court;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public List<Court> getCourts() {
		return this.entityManager.createQuery("SELECT c FROM Court c", Court.class).getResultList();
	}

	@Override
	public Court getById(String id) {
		return this.entityManager.find(Court.class, id);
	}
}

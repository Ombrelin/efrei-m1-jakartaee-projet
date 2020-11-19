package fr.mjta.tenis.domain.entities;

import javax.persistence.Entity;

@Entity
public class Referee extends Person {

    public Referee(String name, String nationality) {
        super();
        this.setName(name);
        this.setNationality(nationality);
    }

    public Referee() {

    }
}

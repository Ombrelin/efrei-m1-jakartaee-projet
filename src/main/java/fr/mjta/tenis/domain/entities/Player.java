package fr.mjta.tenis.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Player extends Person {

    @Column
    private int worldRank;

    public Player() {
    }

    public Player(String name, Gender gender, String nationality) {
        super();
        this.setName(name);
        this.setGender(gender);
        this.setNationality(nationality);
    }

    public int getWorldRank() {
        return worldRank;
    }

    public void setWorldRank(int worldRank) {
        this.worldRank = worldRank;
    }
}

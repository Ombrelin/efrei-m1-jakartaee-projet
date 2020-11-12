package fr.mjta.tenis.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Player extends Person {

    @Column
    private int worldRank;

    public Player() {
    }

    public int getWorldRank() {
        return worldRank;
    }

    public void setWorldRank(int worldRank) {
        this.worldRank = worldRank;
    }
}

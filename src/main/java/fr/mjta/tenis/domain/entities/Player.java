package fr.mjta.tenis.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Player extends Person {

    @Column
    private int worldRank;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Match> matches;

    public Player() {
    }

    public Player(String name, Gender gender, String nationality) {
        super();
        this.setName(name);
        this.setGender(gender);
        this.setNationality(nationality);
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    public int getWorldRank() {
        return worldRank;
    }

    public void setWorldRank(int worldRank) {
        this.worldRank = worldRank;
    }
}

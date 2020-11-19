package fr.mjta.tenis.domain.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "match_table")
public class Match {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column
    private int team1Score;

    @Column
    private int team2Score;

    @Column
    private LocalDateTime dateTime;

    @Column
    private String court;

    @Column
    private Duration duration;

    @Column(columnDefinition = "boolean default false")
    private boolean finished;

    @Column(columnDefinition = "boolean default false")
    private boolean prepared;

    @ManyToOne(fetch = FetchType.EAGER)
    private Referee referee;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Participation> participants;

    public Match() {
    }

    public boolean isPrepared() {
        return prepared;
    }

    public void setPrepared(boolean prepared) {
        this.prepared = prepared;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTeam1Score() {
        return team1Score;
    }

    public void setTeam1Score(int team1Score) {
        this.team1Score = team1Score;
    }

    public int getTeam2Score() {
        return team2Score;
    }

    public void setTeam2Score(int team2Score) {
        this.team2Score = team2Score;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCourt() {
        return court;
    }

    public void setCourt(String court) {
        this.court = court;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public Set<Participation> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Participation> participants) {
        this.participants = participants;
    }

    public Set<Player> getTeam1() {
        return this.participants
                .stream()
                .filter(participation -> participation.getTeamNumber() == 1)
                .map(Participation::getPlayer)
                .collect(Collectors.toSet());
    }

    public Set<Player> getTeam2() {
        return this.participants
                .stream()
                .filter(participation -> participation.getTeamNumber() == 2)
                .map(Participation::getPlayer)
                .collect(Collectors.toSet());
    }
}

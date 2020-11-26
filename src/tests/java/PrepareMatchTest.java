import fr.mjta.tenis.domain.entities.Player;
import fr.mjta.tenis.domain.entities.Referee;
import fr.mjta.tenis.domain.services.MatchService;
import fr.mjta.tenis.domain.services.MatchServiceImpl;
import org.hibernate.id.GUIDGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PrepareMatchTest {
    MatchServiceImpl matchService;

    @Test
    public void prepareMatchTeamHasSamePlayer(){
        String idMatch = "123";
        Set<Player> team1 = new HashSet<>();
        Player player1 = new Player();
        team1.add(player1);
        Set<Player> team2 = new HashSet<>();
        team2.add(player1);
        Referee referee = new Referee();
        try {
            matchService.prepareMatch(idMatch, team1, team2, referee);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

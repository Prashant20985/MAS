package Dynamic;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void testSoccerTeamTest(){
        SoccerTeam team = new SoccerTeam("Soccer Team");
        assertEquals("Soccer Team", team.getName());

        team.scoreGoal();
        team.scoreGoal();
        team.concedeGoal();
        team.win();
        assertEquals(2, team.getGoalsFor());
        assertEquals(1, team.getGoalsAgainst());
        assertEquals(1, team.getGoalDifference());
        assertEquals(3, team.getPoints());

        team.concedeGoal();
        team.concedeGoal();
        team.lose();
        assertEquals(-1, team.getGoalDifference());
        assertEquals(4, team.getPoints());
    }

    @Test
    public void testBasketBallTeam(){
        BasketballTeam team = new BasketballTeam("Basketball team");
        assertEquals("Basketball team", team.getName());

        team.scorePoint();
        team.scorePoint();
        team.concedePoint();
        team.win();
        assertEquals(2, team.getPointsFor());
        assertEquals(1, team.getPointsAgainst());
        assertEquals(1, team.getPointDifference());
        assertEquals(3, team.getPoints());

        team.concedePoint();
        team.concedePoint();
        team.lose();
        assertEquals(-1, team.getPointDifference());
        assertEquals(4, team.getPoints());
    }
}
package Dynamic;

public class SoccerTeam extends Team{
    private int goalsFor;
    private int goalsAgainst;

    public SoccerTeam(String name) {
        super(name);
        this.goalsFor = 0;
        this.goalsAgainst = 0;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public void scoreGoal(){
        this.goalsFor++;
    }

    public void concedeGoal(){
        this.goalsAgainst++;
    }

    public int getGoalDifference(){
        return this.goalsFor - this.goalsAgainst;
    }

    @Override
    public int getPoints() {
        return (this.wins * 3) + this.losses;
    }
}

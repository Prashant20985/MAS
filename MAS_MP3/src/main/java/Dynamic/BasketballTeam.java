package Dynamic;

public class BasketballTeam extends Team{
    private int pointsFor;
    private int pointsAgainst;

    public BasketballTeam(String name) {
        super(name);
        this.pointsFor = 0;
        this.pointsAgainst = 0;
    }

    public int getPointsFor() {
        return pointsFor;
    }

    public void setPointsFor(int pointsFor) {
        this.pointsFor = pointsFor;
    }

    public int getPointsAgainst() {
        return pointsAgainst;
    }

    public void setPointsAgainst(int pointsAgainst) {
        this.pointsAgainst = pointsAgainst;
    }

    public void scorePoint() {
        this.pointsFor++;
    }

    public void concedePoint() {
        this.pointsAgainst++;
    }

    public int getPointDifference() {
        return this.pointsFor - this.pointsAgainst;
    }

    @Override
    public int getPoints() {
        return this.wins * 3 + this.losses;
    }
}

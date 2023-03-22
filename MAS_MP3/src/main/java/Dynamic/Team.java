package Dynamic;

public abstract class Team {

    private String name;
    protected int wins;
    protected int losses;

    public Team(String name){
        setName(name);
        this.wins = 0;
        this.losses = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name must not be blank or empty");
        }
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void win() {
        this.wins++;
    }

    public void lose() {
        this.losses++;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public abstract int getPoints();
}

package Overlapping;

public abstract class Pokemon {
    private String name;
    private int level;
    private int health;
    private PokemonType pokemonType;

    public Pokemon(String name, int level, int health, PokemonType pokemonType) {
        setName(name);
        setLevel(level);
        setHealth(health);
        setPokemonType(pokemonType);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Pokemon name must not be blank or null");
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    private void setLevel(int level) {
        if (level < 0)
            throw new IllegalArgumentException("Level cannot be less than zero");
        this.level = level;
    }

    private void setHealth(int health) {
        if (health < 0)
            throw new IllegalArgumentException("Health cannot be less than zero");
        this.health = health;
    }

    public PokemonType getPokemonType() {
        return pokemonType;
    }

    private void setPokemonType(PokemonType pokemonType) {
        if (pokemonType == null)
            throw new IllegalArgumentException("Pokemon type must not be null");
        this.pokemonType = pokemonType;
    }

    public void levelUp() {
        level++;
    }

    public abstract int calculateDamage(Pokemon opponent);

    public abstract int calculateExperience();
}

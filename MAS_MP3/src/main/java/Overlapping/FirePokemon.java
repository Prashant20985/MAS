package Overlapping;

public class FirePokemon extends Pokemon {
    private int firePower;

    public FirePokemon(String name, int level, int health, int firePower) {
        super(name, level, health, PokemonType.FIRE);
        setFirePower(firePower);
    }

    public int getFirePower() {
        return firePower;
    }

    private void setFirePower(int firePower) {
        if (firePower < 0)
            throw new IllegalArgumentException("Fire power cannot be less than zero");
        this.firePower = firePower;
    }

    @Override
    public int calculateDamage(Pokemon opponent) {
        int damage = 0;
        if (opponent.getPokemonType() == PokemonType.ELECTRIC){
            damage = (int) (firePower * 1.5);
        }
        else if (opponent.getPokemonType() == PokemonType.WATER){
            damage = (int) (firePower * 0.5);
        }
        else {
            damage = firePower;
        }
        return damage;
    }

    @Override
    public int calculateExperience() {
        return 20 * getLevel();
    }
}

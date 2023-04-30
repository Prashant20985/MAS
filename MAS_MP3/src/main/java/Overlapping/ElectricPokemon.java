package Overlapping;

public class ElectricPokemon extends Pokemon {
    private int electricPower;

    public ElectricPokemon(String name, int level, int health, int electricPower) {
        super(name, level, health, PokemonType.ELECTRIC);
        setElectricPower(electricPower);
    }

    public int getElectricPower() {
        return electricPower;
    }

    public void setElectricPower(int electricPower) {
        if (electricPower < 0)
            throw new IllegalArgumentException("Electric power must not be less than zero");
        this.electricPower = electricPower;
    }

    @Override
    public int calculateDamage(Pokemon opponent) {
        int damage = 0;
        if (opponent.getPokemonType() == PokemonType.WATER) {
            damage = (int) (electricPower * 1.5);
        } else if (opponent.getPokemonType() == PokemonType.FIRE) {
            damage = (int) (electricPower * 0.5);
        } else {
            damage = electricPower;
        }
        return damage;
    }

    @Override
    public int calculateExperience() {
        return 20 + getLevel();
    }
}

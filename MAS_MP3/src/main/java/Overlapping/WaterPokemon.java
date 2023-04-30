package Overlapping;

public class WaterPokemon extends Pokemon {
    private int waterPower;

    public WaterPokemon(String name, int level, int health, int waterPower) {
        super(name, level, health, PokemonType.WATER);
        setWaterPower(waterPower);
    }

    public int getWaterPower() {
        return waterPower;
    }

    private void setWaterPower(int waterPower) {
        if (waterPower < 0)
            throw new IllegalArgumentException("Water power must not be less than zero");
        this.waterPower = waterPower;
    }

    @Override
    public int calculateDamage(Pokemon opponent) {
        int damage = 0;
        if (opponent.getPokemonType() == PokemonType.ELECTRIC) {
            damage = (int) (waterPower * 0.5);
        } else if (opponent.getPokemonType() == PokemonType.FIRE) {
            damage = (int) (waterPower * 1.5);
        } else {
            damage = waterPower;
        }
        return damage;
    }

    @Override
    public int calculateExperience() {
        return 20 * getLevel();
    }
}

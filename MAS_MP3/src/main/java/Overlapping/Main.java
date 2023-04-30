package Overlapping;

public class Main {
    public static void main(String[] args) {
        FirePokemon charmander = new FirePokemon("Charmander", 1, 39, 100);

        WaterPokemon squirtle = new WaterPokemon("Squirtle", 1, 44, 100);

        System.out.println(charmander.getName() + "'s level is " + charmander.getLevel() +
                " and its health is " + charmander.getHealth() + ". It is a " + charmander.getPokemonType() + ".");
        System.out.println(squirtle.getName() + "'s level is " + squirtle.getLevel() +
                " and its health is " + squirtle.getHealth() + ". It is a " + squirtle.getPokemonType() + ".");

        int damage = charmander.calculateDamage(squirtle);
        System.out.println(charmander.getName() + " used Ember and dealt " + damage + " damage to " + squirtle.getName());

        damage = squirtle.calculateDamage(charmander);
        System.out.println(squirtle.getName() + " used Bubble and dealt " + damage + " damage to " + charmander.getName());

        charmander.levelUp();
        squirtle.levelUp();
        System.out.println(charmander.getName() + "'s experience is now " + charmander.calculateExperience() +
                " and its level is now " + charmander.getLevel() + ".");
        System.out.println(squirtle.getName() + "'s experience is now " + squirtle.calculateExperience() +
                " and its level is now " + squirtle.getLevel() + ".");

    }
}

package Overlapping;

import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Pokemon charizard = new Pokemon("Charizard", Set.of(PokemonType.FIRE));
        Pokemon lanturn = new Pokemon("Lanturn", Set.of(PokemonType.WATER, PokemonType.ELECTRIC));

        System.out.print(charizard.getPokemonName() + " of Type ");
        charizard.getPokemonTypes().forEach(x -> System.out.print(x + ", "));
        System.out.println(printPowers(charizard));

        System.out.println();

        System.out.print(lanturn.getPokemonName() + " of Type ");
        lanturn.getPokemonTypes().forEach(x -> System.out.print(x + ", "));
        System.out.println(printPowers(lanturn));

        System.out.println();

        charizard.attack();
        System.out.println("Power Levels = " + printPowers(charizard));

        System.out.println();

        lanturn.attack();
        System.out.println("Power Levels = " + printPowers(lanturn));
    }
    public static String printPowers(Pokemon pokemon){
        return "\nPowers \nAttack: " + pokemon.getAttack() + "\nSpeed: " + pokemon.getSpeed() + "\nDefence: " + pokemon.getDefence();
    }
}

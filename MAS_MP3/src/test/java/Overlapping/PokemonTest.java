package Overlapping;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class PokemonTest {

    @Test
    public void testAddType(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC));
        electricPokemon.addType(PokemonType.WATER);
        assertEquals(2, electricPokemon.getPokemonTypes().size());
        assertTrue(electricPokemon.getPokemonTypes().contains(PokemonType.ELECTRIC));
        assertTrue(electricPokemon.getPokemonTypes().contains(PokemonType.WATER));
        assertFalse(electricPokemon.getPokemonTypes().contains(PokemonType.FIRE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAlreadyExistingType(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC));
        electricPokemon.addType(PokemonType.ELECTRIC);
    }

    @Test
    public void testAddPokemonTypes(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC));
        Set<PokemonType> pokemonTypes = Set.of(PokemonType.FIRE, PokemonType.WATER);

        electricPokemon.addPokemonTypes(pokemonTypes);
        assertEquals(3, electricPokemon.getPokemonTypes().size());
        assertTrue(electricPokemon.getPokemonTypes().contains(PokemonType.WATER));
        assertTrue(electricPokemon.getPokemonTypes().contains(PokemonType.FIRE));
        assertTrue(electricPokemon.getPokemonTypes().contains(PokemonType.ELECTRIC));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicatePokemonTypes(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC));
        Set<PokemonType> pokemonTypes = Set.of(PokemonType.FIRE, PokemonType.WATER);
        electricPokemon.addPokemonTypes(pokemonTypes);
        electricPokemon.addPokemonTypes(pokemonTypes);
    }

    @Test
    public void testRemoveType(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC, PokemonType.WATER));
        assertEquals(2, electricPokemon.getPokemonTypes().size());

        electricPokemon.removeType(PokemonType.WATER);
        assertEquals(1, electricPokemon.getPokemonTypes().size());
        assertTrue(electricPokemon.getPokemonTypes().contains(PokemonType.ELECTRIC));
        assertFalse(electricPokemon.getPokemonTypes().contains(PokemonType.WATER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonExistingPokemonType(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC, PokemonType.FIRE));
        electricPokemon.removeType(PokemonType.WATER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOneTypeRequired(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC));
        electricPokemon.removeType(PokemonType.ELECTRIC);
    }

    @Test
    public void pokemonAttackTest(){
        Pokemon electricPokemon =
                new Pokemon("Electric Pokemon", Set.of(PokemonType.ELECTRIC));
        Pokemon electricWaterPokemon =
                new Pokemon("Electric Water Pokemon", Set.of(PokemonType.ELECTRIC, PokemonType.WATER));
        Pokemon electricWaterFirePokemon =
                new Pokemon("Electric Water Fire Pokemon", Set.of(PokemonType.ELECTRIC, PokemonType.WATER, PokemonType.FIRE));

        assertEquals(1000, electricPokemon.getDefence());
        assertEquals(0, electricPokemon.getAttack());
        assertEquals(0, electricPokemon.getSpeed());

        electricPokemon.attack();
        assertEquals(990, electricPokemon.getDefence());
        assertEquals(0, electricPokemon.getAttack());
        assertEquals(0, electricPokemon.getSpeed());

        System.out.println();

        assertEquals(1000, electricWaterPokemon.getDefence());
        assertEquals(100, electricWaterPokemon.getSpeed());
        assertEquals(0, electricWaterPokemon.getAttack());

        electricWaterPokemon.attack();
        assertEquals(990, electricWaterPokemon.getDefence());
        assertEquals(99, electricWaterPokemon.getSpeed());
        assertEquals(0, electricWaterPokemon.getAttack());

        System.out.println();

        assertEquals(1000, electricWaterFirePokemon.getAttack());
        assertEquals(1000, electricWaterFirePokemon.getDefence());
        assertEquals(100, electricWaterFirePokemon.getSpeed());

        electricWaterFirePokemon.attack();
        assertEquals(990, electricWaterFirePokemon.getAttack());
        assertEquals(990, electricWaterFirePokemon.getDefence());
        assertEquals(99, electricWaterFirePokemon.getSpeed());
    }

}
package Overlapping;

import java.util.*;

public class Pokemon {
    private final Set<PokemonType> pokemonTypes = new HashSet<>();

    private String pokemonName;

    private int attack;
    private int defence;
    private int speed;

    public Pokemon(String pokemonName, Set<PokemonType> pokemonTypes) {
        setPokemonName(pokemonName);
        addPokemonTypes(pokemonTypes);
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public void setPokemonName(String pokemonName) {
        if (pokemonName == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        if (pokemonName.isBlank()) {
            throw new IllegalArgumentException("name cannot be blank");
        }
        this.pokemonName = pokemonName;
    }

    public Set<PokemonType> getPokemonTypes() {
        return Collections.unmodifiableSet(pokemonTypes);
    }

    public void addPokemonTypes(Set<PokemonType> pokemonTypeSet) {
        if(pokemonTypeSet == null){
            throw new IllegalArgumentException("Pokemon type cannot be null");
        }
        if(this.pokemonTypes.size() == 0 && pokemonTypeSet.size() == 0){
            throw new IllegalArgumentException("Pokemon must have at least one type");
        }
        for(PokemonType type : pokemonTypeSet){
            if(pokemonTypes.contains(type)){
                throw new IllegalArgumentException("Pokemon already have this type");
            }
            addType(type);
        }
    }

    public void addType(PokemonType type) {
        if(type == null){
            throw new IllegalArgumentException("Pokemon type cannot be null");
        }
        if(pokemonTypes.contains(type)){
            throw new IllegalArgumentException("Pokemon already has this type");
        }

        if(type.equals(PokemonType.FIRE)){
            attack = 1000;
        }
        if(type.equals(PokemonType.ELECTRIC)){
            defence = 1000;
        }
        if(type.equals(PokemonType.WATER)){
            speed = 100;
        }
        pokemonTypes.add(type);
    }

    public void removeType(PokemonType type) {
        if(type == null){
            throw new IllegalArgumentException("Pokemon type cannot be null");
        }
        if(!pokemonTypes.contains(type)){
            throw new IllegalArgumentException("Pokemon type is not present");
        }
        if(pokemonTypes.size() == 1 && pokemonTypes.contains(type)){
            throw new IllegalArgumentException("Pokemon must have at lest one type");
        }
        if(type.equals(PokemonType.FIRE)){
            attack = 0;
        }
        if(type.equals(PokemonType.ELECTRIC)){
            defence = 0;
        }
        if(type.equals(PokemonType.WATER)){
            speed = 0;
        }
        pokemonTypes.remove(type);
    }

    public void attack() {
        System.out.println(pokemonName + " attacks");
        if (pokemonTypes.contains(PokemonType.ELECTRIC)) {
            thunderPunch();
        }
        if (pokemonTypes.contains(PokemonType.FIRE)) {
            blastBurn();
        }
        if (pokemonTypes.contains(PokemonType.WATER)) {
            hydroCannon();
        }
    }

    public void thunderPunch() {
        if (pokemonTypes.contains(PokemonType.ELECTRIC) && defence >= 10) {
            System.out.println("Thunder Punch");
            defence -= 10;
        }
    }

    public void blastBurn() {
        if (pokemonTypes.contains(PokemonType.FIRE) && attack >= 10) {
            System.out.println("Blast Burn");
            attack -= 10;
        }
    }

    public void hydroCannon() {
        if (pokemonTypes.contains(PokemonType.WATER) && speed >= 1) {
            System.out.println("Hydro Cannon");
            speed--;
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}

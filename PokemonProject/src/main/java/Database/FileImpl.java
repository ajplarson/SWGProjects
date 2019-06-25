/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Types.Pokemon;
import Types.PokemonType;
import Types.Trainer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class FileImpl implements File {

    public static final String TRAINER_DELIMITER = "::";
    public static final String POKEMON_DELIMITER = "||";
    public static final String END_OF_DELIMITER = "{{";
    private ArrayList<Trainer> trainers = new ArrayList<>();

    private Trainer unmarshallTrainer(String trainerAsText) {
        //expected format
        //TrainerName::PokemonList
        String[] trainerTokens = trainerAsText.split(TRAINER_DELIMITER);
        String name = trainerTokens[0];
        ArrayList<Pokemon> pokemonForThisTrainer = new ArrayList<>();
        pokemonForThisTrainer = unmarshallPokemonList(trainerTokens[1]);
        Trainer unmarshalledTrainer = new Trainer(name);
        unmarshalledTrainer.setPokedex(pokemonForThisTrainer);
        trainers.add(unmarshalledTrainer);
        return unmarshalledTrainer;
    }

    private ArrayList<Pokemon> unmarshallPokemonList(String pokemonsAsText) {
        //expected format
        //Pokemon1{{Pokemon2
        ArrayList<Pokemon> list = new ArrayList<>();
        Pokemon currentPokemon = new Pokemon();
        String[] pokemonsTokens = pokemonsAsText.split(END_OF_DELIMITER);
        for (int i = 0; i < pokemonsTokens.length; i++) {
            currentPokemon = unmarshallPokemon(pokemonsTokens[i]);
            list.add(currentPokemon);
        }
        return list;
    }

    private Pokemon unmarshallPokemon(String pokemonAsText) {
        //expected format
        //PokemonName||PokemonType||PokemonHP||PokemonSpeed||PokemonAttack
        String[] pokemonTokens = pokemonAsText.split(POKEMON_DELIMITER);
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonTokens[0]);
        pokemon.setType(PokemonType.valueOf(pokemonTokens[1]));
        pokemon.setHp(Integer.parseInt(pokemonTokens[2]));
        pokemon.setSpeed(Integer.parseInt(pokemonTokens[3]));
        pokemon.setAttack(Integer.parseInt(pokemonTokens[4]));
        return pokemon;
    }

    @Override
    public Trainer addTrainer(Trainer trainer) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trainer> getAllTrainers() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trainer removeTrainer(Trainer trainer) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Trainer getTrainer(int trainerID) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pokemon addPokemon(Pokemon pokemon) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pokemon> getAllPokemon() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pokemon removePokemon(Pokemon pokemon) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pokemon getPokemon(int pokemonID) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template File, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Types.Pokemon;
import Types.Trainer;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public interface File {

    Trainer addTrainer(Trainer trainer)
            throws PersistenceException;

    List<Trainer> getAllTrainers()
            throws PersistenceException;

    Trainer removeTrainer(Trainer trainer)
            throws PersistenceException;

    Trainer getTrainer(int trainerID)
            throws PersistenceException;

    Pokemon addPokemon(Pokemon pokemon)
            throws PersistenceException;

    List<Pokemon> getAllPokemon()
            throws PersistenceException;

    Pokemon removePokemon(Pokemon pokemon)
            throws PersistenceException;

    Pokemon getPokemon(int pokemonID)
            throws PersistenceException;
}

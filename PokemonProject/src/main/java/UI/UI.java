package UI;

import Types.Pokemon;
import Types.PokemonType;
import Types.Trainer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static javax.swing.text.html.HTML.Attribute.COLS;
import static javax.swing.text.html.HTML.Attribute.ROWS;

/**
 * @author ajplarson
 */
public class UI {

    //add trade functionality?
    private UserIO io;

    public UI(UserIO io) {
        this.io = io;
    }

    public void displayWelcomeBanner() {
        io.print("===GOTTA CATCH 'EM ALL===");
    }

    //trainer menu
    public int printTrainerMenuAndGetSelection() {
        io.print("1. Create a new Trainer");
        io.print("2. Continue with a previous trainer");
        io.print("3. Edit a trainer's information");
        io.print("4. View all Trainers");
        io.print("5. Exit");
        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public Trainer getTrainerInformation() {
        String name = io.readString("What is the Trainer's name?");
        Trainer trainerToCreate = new Trainer(name);
        return trainerToCreate;
    }

    public void displayDisplayAllTrainersBanner() {
        io.print("===== All Trainers =====");
    }

    public void displayTrainerList(List<Trainer> trainerList) {
        for (Trainer currentTrainer : trainerList) {
            System.out.printf("||ID: %s %s ||",
                    currentTrainer.getTrainerID(), currentTrainer.getName());
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayTrainer(Trainer trainer) {
        if (trainer != null) {
            io.print("_________________________");
            io.print("ID: " + trainer.getTrainerID());
            io.print("Name: " + trainer.getName());
            displayPokemonList(trainer.getPokedex());
            io.print("_________________________");
        } else {
            io.print("That trainer does not exist");
        }
        io.readString("Please hit enter to continue.");
    }

    //pokemon menu
    public int printPokemonMenuAndGetSelection() {
        io.print("1. Add a Pokemon to your Pokedex");
        io.print("2. View All Pokemon");
        io.print("3. View information about a specific Pokemon");
        io.print("4. Remove a Pokemon from your Pokedex");
        io.print("5. Edit a Pokemon in your Pokedex");
        io.print("6. Back to Trainer Menu");
        io.print("7. Exit");
        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public Pokemon getPokemonInformation() {
        
        Pokemon pokemonToCreate = new Pokemon();
        pokemonToCreate.setName(io.readString("What is the Pokemon's name?"));
        PokemonType type = PokemonType.valueOf(io.readString("Please enter the Pokemon's type").toUpperCase());
        pokemonToCreate.setType(type);
        pokemonToCreate.setHp(io.readInt("Please enter the Pokemon's HP [0-150]", 0, 150));
        pokemonToCreate.setAttack(io.readInt("Please enter the Pokemon's attack [0-250]", 0, 250));
        pokemonToCreate.setSpeed(io.readInt("Please enter the Pokemon's speed [0-250]", 0, 250));
        return pokemonToCreate;
    }

    public void displayAllPokemonBanner() {
        io.print("===== All Pokemon =====");
    }

    public void displayPokemonList(List<Pokemon> pokemonList) {
        for (Pokemon currentPokemon : pokemonList) {
            System.out.printf("||ID: %s %s Type: %s HP: %s Attack: %s Speed: %s||",
                    currentPokemon.getPokemonID(), currentPokemon.getName(), currentPokemon.getType(),
                    currentPokemon.getHp(), currentPokemon.getAttack(), currentPokemon.getSpeed());
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayPokemon(Pokemon pokemon) {
        if (pokemon != null) {
            io.print("_________________________");
            io.print("ID: " + pokemon.getPokemonID());
            io.print("Name: " + pokemon.getName());
            io.print("Type: " + pokemon.getType());
            io.print("HP: " + pokemon.getHp());
            io.print("Attack: " + pokemon.getAttack());
            io.print("Speed: " + pokemon.getSpeed());
            io.print("_________________________");
        } else {
            io.print("That pokemon does not exist");
        }
        io.readString("Please hit enter to continue.");
    }

    //exit message
    public void displayExitBanner() {
        io.print("________");
        io.print("GOOD BYE");
        io.print("________");
    }

    //error handling
    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}

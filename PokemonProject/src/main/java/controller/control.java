/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Service.PokemonGame;
import UI.UI;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ajplarson
 */
public class control {

    //BEGIN: Injection only need these two
    private UI view;
    private PokemonGame service;

    public control(PokemonGame service, UI view) {
        this.service = service;
        this.view = view;
    }
    //END: Injection

    public void runTrainerMenu() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            view.displayWelcomeBanner();
            while (keepGoing) {
                menuSelection = getTrainerMenuSelection();
                switch (menuSelection) {
                    case 1:
                        createTrainer();
                        break;
                    case 2:
                        getTrainer();
                        break;
                    case 3:
                        updateTrainer();
                    case 4:
                        viewTrainers();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public void runPokemonMenu() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            view.displayWelcomeBanner();
            while (keepGoing) {
                menuSelection = getPokemonMenuSelection();
                switch (menuSelection) {
                    case 1:
                        createPokemon();
                        break;
                    case 2:
                        viewPokemons();
                        break;
                    case 3:
                        viewPokemon();
                        break;
                    case 4:
                        removePokemon();
                        break;
                    case 5:
                        editPokemon();
                        break;
                    case 6:
                        trainerMenu();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (Exception e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getTrainerMenuSelection() {
        return view.printTrainerMenuAndGetSelection();
    }

    private int getPokemonMenuSelection() {
        return view.printPokemonMenuAndGetSelection();
    }

    private void viewTrainers() {
        view.displayDisplayAllTrainersBanner();
        List<Trainer> trainerList = ;
        view.displayTrainerList(trainerList);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}

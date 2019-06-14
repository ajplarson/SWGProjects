/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.mavenproject4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) {
        try {
            unchecked();
        } catch (RuntimeException e) {
            System.out.println("A message");
        }
        openFile();
        checked();
        System.out.println("Done");
    }

    private static void unchecked() {
        throw new RuntimeException();
    }

    private static void checked() {
        try {
            furtherDown();
        } catch (TheChildException | TheSiblingException ex) {
            System.out.println("It's okay now.");
        } catch (TheException ex) {
            System.out.println("It IS okay now");

        }
    }

    private static void furtherDown() throws TheException {
        throw new TheChildException();
    }

    private static void openFile() {
        try (PrintWriter writer = new PrintWriter("thefile")) {
            writer.print("value");
            writer.flush();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}

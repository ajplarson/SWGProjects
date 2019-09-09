/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iopractice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(
                new BufferedReader(new FileReader("readme.txt")));

        // go through the file line by line
        while (sc.hasNextLine()) {
            String currentLine = sc.nextLine();

            //skip over the comments
            if (!(currentLine.isEmpty()) && currentLine.charAt(0) != '#') {
                int index = currentLine.indexOf(' ');
                int index2 = currentLine.indexOf(' ', index + 1);
                int index3 = currentLine.indexOf('/', index2 + 1);
                String input;
                String input2;
                String destination;

                if (currentLine.contains("CREATE")) {
                    input = currentLine.substring(index+1);
                    PrintWriter out = new PrintWriter(new FileWriter(input));
                    out.flush();
                    out.close();
                }
                else if(currentLine.contains("APPEND")) {
                    input = currentLine.substring(index+1, index2);
                    PrintWriter out = new PrintWriter(new FileWriter(input, true));
                    input2 = currentLine.substring(index2 + 1);
                    out.println(input2);
                    out.flush();
                    out.close();
                    
                }
                else if(currentLine.contains("DELETE")) {
                    input = currentLine.substring(index+1);
                    Path path = Paths.get(input);
                    Files.deleteIfExists(path);
                }
                else if (currentLine.contains("COPY")) {
                    input = currentLine.substring(index+1,index2);
                    destination = currentLine.substring(index2 + 1, index3);
                    input2 = currentLine.substring(index3);
                    Path path2 = Paths.get(destination);
                    File file = path2.toFile();
                    file.mkdir();
                    Path path = Paths.get(input);
                    
                    PrintWriter out = new PrintWriter(new FileWriter(destination, true));
                    Files.copy(path, path2);
                }

            }

        }
    }
}

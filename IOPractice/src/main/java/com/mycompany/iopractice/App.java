/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.iopractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class App {
    public static void main(String[] args) throws Exception {
        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
        out.println("this is a line");
        out.println("we got another line here");
        out.flush();
        out.close();
        Scanner sc = new Scanner(
    new BufferedReader(new FileReader("OutFile.txt")));
// go through the file line by line
while (sc.hasNextLine()) {
    String currentLine = sc.nextLine();
    System.out.println(currentLine);
    }
    }
}

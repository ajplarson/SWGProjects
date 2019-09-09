/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author ajplarson
 */
public class App {

    private static final int MAX_GUESSES = 8;
    private static final int NUM_NUMBERS = 4;
    private static final Random rand = new Random();

    public static void main(String[] args) {
        for (Character i : makeWinningNumbers().toCharArray()) {
            System.out.println(i);
        }
        System.out.println(makeWinningNumbers());
    }

    public static String makeWinningNumbers() {
        Set<Integer> nums = new HashSet<>();
        String output = "";
        while (nums.size() < NUM_NUMBERS) {
            Integer toAdd = rand.nextInt(10);
            nums.add(toAdd);
        }
        List<Integer> list = new ArrayList<>(nums);
        Collections.shuffle(list);
        for(int i = 0; i < NUM_NUMBERS; i++) {
            output += list.get(i);
        }
        return output;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.prac;

/**
 *
 * @author ajplarson
 */
public class app {
    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        long counter = 0;
        int i = ((int)(n/s.length())+1);
        System.out.println(i);
        while (i > 0) {
            s += s;
            i--;
        }
        String chars = s.substring(0, (int)(n));
        System.out.println(chars);
        char[] c = chars.toCharArray();
        for (int j = 0; j < c.length; j++) {
            if (c[j] == 'a') {
                counter++;
            }
        }
        System.out.println(counter);
        
    }
    
}


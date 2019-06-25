/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.sectionthreeunittests;

/**
 *
 * @author ajplarson
 */
public class Secret {
    public String Secret(int n, String input) {
        char[] chars = new char[input.length()];
        for(int j = 0; j < input.length(); j++) {
            if(!(j % 2 == 0)) {
                chars[j] = 'q';
            }
            else {
                chars[j] = input.charAt(j);
            }
        }
        return chars.toString();
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.encryption;

/**
 *
 * @author ajplarson
 */
public class Encryption {
    final static int MIN = 65;
    final static int MAX = 122;
    final static int RANGE = MAX - MIN + 1;
   public static void main(String[] args) {
        System.out.println();
    }
    
    public static int encryptModulo(int input){
        return ((input + 2 - MIN) % RANGE) + MIN;
    }
    
    public static int decryptModulo(int input) {
        int output = ((input - 2 - MIN) % RANGE) + MIN;
        if (output < MIN) {
            return output + RANGE;
        } else
        return output;
    }

    public String encrypt(String plainText){
        String coded = "";
        
        for(int i =0; i<plainText.length();i++){
            int plainCharInt = (int)plainText.charAt(i);
            int codedCharInt = encryptModulo(plainCharInt);
            coded += (char)codedCharInt;
        }
        return coded;
    }
    
    public String decrypt(String coded){
        String plainText = "";
        for(int i =0; i<coded.length();i++){
            int codedInt = (int)coded.charAt(i);
            int plainTextInt = decryptModulo(codedInt);
            plainText += (char)plainTextInt;
        }        
        return plainText;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.encryption;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class EncryptionTest {

    Encryption e = new Encryption();

    public EncryptionTest() {
    }

    /**
     * Test of encrypt method, of class Encryption.
     */
    @Test
    public void testEncryptcat() {
        String input = "cat";
        String expected = "ecv";
        assertEquals(expected, e.encrypt(input));
    }

    @Test
    public void testEncryptZip() {
        String input = "Zip";
        String expected = "\\kr";
        assertEquals(expected, e.encrypt(input));
    }

    @Test
    public void testEncryptzip() {
        String input = "zip";
        String expected = "Bkr";
        assertEquals(expected, e.encrypt(input));
    }

    @Test
    public void testDecryptecv() {
        String input = "ecv";
        String expected = "cat";
        assertEquals(expected, e.decrypt(input));
    }

    @Test
    public void testDecryptBkr() {
        String input = "Bkr";
        String expected = "zip";
        assertEquals(expected, e.decrypt(input));
    }

    @Test
    public void testDecryptCat() {
        String input = "cat";
        String expected = "a_r";
        assertEquals(expected, e.decrypt(input));

    }

    @Test
    public void testDecryptModuloz() {
        int input = 122;
        int expected = 120;
        assertEquals(expected, e.decryptModulo(122));
    }

    @Test
    public void testDecryptModuloB() {
        int input = 66;
        int expected = 122;
        assertEquals(expected, e.decryptModulo(input));
    }

}

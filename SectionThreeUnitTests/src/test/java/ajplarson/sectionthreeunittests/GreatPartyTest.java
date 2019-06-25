/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.sectionthreeunittests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class GreatPartyTest {

    GreatParty party = new GreatParty();

    public GreatPartyTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of greatParty method, of class GreatParty.
     * // greatParty(30, false) → false
// greatParty(50, false) → true
// greatParty(70, true) → true
     */
    @Test
    public void test30False() {
        assertFalse(party.greatParty(30, false));
    }
    
    @Test 
    public void test50False() {
        assertTrue(party.greatParty(50, false));
    }
    
    @Test
    public void test70True() {
        assertTrue(party.greatParty(70, true));
    }
    
    @Test 
    public void test40True() {
        assertTrue(party.greatParty(40, true));
    }
    
    @Test
    public void test61True() {
        assertTrue(party.greatParty(61, true));
    }
    
    @Test
    public void test60True() {
        assertTrue(party.greatParty(60, true));
    }

    /**
     * Test of greatParty method, of class GreatParty.
     */
    @Test
    public void testGreatParty() {
        System.out.println("greatParty");
        int cigars = 0;
        boolean isWeekend = false;
        GreatParty instance = new GreatParty();
        boolean expResult = false;
        boolean result = instance.greatParty(cigars, isWeekend);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

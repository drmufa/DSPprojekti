/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import mathOperations.Kompleksiluku;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jajnousi
 */
public class KompleksilukuTest {
    
     private Kompleksiluku z1;
    private Kompleksiluku z2;
    private Kompleksiluku zz;
    
    public KompleksilukuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        z1 = new Kompleksiluku(1,2);
        z2 = new Kompleksiluku(3,4);
        zz = new Kompleksiluku(5,6);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testaayhteenlasku()throws IOException{
        Kompleksiluku z3 = z1.plus(z2);
        assertEquals("4.0 + 6.0i", z3.toString());
    }
     @Test
    public void testaavahennyslasku(){
        Kompleksiluku z3 = z1.miinus(z2);
        assertEquals("-2.0 - 2.0i", z3.toString());    
    }
     @Test
    public void testaakertolasku(){
        Kompleksiluku z3 = z1.kertaa(z2);
        Kompleksiluku z4 = zz.kertaa(z2);
        assertEquals("-5.0 + 10.0i", z3.toString());
        assertEquals("-9.0 + 38.0i", z4.toString());
    }
     @Test
    public void testaajakolasku(){
        Kompleksiluku z3 = z1.jaettuna(z2);
        assertEquals("0.44 + 0.07999999999999999i", z3.toString());    
    }
     @Test
    public void testaakonjukaatti(){
        Kompleksiluku z3 = z1.kompleksikonjukaatti();
        Kompleksiluku z4 = z2.kompleksikonjukaatti();
        assertEquals("3.0 - 4.0i", z4.toString());
        assertEquals("1.0 - 2.0i", z3.toString());    
    }
     @Test
    public void testaakaanteisalkio(){
        Kompleksiluku z3 = z1.kaanteisalkio();
        Kompleksiluku z4 = z2.kaanteisalkio();
        assertEquals("0.2 - 0.4i", z3.toString());
        assertEquals("0.12 - 0.16i", z4.toString());    
    }
    @Test
    public void testaaexp(){
        Kompleksiluku z3 = z1.exp();
        Kompleksiluku z4 = z2.exp();
        
        assertEquals("-1.1312043837568135 + 2.4717266720048188i", z3.toString());
        assertEquals("-13.128783081462158 - 15.200784463067954i", z4.toString()); 
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

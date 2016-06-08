/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import mathOperations.Kompleksiluku;
import mathOperations.Matriisi;
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
public class MatriisiTest {
    
    
    private Matriisi A;
    private Matriisi B;
    private Matriisi C;
    
    public MatriisiTest() {

    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        A = new Matriisi(5,1);
        B = new Matriisi(8,8,1);
        Kompleksiluku [][] zz = new Kompleksiluku[4][4];
        for (int i = 0; i < zz.length; i++) {
            for (int j = 0; j < zz.length; j++) {
                 zz[j][i] = new Kompleksiluku(i+j,0);               
            }  
        }
        C = new Matriisi(zz);
    }
    @Test
    public void sijoitaTest(){
        A.sijoita(new Kompleksiluku(1,2), 1, 0);
        assertEquals("1.0 + 2.0i", A.poimi(1, 0).toString());
    }
    @Test
    public void poimiTest(){
        assertEquals("0", C.poimi(0, 0).toString());
        double i = Math.ceil(B.poimi(4, 4).getRe());
        assertEquals(1, (int)i);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

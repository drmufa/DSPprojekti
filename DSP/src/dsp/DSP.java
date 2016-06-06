/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsp;

import dsp.mathOperations.Kompleksiluku;
import dsp.mathOperations.Matriisi;
import javax.swing.SwingUtilities;
import kayttoliittyma.Kayttoliittyma;

/**
 *
 * @author jajnousi
 */
public class DSP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Kompleksiluku z1 = new Kompleksiluku(2,5);
        Kompleksiluku z2 = new Kompleksiluku(4,6);/// TODO code application logic here
        Matriisi A = new Matriisi(3,1);
        //Matriisi B = A.muunna(A);
        for (int i = 0; i < A.getN(); i++) {
            Kompleksiluku k = new Kompleksiluku(i+1,0);
            A.sijoita(k, i, 0);
        }
        System.out.println(A.max());
        System.out.println(z1.exp());
        System.out.println(A);
        System.out.println(A.FFT());
        
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
        kayttoliittyma.setMat(A);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
    
}

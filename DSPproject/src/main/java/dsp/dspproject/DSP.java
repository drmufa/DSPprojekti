/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsp.dspproject;

import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import dsp.math.Kompleksiluku;
import dsp.math.Matriisi;
import org.math.plot.Plot2DPanel;
import org.math.plot.PlotPanel;

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
        Matriisi A = new Matriisi(8168,1,1);
        //Matriisi B = A.muunna(A);
        /*for (int i = 0; i < A.getN(); i++) {
            double a = new Random().nextDouble();
            if(i<16){
                a = 1;
            }
            else if(32<=i && i<64){
                a = 1;
            }
            else if(96 <=i && i< 112){
                a = 1;
            }
            else if(128<=i && i<144){
                a = 1;
            }else {
                a =0;
            }
            Kompleksiluku k = new Kompleksiluku(a,0);
            A.sijoita(k, i, 0);
        }
        A = new Matriisi(4,1);
        for (int i = 0; i < 4; i++) {
            A.sijoita(new Kompleksiluku(i,0), i, 0);          
        }*/
        //System.out.println(A.max());
        //System.out.println(z1.exp());
        //System.out.println(A);
        //System.out.println(A.FFT());
        
        long aikaAlussa = System.currentTimeMillis(); 
        Matriisi B = A.FFT();
        long aikaLopussa = System.currentTimeMillis(); 
        System.out.println("Operaatioon kului aikaa: " + (aikaLopussa - aikaAlussa) + "ms."); 
        
        //Matriisi B = A;
        //B = B.IFFTpower2(B);
        
        //System.out.println(B);
        
        //Kuvaaja kuvaaja = new Kuvaaja();
        //kuvaaja.plottaa(B);
        
        
    }
}

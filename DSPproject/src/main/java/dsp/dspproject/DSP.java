/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsp.dspproject;

import dsp.math.Kompleksiluku;
import dsp.math.Matriisi;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
        Scanner lukija = new Scanner(System.in);
        
        //luo tarvittavat matriisit
        Matriisi matriisi = new Matriisi(1,1,1);
        Matriisi muunnos = new Matriisi(1,1,1);
        Matriisi high = new Matriisi(1,1,1);
        Matriisi low = new Matriisi(1,1,1);
        
        //luo esimerkki matriisit
        Matriisi A = new Matriisi(256,1);
        Matriisi B = new Matriisi(256,1);
        Matriisi C = new Matriisi(256,1);
        Matriisi D = new Matriisi(16,1);
        Matriisi E = new Matriisi(16,1);
        Matriisi F = new Matriisi(16,1);
        
        //luo Kuvajaa ja filtterit
        Kuvaaja kuvaaja = new Kuvaaja();
        LowPassFilter lf = new LowPassFilter();
        HighPassFilter hf = new HighPassFilter();
        EsimerkkiVektori ev = new  EsimerkkiVektori();
        A = ev.teeMuoto(A);
        D = ev.teeMuoto2(D);
       // kuvaaja.plottaa(D);
        
       

        System.out.println("Hello");
        System.out.println("komennot: <exit> <vektori> <plot> <FFT> <IFFT> <lowpass> <highpass>");
       
        while(true){
            System.out.println("Anna komento:");
            String komento = lukija.nextLine(); 
            
            if(komento.equals("exit")){
                break;
            }
            else if(komento.equals("vektori")){
                System.out.print("pituus:");
                int l = 1;
                try{
                l = Integer.parseInt(lukija.nextLine());
                }catch(Exception e){
                    System.out.println("anna kokonaisluku");
                }
                matriisi = new Matriisi(l,1,1);
                muunnos = matriisi;
                
            }
            else if(komento.equals("plot")){
                 kuvaaja.plottaa(matriisi);
            }else if(komento.equals("FFT")){
                muunnos = matriisi.FFT();
                kuvaaja.plottaa(muunnos);
            }else if(komento.equals("IFFT")){
                matriisi = muunnos.IFFTpower2(muunnos);
                kuvaaja.plottaa(matriisi);
            }else if(komento.equals("esim")){
                kuvaaja.plottaa(A);
                B = lf.LowPass(A);
                C = hf.HighPass(A);
                kuvaaja.plottaa(B);
                kuvaaja.plottaa(C);
            }else if(komento.equals("lowpass")){
                kuvaaja.plottaa(matriisi);
                low = lf.LowPass(matriisi);
                kuvaaja.plottaa(low);
            }else if(komento.equals("highpass")){
                kuvaaja.plottaa(matriisi);
                high = hf.HighPass(matriisi);
                kuvaaja.plottaa(high);
            }else if(komento.equals("esim2")){
                kuvaaja.plottaa(D);
                E = lf.LowPass(D);
                F = hf.HighPass(D);
                kuvaaja.plottaa(E);
                kuvaaja.plottaa(F);  
            }else {
                System.out.println(">>");
            }
        }
        System.exit(0);
    }
}

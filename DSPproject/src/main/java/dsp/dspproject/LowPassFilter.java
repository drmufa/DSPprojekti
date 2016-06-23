/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsp.dspproject;

import dsp.math.Kompleksiluku;
import dsp.math.Matriisi;

/**
 *
 * @author jajnousi
 */
public class LowPassFilter {
    

    public LowPassFilter() {
    }
    /*
    metodi filtteröi annetun matriisin pienet taajudet pois
    */
    public Matriisi LowPass(Matriisi matriisi){
        
        matriisi = matriisi.FFT();
        int N = matriisi.getN();
        for (int i = N/4; i < 3*N/4; i++) {
            matriisi.sijoita(new Kompleksiluku(0,0), i, 0);          
        }
        
        return matriisi.IFFTpower2(matriisi);       
    }
}

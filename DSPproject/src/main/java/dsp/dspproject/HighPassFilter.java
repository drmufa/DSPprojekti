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
public class HighPassFilter {
    public HighPassFilter() {
    }
    /*
    metodi filtteröi annetun matriisin suuret taajudet pois
    */
    public Matriisi HighPass(Matriisi matriisi){
        
        matriisi = matriisi.FFT();
        int N = matriisi.getN();
        for (int i = 0; i < 3*N/4; i++) {
            matriisi.sijoita(new Kompleksiluku(0,matriisi.poimi(i, 0).getIm()), i, 0);          
        }
        
        return matriisi.IFFTpower2(matriisi);       
    }
}

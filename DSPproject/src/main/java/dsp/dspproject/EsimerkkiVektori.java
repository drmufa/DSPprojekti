/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsp.dspproject;

import dsp.math.Kompleksiluku;
import dsp.math.Matriisi;
import java.util.Random;

/**
 *
 * @author jajnousi
 */
public class EsimerkkiVektori {

    public EsimerkkiVektori() {
    }
    
    public Matriisi teeMuoto2(Matriisi A){
        for (int i = 0; i < A.getN(); i++) {
            
            double a = Math.cos(i*Math.PI/16);
            
            Kompleksiluku k = new Kompleksiluku(a,0);
            A.sijoita(k, i, 0);
            
        }
        for (int i = 0; i < A.getN(); i++) {
           if(i == 12 ){
                double a = 0.5;           
                Kompleksiluku k = new Kompleksiluku(a,0);
                A.sijoita(k, i, 0); 
                }
           if(i == 6){
                double a = 0.2;           
                Kompleksiluku k = new Kompleksiluku(a,0);
                A.sijoita(k, i, 0); 
            }
        
            }
        
        return A;        
    }
    public Matriisi teeMuoto(Matriisi A){
        for (int i = 0; i < A.getN(); i++) {
            double a = new Random().nextDouble();
            if(i<8){
                a = 20;
            }
            else if(16<=i && i<24){
                a = 20;
                
            }else if(32<=i && i<40){
                a = 20;
                
            }else if(48<=i && i<56){
                a = 20;
            }
            else if(64<=i && i<72){
                a = 20;
            }
            else if(80<=i && i<88){
                a = 20;               
            }
            else if(96<=i && i<104){
                a = 20;               
            }
            else if(112<=i && i<120){
                a = 20;               
            }
            else if(128<=i && i<136){
                a = 20;               
            }
            else if(144<=i && i<152){
                a = 20;               
            }
            else if(160<=i && i<168){
                a = 20;               
            }
            else if(176<=i && i<184){
                a = 20;               
            }
            else if(192<=i && i<200){
                a = 20;               
            }
            else if(208<=i && i<216){
                a = 20;               
            }
            else if(224<=i && i<232){
                a = 20;               
            }
            else if(240<=i && i<248){
                a = 20;               
            }
            else {
                a =0;
            }
            Kompleksiluku k = new Kompleksiluku(a,0);
            A.sijoita(k, i, 0);
        }
        for (int i = 0; i < A.getN(); i++) {

            Kompleksiluku k = new Kompleksiluku(i,0);
            //System.out.println(k);
            k = k.plus(A.poimi(i, 0));
            //System.out.println(k);
            A.sijoita(k, i, 0);
            
        }
        return A;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsp.mathOperations;

/**
 * Matriisi ja sen tarvittavat laskutoimitukset
 * @author jajnousi
 */
public class Matriisi {
    public Kompleksiluku[][] A;
    int x;
    int y;

    public Matriisi(Kompleksiluku[][] A) {
        this.A = A;
    }

    public Matriisi(int x, int y) {
        this.A = new Kompleksiluku[x][y];
        this.x = x;
        this.y = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = new Kompleksiluku(0,0);                
            }         
        }
    }

    @Override
    public String toString() {
      String string = "[";
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                
                if(j+1 == x && i+1 ==y) string = string + A[j][i];
                else if(j+1 == x) string = string + A[j][i]+";";
                else string = string + A[j][i]+" ";                
            }         
        }
        return string + "]";
    }
    
    
    
   
}

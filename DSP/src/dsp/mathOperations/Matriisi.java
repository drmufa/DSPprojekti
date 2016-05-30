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
    int N;
    int M;

    public Matriisi(Kompleksiluku[][] A) {
        this.A = A;
        this.N = A.length;
        this.M = 1;
    }

    public Matriisi(int x, int y) {
        this.A = new Kompleksiluku[x][y];
        this.N = x;
        this.M = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                A[i][j] = new Kompleksiluku(1,0);                
            }         
        }
    }
    /*
    sijoittaa luvun halutulle paikalle
    */
    public void sijoita(Kompleksiluku z, int x, int y){
        this.A[x][y]=z;
    }
    
    /*
    Poimii halutun luvun matriisista
    */
    public Kompleksiluku poimi(int x, int y){
        return this.A[x][y];
    }
    
    /*
    Algoritmi täyttää vektorit 2^n kokoisiksi ja suorittaa sitten nopean fourier muunnoksen
    */
    public Matriisi FFT(){
        Matriisi muunnettava = this.muunna();
        muunnettava = this.FFTpower2(muunnettava);
        return muunnettava;        
    }
    
    //FFT algoritmi toimii vektoreille jonka pituus on 2^n. Algoritmi on rekursiivinen, Hajoita ja hallitse  
    public Matriisi FFTpower2(Matriisi Matriisi){
        
        int x = Matriisi.getN();
        int y = Matriisi.getM();

        //Perus askel
        if(x == 1){
            return Matriisi;
        }
        // parillisuus jokaisella rekursiolla (myöhemmin oma metodi, joka muuntaa väärän kokoisen oikean kokoiseksi)
        if(x % 2 != 0 || y !=1){
            throw new RuntimeException(" N tai M väärän kokoinen");
        }
        
        Matriisi parillinen = new Matriisi(x/2, 1);
        Matriisi pariton = new Matriisi(x/2, 1);
              
        for (int i = 0; i < x/2; i++) {
          Kompleksiluku z1 = Matriisi.poimi(i*2, 0);
          Kompleksiluku z2 = Matriisi.poimi(i*2+1, 0);
          parillinen.sijoita(z1, i, 0);
          pariton.sijoita(z2, i, 0);
        }
        //System.out.println(parillinen);
        //System.out.println(pariton);
        
        Matriisi E = FFTpower2(parillinen);
        Matriisi O = FFTpower2(pariton);
        
        //System.out.println(E);
        //System.out.println(O);
        
        //Matriisien yhdistäminen fourier muunnokseksi
        
        Matriisi muunnos = new Matriisi(x,y);
        
        for (int k = 0; k < x/2; k++) {
            //2*Pi*j/N
            double kpN = -2*Math.PI*k/x;
            Kompleksiluku Wk = new Kompleksiluku(0,kpN).exp();
            
            Kompleksiluku muunnosk = E.poimi(k, 0).plus(O.poimi(k, 0).kertaa(Wk));
            Kompleksiluku muunnosk2 = E.poimi(k, 0).miinus(O.poimi(k, 0).kertaa(Wk));
            
            //System.out.println(muunnosk);
            //System.out.println(muunnosk2);
            
            muunnos.sijoita(muunnosk, k, 0);
            muunnos.sijoita(muunnosk2, k+x/2, 0);            
        }   
        return muunnos;    
    }
    
    // Matriisi muunnetaan kaksikantaiseksi lisäämällä nollia tarvittava maara
    public Matriisi muunna(){
        int x = Math.max(this.N, this.M);
        double y = Math.log(x)/Math.log(2);    
        
        // jos kaksikantainen
        if(y%1 == 0){
            return this;
        }
        
        y = Math.pow(2,Math.ceil(Math.log(x)/Math.log(2)));
        Kompleksiluku[][] uusi = new Kompleksiluku[(int)y][1]; 
        
        for (int i = 0; i < x; i++) {
            uusi[i][0] = this.poimi(i, 0);
        }
        for (int i = x; i < y; i++) {
            uusi[i][0] = new Kompleksiluku(0,0);
        }
        //this.A = uusi;
        //B.setA(uusi);
        System.out.println(new Matriisi(uusi));
        return new Matriisi(uusi);        
    }

    public int getN() {
        return N;
    }

    public int getM() {
        return M;
    }

    public Kompleksiluku[][] getA() {
        return A;
    }

    public void setA(Kompleksiluku[][] A) {
        this.A = A;
    }
    

    @Override
    public String toString() {
      String string = "[";
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                
                if(j+1 == N && i+1 ==M) string = string + A[j][i];
                else if(j+1 == N) string = string + A[j][i]+";";
                else string = string + A[j][i]+" ";                
            }         
        }
        return string + "]";
    }
    
    
    
   
}

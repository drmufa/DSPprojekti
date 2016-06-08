/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mathOperations;

/**
 *
 * @author jajnousi
 * 
 * Luokassa määritellään kompleksiluvut ja tarvittavat laskutoimutukset niille.
 * 
 */

public class Kompleksiluku {
    private final double re;
    private final double im;

    public Kompleksiluku(double re, double im) {
        this.re = re;
        this.im = im;
    }
    public Kompleksiluku kertaa(Kompleksiluku c2){
        Kompleksiluku c1 = this;
        double real = c2.getRe()*c1.getRe()-c1.getIm()*c2.getIm();
        double imag = c1.getIm()*c2.getRe()+c1.getRe()*c2.getIm();
        
        return new Kompleksiluku(real, imag);
    }
    
    public Kompleksiluku jaettuna(Kompleksiluku c2){ 
        return this.kertaa(c2.kaanteisalkio());
    }
    
    public Kompleksiluku plus(Kompleksiluku c2){
        Kompleksiluku c1 = this;
        double real = c2.getRe()+c1.getRe();
        double imag = c2.getIm()+c1.getIm();
        return new Kompleksiluku(real, imag);
    }
    
    public Kompleksiluku miinus(Kompleksiluku c2){
        Kompleksiluku c1 = this;
        double real = c1.getRe()-c2.getRe();
        double imag = c1.getIm()-c2.getIm();
        return new Kompleksiluku(real, imag);
    }
    
    public Kompleksiluku kompleksikonjukaatti(){       
        return new Kompleksiluku(this.getRe(), -this.getIm());
    }
    
    public Kompleksiluku kaanteisalkio(){
        double nimittaja = re*re + im*im;
        return new Kompleksiluku(re/nimittaja, -im/nimittaja);
    }
    // e potenssiin alkio 
    public Kompleksiluku exp(){
        return new Kompleksiluku(Math.exp(re)*Math.cos(im), 
                Math.exp(re)*Math.sin(im));
    }
            
    public double getIm() {
        return im;
    }

    public double getRe() {
        return re;
    }

    @Override
    public String toString() {
        if (im <  0) return re + " - " + (-im) + "i";
        if (im == 0 && re == 0) return "0";
        if (re == 0) return im + "i";
        if (im == 0) return re + "";
        return re + " + " + im + "i";
    }
}

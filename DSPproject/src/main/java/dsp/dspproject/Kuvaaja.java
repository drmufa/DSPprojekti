/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dsp.dspproject;

import javax.swing.JFrame;
import dsp.math.Matriisi;
import org.math.plot.Plot2DPanel;

/**
 * Luokka piirtää vektorista kuvaajan käyttämällä jmathplot-kirjastoa:
 * jmathplot/dist/jmathplot.jar
 * https://github.com/yannrichet/jmathplot/blob/master/dist/jmathplot.jar
 * 
 * @author jajnousi
 */
public class Kuvaaja {

    public Kuvaaja() {
    }
    
    public void plottaa(Matriisi M){
        double[] x = new double[M.getN()];
        double[] y = new double[M.getN()];
        
        for (int i = 0; i < M.getN(); i++) {
            y[i] = M.poimi(i, 0).getRe();
            x[i] = i;
        }

        // create your PlotPanel (you can use it as a JPanel)
        Plot2DPanel plot = new Plot2DPanel();

        // add a line plot to the PlotPanel
        plot.addLinePlot("my plot", x, y);

        // put the PlotPanel in a JFrame, as a JPanel
        JFrame frame = new JFrame("a plot panel");
        frame.setContentPane(plot);
        frame.setVisible(true);
    }
}    


package kayttoliittyma;

import dsp.mathOperations.Matriisi;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Matriisi mat;

    public Kayttoliittyma() {
    }

    public void setMat(Matriisi mat) {
        this.mat = mat;
    }

    
    @Override
    public void run() {
        frame = new JFrame("DSPprojekti");
        frame.setPreferredSize(new Dimension(1000, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container container) {
         container.add(new Piirtoalusta(mat));

    }

    public JFrame getFrame() {
        return frame;
    }
}


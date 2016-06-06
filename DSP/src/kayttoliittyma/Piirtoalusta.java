package kayttoliittyma;


import dsp.mathOperations.Matriisi;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Piirtoalusta extends JPanel {
    private Matriisi mat;
    private double scale;
    private double valit;
    

    public Piirtoalusta(Matriisi mat) {
        this.mat = mat;
        this.scale = 256/mat.max();
        this.valit = 800/mat.getN();
        super.setBackground(Color.WHITE);
        
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        //koordinaatit
        graphics.setColor(Color.BLACK);
        graphics.fillRect(20, 20, 2, 320);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(20, 340, 900, 2);
        
        
        
    }
}

package PaSkCode;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class PSysView {
    
    PSysView() {
    }

    // draw all particles in psm
    void draw(PSysModel psm, Graphics g) {
        
        int pSize = psm.particleList.size();
        for(int i = 0; i < pSize; i++){
            PSysModel current = psm.particleList.get(i); 
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
                                      RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
            g2d.setColor(Color.RED);
            g2d.fillOval(current.getX() - current.getRadius(), 
                         current.getY() - current.getRadius(), 
                         current.getRadius()*2, 
                         current.getRadius()*2);
        }
    }

    // dump information on all particles in psm
    void dump(PSysModel psm, int lc) {
        if(lc==1000){
            System.out.println("Frame: 1000     [DUMP]");
            psm.printSysInfo();
        }
    }
}

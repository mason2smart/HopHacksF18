package com.dcs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;

public class AddDrugPanel extends JPanel {
    BufferedImage defIMG;
    BufferedImage scaledDefIMG;
    BufferedImage activeIMG;
    BufferedImage scaledActiveIMG;
    JButton addDrug;

    public AddDrugPanel(double wScale, double hScale)
    {
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setOpaque(true);
        this.setAddIMG(wScale, hScale);
        this.add(addDrug);
        this.revalidate();
        this.repaint();

    }

    public void setAddIMG(double wScale, double hScale){
         try {
        defIMG  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("AddBtnDef.png"));
             activeIMG  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("AddBtn.png"));
             scaleIMG(wScale,hScale);
        addDrug = new JButton(new ImageIcon(scaledDefIMG));
        addDrug.setRolloverEnabled(true);
        addDrug.setRolloverIcon(new ImageIcon(scaledActiveIMG));
    } catch (IOException e) {
             System.out.println("Failed to load AddDrugIMG");
             e.printStackTrace();
    }
        addDrug.setBorder(BorderFactory.createEmptyBorder());
        addDrug.setContentAreaFilled(false);
    }
    public void scaleIMG(double wScale, double hScale){
            AffineTransform scaler = new AffineTransform();
            scaler.scale(wScale, wScale);
            AffineTransformOp scalerOp = new AffineTransformOp(scaler, AffineTransformOp.TYPE_BILINEAR);
            scaledDefIMG = scalerOp.filter(defIMG, scaledDefIMG);
            scaledActiveIMG = scalerOp.filter(activeIMG, scaledActiveIMG);
    }
}

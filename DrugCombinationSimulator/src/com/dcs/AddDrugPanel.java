package com.dcs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    Icon disabledICO;
    JButton addDrug;
    private static int paneID;
    JFrame SelectionPanel;
    public AddDrugPanel(int paneID, double wScale, double hScale)
    {
        this.paneID = paneID;
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setOpaque(true);
        this.setAddIMG(wScale, hScale);
        this.add(addDrug);
        this.addActionListeners();
        this.revalidate();
        this.repaint();
        disabledICO = addDrug.getDisabledIcon();
    }

    public void setAddIMG(double wScale, double hScale){
         try {
        defIMG  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("AddBtnDef.png"));
             activeIMG  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("AddBtn.png"));
             scaleIMG(wScale,hScale);
        addDrug = new JButton(new ImageIcon(scaledDefIMG));
        addDrug.setRolloverEnabled(true);
        addDrug.setRolloverIcon(new ImageIcon(scaledActiveIMG));//future set a transitional change
    } catch (IOException e) {
             System.out.println("Failed to load AddDrugIMG");
             e.printStackTrace();
    }
        addDrug.setBorder(BorderFactory.createEmptyBorder());
        addDrug.setContentAreaFilled(false);
    }
    public void scaleIMG(double wScale, double hScale){ //image scaling
            AffineTransform scaler = new AffineTransform();
            scaler.scale(wScale, wScale);
            AffineTransformOp scalerOp = new AffineTransformOp(scaler, AffineTransformOp.TYPE_BILINEAR);
            scaledDefIMG = scalerOp.filter(defIMG, scaledDefIMG);
            scaledActiveIMG = scalerOp.filter(activeIMG, scaledActiveIMG);
    }

    public void addActionListeners(){
        addDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //addDrug.setText("Select Drug");
                SelectionPanel = new SelectionPanel(paneID);
                DCS.mainFrame.DisableAddBtns();
                addDrug.setDisabledIcon(new ImageIcon(scaledActiveIMG));
            }
            });
    }
    public void resetDisabledIcon(){
        addDrug.setDisabledIcon(disabledICO);
    }

}

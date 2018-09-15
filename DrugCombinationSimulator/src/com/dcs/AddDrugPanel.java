package com.dcs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddDrugPanel extends JPanel {
    BufferedImage addIMG;
    JButton addDrug;
    public AddDrugPanel()
    {
       setAddIMG();
       this.add(addDrug);
       this.setVisible(true);

    }

    public void setAddIMG(){
         try {
        addIMG  = ImageIO.read(getClass().getClassLoader().getResourceAsStream("AddBtn.png"));
        addDrug = new JButton(new ImageIcon(addIMG));
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Failed to load AddDrugIMG");
    }
        addDrug.setBorder(BorderFactory.createEmptyBorder());
        //addDrug.setContentAreaFilled(false);
    }

}

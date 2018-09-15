package com.dcs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class AddDrugPanel extends JPanel {
    BufferedImage addIcon;
    JButton addDrug;
    public AddDrugPanel()
    {
        try {
            addIcon  = ImageIO.read(new File(""));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to load AddDrugIMG");
        }

        addDrug = new JButton(new ImageIcon(buttonIcon));

    }

}

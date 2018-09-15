package com.dcs;

import javax.swing.*;
import java.awt.*;

public class Framework extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //for scaling
    final double FrameWidthMulti = screenSize.getWidth() / 1920;//scaling
    final double FrameHeightMulti = screenSize.getHeight() / 1080;//scaling
    final int FrameWidth = (int) (1000 * FrameWidthMulti);
    final int FrameHeight = (int) (800 * FrameHeightMulti);
    Dimension windowSize;
    public Framework(){ //constructor -- initialize initial frame properties
        super("DCS");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //for now
            //ADD CLOSE CONFIRMATION HERE - WINDOW LISTENER
        windowSize = new Dimension(FrameWidth, FrameHeight);
        this.setSize(windowSize);
        this.setPreferredSize(windowSize);
        this.setResizable(false);
    }

}

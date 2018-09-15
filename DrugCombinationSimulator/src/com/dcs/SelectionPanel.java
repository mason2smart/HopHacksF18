package com.dcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SelectionPanel extends JFrame {
    private int paneID;
    Dimension windowSize;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //for scaling
    final double FrameWidthMulti = screenSize.getWidth() / 1920;//scaling
    final double FrameHeightMulti = screenSize.getHeight() / 1080;//scaling
    final int FrameWidth = (int) (400 * FrameWidthMulti);
    final int FrameHeight = (int) (800 * FrameHeightMulti);


    public SelectionPanel(int paneID){
       this.setLocation((int)(screenSize.width-1000*FrameWidthMulti), 0);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //for now
       //ADD CLOSE CONFIRMATION HERE - WINDOW LISTENER
       windowSize = new Dimension(FrameWidth, FrameHeight);
       this.setSize(windowSize);
       this.setPreferredSize(windowSize);
       this.setResizable(false);
       this.setLookandFeel();
       this.setVisible(true); //visibility
       this.setLayout(new GridLayout(2,1));
       System.out.println(this.toString());
   }


    public void setLookandFeel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("ERR: fail to set look and feel");
        }
    }
}

package com.dcs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Framework extends JFrame {
    ArrayList<JPanel> Panels;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //for scaling
    final double FrameWidthMulti = screenSize.getWidth() / 1920;//scaling
    final double FrameHeightMulti = screenSize.getHeight() / 1080;//scaling
    final int FrameWidth = (int) (1000 * FrameWidthMulti);
    final int FrameHeight = (int) (800 * FrameHeightMulti);
    Dimension windowSize;

    public Framework(){ //constructor -- initialize initial frame properties
        super("DCS");//must be first sets title
        Panels = new ArrayList();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //for now
            //ADD CLOSE CONFIRMATION HERE - WINDOW LISTENER
        windowSize = new Dimension(FrameWidth, FrameHeight);
        this.setSize(windowSize);
        this.setPreferredSize(windowSize);
        this.setResizable(false);
        this.setLookandFeel();
        this.setVisible(true); //visibility

        this.addGenericPanel();
        this.updateFrame();
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
    public void addGenericPanel(){
        Panels.add(new AddDrugPanel());
    }
    public void updateFrame(){
        this.removeAll();
        for(JPanel i:Panels){
            this.add(i);
            this.pack();
        }
    }


}

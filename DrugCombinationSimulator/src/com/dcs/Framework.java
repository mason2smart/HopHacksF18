package com.dcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class Framework extends JFrame {
    static ArrayList<JPanel> Panels;
    static ArrayList<Drug> DrugList;
    static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //for scaling
    static final double FrameWidthMulti = screenSize.getWidth() / 1920;//scaling
    final double FrameHeightMulti = screenSize.getHeight() / 1080;//scaling
    final int FrameWidth = (int) (1000 * FrameWidthMulti);
    final int FrameHeight = (int) (1000 * FrameHeightMulti);
    Dimension windowSize;

    public Framework(){ //constructor -- initialize initial frame properties
        super("DCS");//must be first sets title
        Panels = new ArrayList();
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //for now
        WindowListener exitListener = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirm = 0;
                    confirm = JOptionPane.showOptionDialog(
                            null, "Are You Sure You Wish To Quit?",
                            "Exit Now?", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getClassLoader().getResource("gifSmall.gif")), null, null);
                if (confirm == 0) {
                    System.exit(0);
                }}};this.addWindowListener(exitListener);
        windowSize = new Dimension(FrameWidth, FrameHeight);
        this.setSize(windowSize);
        this.setPreferredSize(windowSize);
        this.setResizable(false);
        this.setLookandFeel();
        this.setVisible(true); //visibility
        this.addGenericPanels();
        this.setLayout(new GridLayout(2,3));
        this.updateFrame();
        //System.out.println(this.toString());
        //System.out.println(this.Panels.isEmpty());
        //System.out.println(this.Panels.get(0).toString());
        DrugList = Backend.getDrugs(); //get drugs from file

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
    public void addGenericPanels(){
        int maxDrugs = 6;
        for(int drug = 0; drug<maxDrugs; drug++) {
            Panels.add(new AddDrugPanel(drug, FrameWidthMulti / 3, FrameHeightMulti / 2));
            this.add(Panels.get(drug),drug);
        }
                }
    public void updateFrame(){
        for(JPanel i:Panels) {
            //  i.setSize(this.windowSize.width / Panels.size(), this.windowSize.height/Panels.size());
            i.revalidate();
            i.repaint();
        }
        this.repaint();
        this.revalidate();
    }
    public void DisableAddBtns(){
        for (JPanel i:Panels){
            if (i instanceof  AddDrugPanel){
                ((AddDrugPanel)i).addDrug.setEnabled(false);
            }
        }
    }
    public void EnableAddBtns(){
        for (JPanel i:Panels){
            if (i instanceof  AddDrugPanel){
                ((AddDrugPanel)i).addDrug.setEnabled(true);
            }
        }
    }
    public void setDrugPanel(int paneID, Drug newDrug) {
        EnableAddBtns();
        for (JPanel i : Panels) {
            if (i instanceof AddDrugPanel) {
                ((AddDrugPanel) (i)).resetDisabledIcon();
                System.out.println(((AddDrugPanel)(i)).paneID);

            }
        }
            newDrug.changeActive();
        System.out.println(paneID);
        for (int i=0; i<Panels.size();i++)
        {
            if (Panels.get(i) instanceof AddDrugPanel){
                if (((AddDrugPanel)(Panels.get(i))).paneID==paneID)
                {
                    this.remove(Panels.get(i));
                }
        }
        }
        Panels.set(paneID, new DrugPanel(paneID, newDrug));
        this.add(Panels.get(paneID),paneID);
            System.out.println(Framework.Panels.get(paneID).toString());
            for (Drug i:DrugList){
              System.out.println(i.isActive());
            }
    }
    public void removeDrugPanel(int paneID, Drug newDrug) {
      /*  for (JPanel i : Panels) {
            if (i instanceof DrugPanel) {
            System.out.println(((AddDrugPanel)(i)).paneID);
        }
    }*/
        newDrug.changeActive();
        System.out.println(paneID);
        for (int i=0; i<Panels.size();i++)
        {
            if (Panels.get(i) instanceof DrugPanel){
                if (((DrugPanel)(Panels.get(i))).paneID==paneID)
                {
                    this.remove(Panels.get(i));
                }
            }
        }
        Panels.set(paneID, new AddDrugPanel(paneID, FrameWidthMulti / 3, FrameHeightMulti / 2));
        this.add(Panels.get(paneID),paneID);
        this.validate();
        this.pack();
        this.repaint();
        System.out.println(Framework.Panels.get(paneID).toString());
        for (Drug i:DrugList){
            System.out.println(i.isActive());
        }
    }
}


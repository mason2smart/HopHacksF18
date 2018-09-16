package com.dcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
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
    JPanel selectionPanel;
    JComboBox<String> selectionBox;
    //JList drugList;
 //   private DefaultListModel drugModel;

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
       selectionPanel = new JPanel();
      // createDrugList();
     //  selectionPanel.add(drugList);
        createSelectionBox();
        selectionPanel.add(selectionBox);
       this.add(selectionPanel);
       this.pack();
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

    private void createSelectionBox(){
        selectionBox = new JComboBox<String>();
        for(Drug i:Framework.DrugList) {
            if (!i.isActive()) {
                System.out.println(i.getName());
                selectionBox.addItem(i.getName());
            }

        }
            selectionBox.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e){
                   JComboBox cb = (JComboBox) e.getSource();
                     String selectedItem = (String) cb.getSelectedItem();
                  }
                });
            }


  /*  private void createDrugList()
    {
     drugList = new JList();
     drugModel = new DefaultListModel();
     for(Drug i:Framework.DrugList){
         if (!i.isActive()){
             drugModel.addElement(i);
         }
    }//end for
        drugList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        drugList.setSelectedIndex(0);
        drugList.setVisibleRowCount(6);
        JScrollPane listScrollPane = new JScrollPane(drugList);
       // Drug selection = (Drug)(drugModel.getElementAt(
         //       drugList.getSelectedIndex()));


    }*/

}
package com.dcs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugPanel extends JPanel {
    private final Drug thisDrug;
    JPanel infoPanel;
    JPanel buttonPanel;
    JLabel dosageIN;
    JLabel factorAffIn;
    JLabel factorUnIn;
    JLabel drugName;
    JLabel dosageMed;
    JButton removeDrug;

    int paneID;
    public DrugPanel(int paneID, Drug selectDrug){
        this.paneID=paneID;
        thisDrug = selectDrug;//set drug
        infoPanel = new JPanel();
        buttonPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5,0));
        this.add(infoPanel);
        this.add(buttonPanel);
        initJLabels();
        showInfo();
        initButtons();
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public Drug getDrug() {
        return thisDrug;
                //dose
                //medium effect dose
                //

    }


    public void initJLabels(){
        drugName = new JLabel();
        dosageIN = new JLabel();
        factorAffIn = new JLabel();
        factorUnIn = new JLabel();
        dosageMed = new JLabel();
        infoPanel.add(drugName);
        infoPanel.add(dosageIN);
        infoPanel.add(factorAffIn);
        infoPanel.add(factorUnIn);
        infoPanel.add(dosageMed);

    }

    public void showInfo(){
                drugName.setText(thisDrug.getName());
                dosageIN.setText("Dosage: "+String.valueOf(thisDrug.getDosage()));
                factorAffIn.setText("Factor Aff: "+String.valueOf(thisDrug.getFactorAff()));
                factorUnIn.setText("Factor Un: "+String.valueOf(thisDrug.getFactorUn()));
                dosageMed.setText("Dosage Med: "+String.valueOf(thisDrug.dosageMed()));
                Font aFont = dosageIN.getFont().deriveFont(0,(int)(18*DCS.mainFrame.FrameWidthMulti));
                Font bigFont = dosageIN.getFont().deriveFont(1,(int)(22*DCS.mainFrame.FrameWidthMulti));
                drugName.setFont(bigFont);
                dosageIN.setFont(aFont);
                factorUnIn.setFont(aFont);
                factorAffIn.setFont(aFont);
                dosageMed.setFont(aFont);
                drugName.setHorizontalAlignment(SwingConstants.CENTER);
                dosageIN.setHorizontalAlignment(SwingConstants.CENTER);
                factorAffIn.setHorizontalAlignment(SwingConstants.CENTER);
                factorUnIn.setHorizontalAlignment(SwingConstants.CENTER);
                dosageMed.setHorizontalAlignment(SwingConstants.CENTER);
            }

           public void initButtons(){
                removeDrug = new JButton();
                buttonPanel.add(removeDrug);
                removeDrug.setText("Remove Drug");
                Font bigFont = dosageIN.getFont().deriveFont(0,(int)(22*DCS.mainFrame.FrameWidthMulti));
                removeDrug.setFont(bigFont);

                removeDrug.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DCS.mainFrame.removeDrugPanel(paneID, thisDrug);
                    }
                });

           }
    }


package com.dcs;

import javax.swing.*;
import java.awt.*;

public class DrugPanel extends JPanel {
    private final Drug thisDrug;
    JPanel infoPanel;
    JLabel dosageIN;
    JLabel factorAffIn;
    JLabel factorUnIn;
    int paneID;
    public DrugPanel(int paneID, Drug selectDrug){
        this.paneID=paneID;
        thisDrug = selectDrug;//set drug
        infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3,1));
        this.add(infoPanel);
        initJLabels();
        showInfo();
        this.setVisible(true);
        this.revalidate();
        this.repaint();
        super.repaint();
        super.revalidate();
    }

    public Drug getDrug() {
        return thisDrug;
                //dose
                //medium effect dose
                //

    }


    public void initJLabels(){
        dosageIN = new JLabel();
        factorAffIn = new JLabel();
        factorUnIn = new JLabel();
        infoPanel.add(dosageIN);
        infoPanel.add(factorAffIn);
        infoPanel.add(factorUnIn);

    }

    public void showInfo(){
                dosageIN.setText("Dosage: "+String.valueOf(thisDrug.getDosage()));
                factorAffIn.setText("Factor Aff: "+String.valueOf(thisDrug.getFactorAff()));
                factorUnIn.setText("Factor Un: "+String.valueOf(thisDrug.getFactorUn()));
                Font aFont = dosageIN.getFont().deriveFont(0,(int)(20*DCS.mainFrame.FrameWidthMulti));
                dosageIN.setFont(aFont);
                factorUnIn.setFont(aFont);
                factorAffIn.setFont(aFont);
            }
    }


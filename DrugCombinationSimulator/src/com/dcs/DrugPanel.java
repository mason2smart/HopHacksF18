package com.dcs;

import javax.swing.*;

public class DrugPanel extends JPanel {
    private final Drug thisDrug;
    public DrugPanel(Drug selectDrug){
        thisDrug = selectDrug;//set drug
    }

    public Drug getDrug() {
        return thisDrug;
    }
}

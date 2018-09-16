package com.dcs;

import javax.swing.*;
import java.awt.*;

public class DCS {
    public static Framework mainFrame;
    public static void main(String[] args) {
        mainFrame = new Framework();
    }
    public JFrame getFrame(){
        return mainFrame;
    }
}

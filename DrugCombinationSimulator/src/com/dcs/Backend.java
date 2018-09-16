package com.dcs;
import com.sun.org.apache.bcel.internal.util.ClassPath;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Backend {

    public static ArrayList<Drug> getDrugs() {
        ArrayList<Drug> drugArr = new ArrayList();
        try {
            InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("drug_data.txt");
            String currentDrug = "";
            Scanner scannie = new Scanner(inputStream);

            while(scannie.hasNextLine()) {
                currentDrug = scannie.nextLine();
                String[] textArr = currentDrug.split(" ");
                Drug newDrug = new Drug(textArr[0], parseDouble(textArr[1]), parseDouble(textArr[2]), parseDouble(textArr[3]));
                drugArr.add(newDrug);
            }
            scannie.close();
            return drugArr;

        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("File I/O Error");
        }
        return null;
    }
    static double parseDouble(String ratio) {
        if (ratio.contains("/")) {
            String[] rat = ratio.split("/");
            return Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]);
        } else {
            return Double.parseDouble(ratio);
        }
    }
}

package com.dcs;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Backend {

    public ArrayList<Drug> getDrugs() {
        ArrayList<Drug> drugArr = new ArrayList<Drug>();
        try {
            BufferedReader input = new BufferedReader( new FileReader("drug_data.txt"));
            String currentDrug;
            while ((currentDrug = input.readLine()) != null) {
                String[] textArr = currentDrug.split(" ");
                Drug newDrug = new Drug(textArr[0], Double.parseDouble(textArr[1]), Double.parseDouble(textArr[2]), Double.parseDouble(textArr[3]));
                drugArr.add(newDrug);
            }
            return drugArr;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("File I/O Error");
        }
        return null;
    }
}

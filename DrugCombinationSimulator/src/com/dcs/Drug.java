package com.dcs;

public class Drug {
    private String name;
    private float dosage;
    private float dosageMed;

    public Drug(String nameIn, float dosageIn, float dosageMedIn) {
        name = nameIn;
        dosage = dosageIn;
        dosageMed = dosageMedIn;
    }

    public String getName(){
        return name;
    }
    public float getDosage(){
        return dosage;
    }
    public float getDosageMed(){
        return dosageMed;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public void setDosage(float dosageIn) {
        dosage = dosageIn;
    }

    public void setDosageMed(float dosageMedIn) {
        dosageMed = dosageMedIn;
    }
}

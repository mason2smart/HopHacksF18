package com.dcs;

public class Drug {
    private String name;
    private double dosage;
    private double factorAff;
    private double factorUn;

    public Drug(String nameIn, double dosageIn, double factorAffIn, double factorUnIn) {
        name = nameIn;
        dosage = dosageIn;
        factorAff = factorAffIn;
        factorUn = factorUnIn;
    }

    public String getName(){
        return name;
    }
    public double getDosage(){
        return dosage;
    }
    public double getFactorAff(){
        return factorAff;
    }

    public double getFactorUn() {
        return factorUn;
    }

    public void setName(String nameIn) {
        name = nameIn;
    }

    public void setDosage(double dosageIn) {
        dosage = dosageIn;
    }

    public void setfactorAff(double factorAffIn) {
        factorAff = factorAffIn;
    }

    public void setFactorUn(double factorUnIn) {
        factorUn = factorUnIn;
    }

    public double DosageMed() {
        return Math.pow(factorAff, 2)/Math.pow(factorUn, 2) * dosage;
    }
}

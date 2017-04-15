package com.example.helloworld.firstaid;

/**
 * Created by Tanvir Hemel on 04-Apr-17.
 */

public class medicines{
    String id,symptom,medicine,provider;

    public medicines(String id, String symptom, String medicine, String provider) {
        this.id = id;
        this.symptom = symptom;
        this.medicine = medicine;
        this.provider = provider;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}


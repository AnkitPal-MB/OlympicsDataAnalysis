package com.olympics.model;

public class NocRegion {

    private String noc;
    private String region;
    private String notes;


    public String getNoc() {
        return noc;
    }

    public void setNoc(String noc) {
        this.noc = noc;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "NocRegion{" +
                "noc='" + noc + '\'' +
                ", region='" + region + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
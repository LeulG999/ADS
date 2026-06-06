package edu.miu.model;

public class Surgery {
    private String surgeryId;
    private String name;
    private String locationAddress;
    private String telephoneNumber;

    public Surgery() {
    }

    public Surgery(String surgeryId, String name, String locationAddress, String telephoneNumber) {
        this.surgeryId = surgeryId;
        this.name = name;
        this.locationAddress = locationAddress;
        this.telephoneNumber = telephoneNumber;
    }

    public String getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(String surgeryId) {
        this.surgeryId = surgeryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Surgery{" +
                "surgeryId='" + surgeryId + '\'' +
                ", name='" + name + '\'' +
                ", locationAddress='" + locationAddress + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}

package edu.miu.model;

public class Dentist {
    private String dentistId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;

    public Dentist() {
    }

    public Dentist(String dentistId, String firstName, String lastName, String phoneNumber, String email) {
        this.dentistId = dentistId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getDentistId() {
        return dentistId;
    }

    public void setDentistId(String dentistId) {
        this.dentistId = dentistId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "dentistId='" + dentistId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

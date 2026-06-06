package edu.miu.model;

import java.time.LocalDateTime;

public class Appointment {
    private String appointmentId;
    private Patient patient;
    private Dentist dentist;
    private Surgery surgery;
    private String dentalService;
    private LocalDateTime appointmentDateTime;
    private LocalDateTime bookingDateTime;
    private String status;

    public Appointment() {
    }

    public Appointment(String appointmentId, Patient patient, Dentist dentist, Surgery surgery,
                       String dentalService, LocalDateTime appointmentDateTime,
                       LocalDateTime bookingDateTime, String status) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.dentist = dentist;
        this.surgery = surgery;
        this.dentalService = dentalService;
        this.appointmentDateTime = appointmentDateTime;
        this.bookingDateTime = bookingDateTime;
        this.status = status;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public String getDentalService() {
        return dentalService;
    }

    public void setDentalService(String dentalService) {
        this.dentalService = dentalService;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public LocalDateTime getBookingDateTime() {
        return bookingDateTime;
    }

    public void setBookingDateTime(LocalDateTime bookingDateTime) {
        this.bookingDateTime = bookingDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId='" + appointmentId + '\'' +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", surgery=" + surgery +
                ", dentalService='" + dentalService + '\'' +
                ", appointmentDateTime=" + appointmentDateTime +
                ", bookingDateTime=" + bookingDateTime +
                ", status='" + status + '\'' +
                '}';
    }
}

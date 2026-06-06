package edu.miu.repository;

import edu.miu.model.Appointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    private final List<Appointment> appointments;

    public AppointmentRepository(List<Appointment> appointments) {
        this.appointments = new ArrayList<>(appointments);
    }

    public List<Appointment> findAll() {
        return new ArrayList<>(appointments);
    }
}

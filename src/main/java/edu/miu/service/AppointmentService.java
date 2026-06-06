package edu.miu.service;

import edu.miu.model.Appointment;
import edu.miu.repository.AppointmentRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> getAllAppointmentsSortedDescending() {
        return appointmentRepository.findAll()
                .stream()
                .sorted((first, second) -> compareDescending(
                        first.getAppointmentDateTime(),
                        second.getAppointmentDateTime()))
                .collect(Collectors.toList());
    }

    public List<Appointment> getQuarterlyUpcomingAppointments(LocalDate currentDate) {
        LocalDate quarterStart = getNextQuarterStart(currentDate);
        LocalDate quarterEnd = quarterStart.plusMonths(3);

        return appointmentRepository.findAll()
                .stream()
                .filter(appointment -> isBookingDateInRange(
                        appointment.getBookingDateTime(),
                        quarterStart,
                        quarterEnd))
                .sorted((first, second) -> compareDescending(
                        first.getBookingDateTime(),
                        second.getBookingDateTime()))
                .collect(Collectors.toList());
    }

    private LocalDate getNextQuarterStart(LocalDate currentDate) {
        int currentQuarter = (currentDate.getMonthValue() - 1) / 3;
        int nextQuarterStartMonth = currentQuarter * 3 + 4;

        if (nextQuarterStartMonth > 12) {
            return LocalDate.of(currentDate.getYear() + 1, 1, 1);
        }

        return LocalDate.of(currentDate.getYear(), nextQuarterStartMonth, 1);
    }

    private boolean isBookingDateInRange(LocalDateTime bookingDateTime,
                                         LocalDate quarterStart,
                                         LocalDate quarterEnd) {
        if (bookingDateTime == null) {
            return false;
        }

        LocalDate bookingDate = bookingDateTime.toLocalDate();
        return !bookingDate.isBefore(quarterStart) && bookingDate.isBefore(quarterEnd);
    }

    private int compareDescending(LocalDateTime firstDateTime, LocalDateTime secondDateTime) {
        if (firstDateTime == null && secondDateTime == null) {
            return 0;
        }
        if (firstDateTime == null) {
            return 1;
        }
        if (secondDateTime == null) {
            return -1;
        }

        return secondDateTime.compareTo(firstDateTime);
    }
}

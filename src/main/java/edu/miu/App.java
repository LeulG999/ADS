package edu.miu;

import edu.miu.cli.AppointmentCli;
import edu.miu.model.Appointment;
import edu.miu.model.Dentist;
import edu.miu.model.Patient;
import edu.miu.model.Surgery;
import edu.miu.repository.AppointmentRepository;
import edu.miu.service.AppointmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AppointmentRepository appointmentRepository = new AppointmentRepository(createAppointmentData());
        AppointmentService appointmentService = new AppointmentService(appointmentRepository);
        AppointmentCli appointmentCli = new AppointmentCli(appointmentService);

        appointmentCli.start();
    }

    private static List<Appointment> createAppointmentData() {
        Patient patientOne = new Patient(
                "P001",
                "John",
                "Smith",
                "100 Main Street, Chicago, IL",
                "312-555-0101",
                "john.smith@example.com",
                LocalDate.of(1990, 5, 14));
        Patient patientTwo = new Patient(
                "P002",
                "Mary",
                "Johnson",
                "200 Oak Avenue, Dallas, TX",
                "214-555-0102",
                "mary.johnson@example.com",
                LocalDate.of(1985, 8, 22));
        Patient patientThree = new Patient(
                "P003",
                "Robert",
                "Brown",
                "300 Pine Road, Phoenix, AZ",
                "602-555-0103",
                "robert.brown@example.com",
                LocalDate.of(1978, 11, 3));

        Dentist dentistOne = new Dentist("D001", "Helen", "Carter", "312-555-0201", "helen.carter@ads.com");
        Dentist dentistTwo = new Dentist("D002", "James", "Wilson", "214-555-0202", "james.wilson@ads.com");

        Surgery surgeryOne = new Surgery("S001", "ADS Chicago", "500 Lake Shore Drive, Chicago, IL", "312-555-0301");
        Surgery surgeryTwo = new Surgery("S002", "ADS Dallas", "600 Elm Street, Dallas, TX", "214-555-0302");

        LocalDate nextQuarterStart = getNextQuarterStart(LocalDate.now());
        LocalDate currentQuarterDate = LocalDate.now().plusDays(10);

        return List.of(
                new Appointment(
                        "A001",
                        patientOne,
                        dentistOne,
                        surgeryOne,
                        "Dental Cleaning",
                        LocalDateTime.of(currentQuarterDate, LocalTime.of(9, 0)),
                        LocalDateTime.of(currentQuarterDate.minusDays(5), LocalTime.of(10, 15)),
                        "BOOKED"),
                new Appointment(
                        "A002",
                        patientTwo,
                        dentistTwo,
                        surgeryTwo,
                        "Root Canal",
                        LocalDateTime.of(nextQuarterStart.plusDays(14), LocalTime.of(11, 30)),
                        LocalDateTime.of(nextQuarterStart.plusDays(1), LocalTime.of(14, 0)),
                        "BOOKED"),
                new Appointment(
                        "A003",
                        patientThree,
                        dentistOne,
                        surgeryOne,
                        "Tooth Extraction",
                        LocalDateTime.of(nextQuarterStart.plusDays(30), LocalTime.of(15, 45)),
                        LocalDateTime.of(nextQuarterStart.plusDays(6), LocalTime.of(9, 30)),
                        "BOOKED"),
                new Appointment(
                        "A004",
                        patientOne,
                        dentistTwo,
                        surgeryTwo,
                        "Dental Filling",
                        LocalDateTime.of(nextQuarterStart.plusMonths(3).plusDays(5), LocalTime.of(13, 15)),
                        LocalDateTime.of(nextQuarterStart.plusMonths(3), LocalTime.of(8, 45)),
                        "BOOKED"));
    }

    private static LocalDate getNextQuarterStart(LocalDate currentDate) {
        int currentQuarter = (currentDate.getMonthValue() - 1) / 3;
        int nextQuarterStartMonth = currentQuarter * 3 + 4;

        if (nextQuarterStartMonth > 12) {
            return LocalDate.of(currentDate.getYear() + 1, 1, 1);
        }

        return LocalDate.of(currentDate.getYear(), nextQuarterStartMonth, 1);
    }
}

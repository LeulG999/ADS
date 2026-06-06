package edu.miu.cli;

import edu.ads.util.JsonUtil;
import edu.miu.model.Appointment;
import edu.miu.service.AppointmentService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class AppointmentCli {
    private final AppointmentService appointmentService;
    private final Scanner scanner;

    public AppointmentCli(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    displayAllAppointments();
                    break;
                case "2":
                    displayQuarterlyUpcomingAppointments();
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting ADS application.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
                    break;
            }
        }
    }

    private void displayAllAppointments() {
        List<Appointment> appointments = appointmentService.getAllAppointmentsSortedDescending();
        System.out.println(JsonUtil.toPrettyJson(appointments));
    }

    private void displayQuarterlyUpcomingAppointments() {
        List<Appointment> appointments = appointmentService.getQuarterlyUpcomingAppointments(LocalDate.now());
        System.out.println(JsonUtil.toPrettyJson(appointments));
    }

    private void printMenu() {
        System.out.println();
        System.out.println("Welcome to ADS Appointment Menu");
        System.out.println("1. Display all appointments");
        System.out.println("2. Display quarterly upcoming appointments");
        System.out.println("3. Exit");
        System.out.print("Select an option: ");
    }
}

package org.example;

import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
        Dealership dealership = new Dealership("Test Dealership", "123 Main St", "555-1234"); // needs params for name, address, and phone loaded from file

        private static final Scanner scanner = new Scanner(System.in);

        public UserInterface() { // removed parameters temporarily
            // will fix if issues arise while adding multiple dealerships (MDC)

        }


        public void init () {
          DealershipFileManager myDealershipFileManager = new DealershipFileManager();
          this.dealership = myDealershipFileManager.getDealership();
        }
        public void display(){
            //need to ask user something?
            System.out.println("Welcome to the Car Dealership. Please type a command: ");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("0. Exit");
            String userCommand = scanner.next();
            boolean exit = false;

            while(!exit){
                switch (userCommand){
                    case "1":
                        processGetByPriceRequest();
                        break;
                    case "2":
                        processGetByMakeModelRequest();
                        break;
                    case "0":
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid command! Please try again.");
                }
            }
        }
        public void processGetByPriceRequest() {
            System.out.println("Get vehicles by price");
            System.out.println("Enter min price:");
            double min = scanner.nextDouble();
            System.out.println("Enter max price:");
            double max = scanner.nextDouble();
            List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
            displayVehicles(vehicles);
        }
        public void processGetByMakeModelRequest() {}
        public void processGetByYearRequest() {}
        public void processGetByColorRequest() {}
        public void processGetByMileageRequest() {}
        public void processGetByVehicleTypeRequest() {}
        public void processGetAllVehiclesRequest() {}
        public void processAddVehicleRequest() {}
        public void processRemoveVehicleRequest() {}

    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No matching vehicles were found.");
        } else {
            System.out.println("VIN|YEAR|MAKE|MODEL|TYPE|COLOR|MILEAGE|PRICE");
            for (Vehicle vehicle : vehicles) {
                System.out.printf("%d|%d|%s|%s|%s|%s|%d|%s\n",
                        vehicle.getVin(),
                        vehicle.getYear(),
                        vehicle.getMake(),
                        vehicle.getModel(),
                        vehicle.getVehicleType(),
                        vehicle.getColor(),
                        vehicle.getOdometer(),
                        NumberFormat.getCurrencyInstance().format(vehicle.getPrice()));
            }
        }
    }

    public static String getInput(String prompt, boolean allowEmpty) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (allowEmpty || !input.isEmpty()) {
            return input;
        }
        System.out.println("The input cannot be empty. Please enter a value.");
        return getInput(prompt, allowEmpty);
    }
    }


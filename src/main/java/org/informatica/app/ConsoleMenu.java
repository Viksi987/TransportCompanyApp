package org.informatica.app;

import org.informatica.entity.Client;
import org.informatica.entity.TransportCompany;
import org.informatica.service.ClientService;
import org.informatica.service.ClientServiceImpl;
import org.informatica.service.TransportCompanyService;
import org.informatica.service.TransportCompanyServiceImpl;
import org.informatica.entity.Vehicle;
import org.informatica.service.VehicleService;
import org.informatica.service.VehicleServiceImpl;
import org.informatica.entity.Employee;
import org.informatica.service.EmployeeService;
import org.informatica.service.EmployeeServiceImpl;
import org.informatica.entity.Transport;
import org.informatica.service.TransportService;
import org.informatica.service.TransportServiceImpl;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;




import java.util.Scanner;

public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final TransportCompanyService companyService =
            new TransportCompanyServiceImpl();

    private final ClientService clientService =
            new ClientServiceImpl();

    private final VehicleService vehicleService =
            new VehicleServiceImpl();

    private final EmployeeService employeeService =
            new EmployeeServiceImpl();
    private final TransportService transportService =
            new TransportServiceImpl();



    public void start() {
        int choice;

        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addCompany();
                case 2 -> showCompanies();
                case 3 -> updateCompany();
                case 4 -> deleteCompany();

                case 5 -> addClient();
                case 6 -> showClients();

                case 7 -> addVehicle();
                case 8 -> showVehicles();
                case 9 -> deleteVehicle();

                case 10 -> addEmployee();
                case 11 -> showEmployees();
                case 12 -> deleteEmployee();

                case 13 -> addTransport();
                case 14 -> showTransports();
                case 15 -> markTransportPaid();

                case 16 -> showCompanyRevenue();
                case 17 -> showCompaniesSortedByName();
                case 18 -> showCompaniesSortedByRevenue();
                case 19 -> showEmployeesSortedBySalary();
                case 20 -> showTransportsSortedByDestination();
                case 21 -> exportTransportsToFile();
                case 22 -> importTransportsFromFile();
                case 23 -> showTotalPaidRevenue();


                case 0 -> System.out.println("Изход...");
                default -> System.out.println("Невалиден избор!");



            }

        } while (choice != 0);
    }

    private void printMenu() {
        System.out.println("\n===== TRANSPORT COMPANY APP =====");
        System.out.println("1. Добави компания");
        System.out.println("2. Покажи компании");
        System.out.println("3. Обнови компания");
        System.out.println("4. Изтрий компания");
        System.out.println("5. Добави клиент");
        System.out.println("6. Покажи клиенти");
        System.out.println("7. Добави превозно средство");
        System.out.println("8. Покажи превозни средства");
        System.out.println("9. Изтрий превозно средство");
        System.out.println("10. Добави служител");
        System.out.println("11. Покажи служители");
        System.out.println("12. Изтрий служител");
        System.out.println("13. Добави превоз");
        System.out.println("14. Покажи превози");
        System.out.println("15. Отбележи превоз като платен");
        System.out.println("16. Покажи приход на компания");
        System.out.println("17. Покажи компании (сортирани по име)");
        System.out.println("18. Покажи компании (сортирани по приходи)");
        System.out.println("19. Покажи служители (сортирани по заплата)");
        System.out.println("20. Покажи превози сортирани по дестинация");
        System.out.println("21. Запиши превозите във файл");
        System.out.println("22. Покажи превозите от файл");
        System.out.println("23. Покажи общ приход от платени превози");

        System.out.println("0. Изход");
        System.out.print("Избор: ");


    }

    //  COMPANY

    private void addCompany() {
        System.out.print("Име: ");
        String name = scanner.nextLine();

        System.out.print("Адрес: ");
        String address = scanner.nextLine();

        System.out.print("Телефон: ");
        String phone = scanner.nextLine();

        try {
            companyService.createCompany(
                    new TransportCompany(name, address, phone)
            );
            System.out.println("Компанията е добавена успешно.");
        } catch (Exception e) {
            System.out.println("Грешка: " + e.getMessage());
        }
    }

    private void showCompanies() {
        companyService.findAll().forEach(System.out::println);
    }

    private void updateCompany() {
        System.out.print("ID на компанията: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Ново име: ");
        String name = scanner.nextLine();

        System.out.print("Нов адрес: ");
        String address = scanner.nextLine();

        System.out.print("Нов телефон: ");
        String phone = scanner.nextLine();

        companyService.updateCompany(
                new TransportCompany(id, name, address, phone)
        );

        System.out.println("Компанията е обновена.");
    }

    private void deleteCompany() {
        System.out.print("ID на компанията: ");
        int id = Integer.parseInt(scanner.nextLine());

        companyService.deleteCompany(id);
        System.out.println("Компанията е изтрита.");
    }

    //  CLIENT

    private void addClient() {
        System.out.print("Име: ");
        String name = scanner.nextLine();

        System.out.print("Телефон: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Company ID: ");
        int companyId = Integer.parseInt(scanner.nextLine());

        try {
            clientService.create(
                    new Client(name, phone, email, companyId)
            );
            System.out.println("Клиентът е добавен.");
        } catch (Exception e) {
            System.out.println("Грешка: " + e.getMessage());
        }
    }

    private void showClients() {
        clientService.findAll().forEach(System.out::println);
    }

    // VEHICLE

    private void addVehicle() {
        System.out.print("Тип (BUS/TRUCK/TANKER): ");
        String type = scanner.nextLine();

        System.out.print("Регистрационен номер: ");
        String reg = scanner.nextLine();

        System.out.print("Капацитет: ");
        double capacity = Double.parseDouble(scanner.nextLine());

        System.out.print("Company ID: ");
        int companyId = Integer.parseInt(scanner.nextLine());

        try {
            vehicleService.create(
                    new Vehicle(type, reg, capacity, companyId)
            );
            System.out.println("Превозното средство е добавено.");
        } catch (Exception e) {
            System.out.println("Грешка: " + e.getMessage());
        }
    }

    private void showVehicles() {
        vehicleService.findAll().forEach(System.out::println);
    }

    private void deleteVehicle() {
        System.out.print("ID на превозното средство: ");
        int id = Integer.parseInt(scanner.nextLine());

        vehicleService.delete(id);
        System.out.println("Превозното средство е изтрито.");
    }

    // EMPLOYEE

    private void addEmployee() {

        System.out.print("Име: ");
        String name = scanner.nextLine();

        System.out.print("Позиция (DRIVER / MANAGER): ");
        String position = scanner.nextLine().toUpperCase();

        System.out.print("Заплата: ");
        double salary;
        try {
            salary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Грешка: заплатата трябва да е число!");
            return;
        }

        String qualification;

        if (position.equals("DRIVER")) {
            System.out.println("Квалификации за DRIVER:");
            System.out.println("BUS_DRIVER");
            System.out.println("CARGO_TRANSPORT");
            System.out.println("HAZARDOUS_MATERIALS");
            System.out.println("TANKER_DRIVER");
            System.out.println("INTERNATIONAL_TRANSPORT");
            System.out.print("Квалификация: ");
            qualification = scanner.nextLine();

        } else if (position.equals("MANAGER")) {
            System.out.println("Квалификации за MANAGER:");
            System.out.println("OPERATIONS_MANAGER");
            System.out.println("HR_MANAGER");
            System.out.println("FINANCIAL_MANAGER");
            System.out.println("FLEET_MANAGER");
            System.out.print("Квалификация: ");
            qualification = scanner.nextLine();

        } else {
            qualification = "NONE";
        }

        System.out.print("Company ID: ");
        int companyId;
        try {
            companyId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Грешка: Company ID трябва да е число!");
            return;
        }

        try {
            employeeService.create(
                    new Employee(name, position, salary, qualification, companyId)
            );
            System.out.println("Служителят е добавен успешно.");
        } catch (Exception e) {
            System.out.println("Грешка: " + e.getMessage());
        }
    }


    private void showEmployees() {
        employeeService.findAll().forEach(System.out::println);
    }

    private void deleteEmployee() {
        System.out.print("ID на служителя: ");
        int id = Integer.parseInt(scanner.nextLine());

        employeeService.delete(id);
        System.out.println("Служителят е изтрит.");
    }

    //  TRANSPORT


    private void addTransport() {

        System.out.print("Начална точка: ");
        String start = scanner.nextLine();

        System.out.print("Крайна точка: ");
        String end = scanner.nextLine();

        System.out.print("Дата на тръгване (YYYY-MM-DD): ");
        LocalDate departureDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Дата на пристигане (YYYY-MM-DD): ");
        LocalDate arrivalDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Тип товар (PEOPLE / GOODS): ");
        String cargoType = scanner.nextLine().toUpperCase();

        if (cargoType.equals("PEOPLE")) {
            cargoType = "PASSENGERS";
        }


        Double weight = null;
        if (cargoType.equals("GOODS")) {
            System.out.print("Тегло на товара: ");
            weight = Double.parseDouble(scanner.nextLine());
        }

        System.out.print("Цена: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Client ID: ");
        int clientId = Integer.parseInt(scanner.nextLine());

        System.out.print("Driver ID: ");
        int driverId = Integer.parseInt(scanner.nextLine());

        System.out.print("Vehicle ID: ");
        int vehicleId = Integer.parseInt(scanner.nextLine());

        System.out.print("Company ID: ");
        int companyId = Integer.parseInt(scanner.nextLine());


        Transport t = new Transport(
                start, end,
                departureDate, arrivalDate,
                cargoType, weight,
                price,
                clientId, driverId, vehicleId, companyId
        );


        transportService.create(t);


        System.out.println("Превозът е добавен.");
    }

    private void showTransports() {
        transportService.findAll().forEach(System.out::println);
    }

    private void markTransportPaid() {
        System.out.print("ID на превоза: ");
        int id = Integer.parseInt(scanner.nextLine());
        transportService.markAsPaid(id);
        System.out.println("Превозът е отбелязан като платен.");
    }
    private void showCompanyRevenue() {

        System.out.print("Company ID: ");
        int companyId = Integer.parseInt(scanner.nextLine());

        double revenue = transportService.getCompanyRevenue(companyId);

        System.out.println("Приход на компанията: " + revenue);
    }
    private void showCompaniesSortedByName() {

        List<TransportCompany> companies = companyService.findAll();

        companies.stream()
                .sorted(Comparator.comparing(TransportCompany::getName))
                .forEach(System.out::println);
    }
    private void showCompaniesSortedByRevenue() {

        List<TransportCompany> companies = companyService.findAll();

        companies.stream()
                .sorted(Comparator.comparing(
                        (TransportCompany c) ->
                                transportService.getCompanyRevenue(c.getId())
                ).reversed())
                .forEach(c ->
                        System.out.println(
                                c.getName() +
                                        " | revenue=" +
                                        transportService.getCompanyRevenue(c.getId())
                        )
                );
    }

    private void showEmployeesByQualification() {

        System.out.print("Въведи квалификация: ");
        String qualification = scanner.nextLine();

        System.out.println("Служители с квалификация: " + qualification);

        employeeService.findByQualification(qualification)
                .forEach(e -> System.out.println(e));
    }
    private void showEmployeesSortedBySalary() {

        System.out.print("Сортиране по заплата (1 = възходящо, 2 = низходящо): ");
        int choice = Integer.parseInt(scanner.nextLine());

        boolean ascending = (choice == 1);

        employeeService.findAllSortedBySalary(ascending)
                .forEach(e -> System.out.println(e));
    }
    private void showTransportsSortedByDestination() {
        System.out.println("Превози сортирани по крайна точка:");

        transportService.findAllSortedByDestination()
                .forEach(System.out::println);
    }
    private void exportTransportsToFile() {
        transportService.exportTransportsToFile("transports.txt");
        System.out.println("Превозите са записани във файл.");
    }

    private void importTransportsFromFile() {
        transportService.importTransportsFromFile("transports.txt");
    }
    private void showTotalTransportCount() {
        int count = transportService.getTotalTransportCount();
        System.out.println("Общ брой превози: " + count);
    }
    private void showTotalRevenue() {
        double revenue = transportService.getTotalPaidRevenue();
        System.out.println("Общ приход (платени превози): " + revenue);
    }
    private void showTotalPaidRevenue() {
        double revenue = transportService.getTotalPaidRevenue();
        System.out.println("Общ приход от платени превози: " + revenue);
    }

}


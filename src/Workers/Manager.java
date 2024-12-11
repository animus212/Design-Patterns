package Workers;

import HOTEL.Hotel;

import java.util.Scanner;

public class Manager{ //singleton
    private final String password;
    private final String username;
    private static Manager instance;
    private Scanner scanner;
    Hotel hotel;
    public Manager() {
        password = "123";
        username = "manager";
        scanner = new Scanner(System.in);
        hotel = Hotel.getHotelInstance();
    }


    public static Manager getInstance(){
        if(instance == null){
            instance = new Manager();
        }
        return instance;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public static void setInstance(Manager instance) {
        Manager.instance = instance;
    }

    public void addWorker(){
        Worker newWorker = new Worker();
        System.out.println("enter name: ");
        newWorker.setName(scanner.nextLine());
        System.out.println("enter email: ");
        newWorker.setEmail(scanner.nextLine());
        System.out.println("enter number: ");
        newWorker.setPhoneNumber(scanner.nextLine());
        System.out.println(" job title: ");
        newWorker.setJobTitle(scanner.nextLine());
        System.out.println("salary: ");
        newWorker.setSalary(scanner.nextDouble());
        Hotel hotel = Hotel.getHotelInstance();
        hotel.getWorkers().add(newWorker);
    };

    public void deleteWorker(Integer workerId){

        hotel.getWorkers().removeIf(worker -> workerId.equals(worker.getID()));
    }

    public void editWorker(Integer workerId){
        Worker worker = null;
        for (Worker w: hotel.getWorkers()){
            if(w.getID().equals(workerId)){
             worker = w;
             break;
            }
        }
        if(worker == null){
            System.out.println("worker not found");
        }else {
            System.out.println(worker.toString());
            System.out.println("1- name   2- email   3- phone  4-title  5- salary");
            switch (Integer.parseInt(scanner.nextLine())){
                case 1:
                    System.out.println("enter name: ");
                    worker.setName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("enter email: ");
                    worker.setEmail(scanner.nextLine());
                    break;
                case 3:
                    System.out.println("enter number: ");
                    worker.setPhoneNumber(scanner.nextLine());
                    break;
                case 4:
                    System.out.println(" job title: ");
                    worker.setJobTitle(scanner.nextLine());
                    break;
                case 5:
                    System.out.println("salary: ");
                    worker.setSalary(scanner.nextDouble());
                    break;
                default:
                    System.out.println("invalid input");
            }
            System.out.println(worker.toString());
        }
    }

    public void ViewWorkerDetails(){
        System.out.println(hotel.getWorkers());
    }

    public void ViewResidentInformation(){
        System.out.println(hotel.getResidents());
    }

    public void weeklyIncomeReport(){
        hotel.weeklyIncome();
    }

    public void monthlyIncomeReport(){
        hotel.monthlyIncome();
    }

    public void yearlyIncomeReport(){
        hotel.annualIncome();
    }
}

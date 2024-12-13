package Worker;

import Registry.Registry;

import java.util.Scanner;

public class Manager {
  private final String password;
  private final String username;
  private static Manager manager = new Manager();
  private Scanner scanner;
  private Registry registry;

  public Manager() {
    password = "123";
    username = "manager";
    scanner = new Scanner(System.in);
    registry = Registry.getInstance();
  }

  public static Manager getInstance() {
    return manager;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public void addWorker() {
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

    registry.getWorkers().add(newWorker);
  }

  public void deleteWorker(int workerId){
    registry.getWorkers().removeIf(worker -> workerId == worker.getID());
  }

  public void editWorker(int workerId){
    Worker worker = null;

    for (Worker w: registry.getWorkers()) {
      if (w.getID().equals(workerId)) {
        worker = w;

        break;
      }
    }

    if (worker == null) {
      System.out.println("worker not found");
    } else {
      System.out.println(worker.toString());
      System.out.println("1- name   2- email   3- phone  4-title  5- salary");

      switch (Integer.parseInt(scanner.nextLine())) {
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

  public void ViewWorkerDetails() {
    System.out.println(registry.getWorkers());
  }

  public void ViewResidentInformation() {
    System.out.println(registry.getResidents());
  }

  public void weeklyIncomeReport() {
    registry.weeklyIncome();
  }

  public void monthlyIncomeReport() {
    registry.monthlyIncome();
  }

  public void yearlyIncomeReport() {
    registry.annualIncome();
  }
}

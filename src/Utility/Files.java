package Utility;

import Employee.Worker;
import Registry.Registry;
import Reservation.Resident;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Files {
    public void saveWorkers(){
        try {
            File workersFile = new File("workers.txt");
            if (workersFile.createNewFile()) {
                System.out.println("File created: " + workersFile.getName());
            }
            FileWriter workerWriter = new FileWriter(workersFile.getPath());
            for (Worker worker: Registry.getInstance().getWorkers()){
            workerWriter.write(worker.getId() + " " + worker.getName() + " " + worker.getEmail() + " "
            + worker.getPhoneNumber() + " " + worker.getSalary() + " " + worker.getJobTitle() + "\n");
            }
            workerWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readWorkers() throws IOException {
        File workersFile = new File("workers.txt");;
        try {

            Scanner workerReader = new Scanner(workersFile);
            String[] workerDetails;
            while (workerReader.hasNextLine()) {
                String data = workerReader.nextLine();
                workerDetails = data.split(" ");
                Registry.getInstance().getWorkers().add(new Worker(Integer.parseInt(workerDetails[0]),
                        workerDetails[1],
                        workerDetails[2],
                        workerDetails[3],
                        Double.parseDouble(workerDetails[4]),
                        workerDetails[5]));
            }
            workerReader.close();
        } catch (FileNotFoundException e) {
            workersFile.createNewFile();
            e.printStackTrace();
        }
    }

    public void saveResidents(){
        try {
            File residentFile = new File("residents.txt");
            if (residentFile.createNewFile()) {
                System.out.println("File created: " + residentFile.getName());
            }
            FileWriter residentWriter = new FileWriter(residentFile.getPath());
            for (Resident resident: Registry.getInstance().getResidents()){
                residentWriter.write(resident.getName() + " " + resident.getAge() + " " + resident.getPhoneNumber() + " "
                        + resident.getBookingId() + " " + resident.getServiceList() + "\n");
            }
            residentWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readResidents() throws IOException {
        File residentsFile = new File("residents.txt");;
        try {

            Scanner residentReader = new Scanner(residentsFile);
            String[] residentDetails;
            StringBuilder residentServiceList = new StringBuilder();
            Resident resident;
            while (residentReader.hasNextLine()) {
                String data = residentReader.nextLine();
                residentDetails = data.split(" ");
                resident = new Resident(residentDetails[0], Integer.parseInt(residentDetails[1]), residentDetails[2], Integer.parseInt(residentDetails[3]));

                for (int i = 4; i < residentDetails.length; i++){
                    residentServiceList.append(residentDetails[i]);
                    if (i != residentDetails.length - 1){
                        residentServiceList.append(", ");
                    }
                }
                resident.setServiceList(String.valueOf(residentServiceList));

                Registry.getInstance().getResidents().add(resident);
            }
            residentReader.close();
        } catch (FileNotFoundException e) {
            residentsFile.createNewFile();
            e.printStackTrace();
        }
    }
}

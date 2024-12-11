import HOTEL.Hotel;
import Rooms.RoomFactory;
import Services.Resident;
import Workers.Manager;

public class Main {
    public static void main(String[] args) {

        Manager m = Manager.getInstance();
        Hotel.getHotelInstance().getWorkers().forEach(System.out::println);

        RoomFactory rf= new RoomFactory();
        Resident newResident = new Resident();
        newResident.setName("a");
        newResident.setAge(24);
        newResident.setDurationOfStay(2);
        newResident.setAssignedRoom(rf.createRoom("single"));
        System.out.println(newResident);


        //m.editWorker(0);
        //m.deleteWorker(1);
    }
}
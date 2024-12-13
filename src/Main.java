import Registry.Registry;
import Resident.Resident;
import Room.RoomFactory;
import Worker.Manager;

public class Main {
    public static void main(String[] args) {
        Manager m = Manager.getInstance();
        Registry.getInstance().getWorkers().forEach(System.out::println);

        RoomFactory rf = new RoomFactory();
        Resident newResident = new Resident();
        newResident.setName("a");
        newResident.setAge(24);
        newResident.setDurationOfStay(2);
        newResident.setAssignedRoom(rf.createRoom("single"));
        System.out.println(newResident);
    }
}

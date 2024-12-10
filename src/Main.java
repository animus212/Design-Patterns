import HOTEL.Hotel;
import Workers.Manager;

public class Main {
    public static void main(String[] args) {

        Manager m = Manager.getInstance();
        m.addWorker();
        System.out.println(Hotel.getHotelInstance().toString());
        m.editWorker(1);
        m.deleteWorker(1);
    }
}
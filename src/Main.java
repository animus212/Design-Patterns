import Utility.Files;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        try {
            Files.readWorkers();
            Files.readResidents();

            JFrame hotelManagement = new HotelManagement();

            hotelManagement.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Files.saveWorkers();
                    Files.saveResidents();

                    System.exit(0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

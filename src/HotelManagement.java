import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagement extends JFrame {
    private JPanel ContainerPanel;
    private JLabel hotelName;
    private JPanel subMenu;
    private JPanel contentPanel;
    private JPanel topBarPanel;
    private JPanel loginPanel;
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JButton workersButton;
    private JButton residentsButton;
    private JButton incomeButton;
    private JButton roomsButton;
    private JPanel manageWorkers;
    private JTable workersTable;
    private JButton deleteWorker;
    private JButton updateWorker;
    private JButton addWorker;
    private JScrollPane workersScrollPane;
    private JTable residentsTable;
    private JButton deleteResident;
    private JButton updateResident;
    private JButton addResident;
    private JScrollPane residentScrollPane;
    private JPanel manageResidents;
    private JPanel incomePanel;
    private JComboBox incomeBox;
    private JButton showIncome;
    private JLabel incomeType;
    private JTextField incomeValue;
    private JPanel addResidentPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel Resname;
    private JLabel ResPhone;
    private JTextField textField4;
    private JButton Book;
    private JLabel ResAge;
    private JLabel Duration;
    private JPanel RoomsPanel;
    private JTable RoomsTable;
    private JButton logoutButton;
    private JComboBox RoomType_Combox;
    private JComboBox BoardingType_Combox;
    private JLabel roomType;
    private JLabel boardingType;
    private JPanel AddWorkerPanel;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JButton AddWorker_Button;

    public HotelManagement() {
        setContentPane(ContainerPanel);
        setTitle("Hotel Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        subMenu.setVisible(false);

        incomeBox.addItem("Annual");
        incomeBox.addItem("Monthly");
        incomeBox.addItem("Weekly");
        RoomType_Combox.addItem("Single");
        RoomType_Combox.addItem("Double");
        RoomType_Combox.addItem("Triple");
        BoardingType_Combox.addItem("Bed & Breakfast");
        BoardingType_Combox.addItem("Half Board");
        BoardingType_Combox.addItem("Full Board");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passchars = passwordField.getPassword();
                String Pass = new String(passchars);

                if (Pass.equals("123") && username.equalsIgnoreCase("Man")) {
                    subMenu.setVisible(true);
                    addResident.setVisible(false);
                    updateResident.setVisible(false);
                    deleteResident.setVisible(false);
                } else if (Pass.equals("456") && username.equalsIgnoreCase("Rec")) {
                    subMenu.setVisible(true);
                    workersButton.setVisible(false);
                    manageWorkers.setVisible(false);
                    incomeButton.setVisible(false);
                    roomsButton.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(HotelManagement.this, "User Not Found!");
                }
            }
        });

        workersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] workerColumnNames = {"Name", "E-mail", "Phone Number", "Salary", "Job Title"};
                Object[][] data = {
                        {"John Doe", "john.doe@example.com", "123-456-7890", "$50,000", "Manager"},
                        {"Jane Smith", "jane.smith@example.com", "987-654-3210", "$45,000", "Assistant"},
                        {"Alice Brown", "alice.brown@example.com", "555-123-4567", "$48,000", "Coordinator"},
                        {"Bob White", "bob.white@example.com", "444-555-6666", "$52,000", "Supervisor"},
                        {"Tom Green", "tom.green@example.com", "333-777-8888", "$47,000", "Analyst"}
                };
                DefaultTableModel defaultTableModel = new DefaultTableModel(data, workerColumnNames);
                workersTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "workerCard");
            }
        });

        residentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ResColumnNames = {"Name", "Age", "Phone Number", "Booking ID"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(null, ResColumnNames);
                residentsTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "residentCard");
            }
        });

        incomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "incomeCard");
            }
        });

        showIncome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                incomeValue.setVisible(true);
            }
        });

        addResident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "BookingCard");
            }
        });

        Book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(HotelManagement.this, "Resident Added");
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "residentCard");
            }
        });

        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] RoomsColumnNames = {"Room Number", "Room State"};
                DefaultTableModel defaultTableModel = new DefaultTableModel(null, RoomsColumnNames);
                RoomsTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "RoomsCard");
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new HotelManagement();
            }
        });

        addWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "addWorkerCard");
            }
        });

        AddWorker_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "workerCard");
            }
        });
    }
}

import Registry.BookingOperations.AddBooking;
import Registry.BookingOperations.EditBooking;
import Registry.Registry;
import Registry.ResidentOperations.AddResident;
import Registry.ResidentOperations.DeleteResident;
import Registry.ResidentOperations.EditResident;
import Registry.WorkerOperations.AddWorker;
import Registry.WorkerOperations.DeleteWorker;
import Registry.WorkerOperations.EditWorker;
import Reports.MonthlyReport;
import Reports.Report;
import Reports.WeeklyReport;
import Reports.YearlyReport;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelManagement extends JFrame {
    private final Registry REGISTRY = Registry.getInstance();
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
    private JTextField incomeValue;
    private JPanel addResidentPanel;
    private JTextField textField1;
    private JLabel Resname;
    private JLabel ResPhone;
    private JTextField textField4;
    private JButton Book;
    private JLabel ResAge;
    private JLabel Duration;
    private JPanel RoomsPanel;
    private JTable RoomsTable;
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
    private JTextField textField10;
    private JLabel incomeType;
    private JTextField textField2;
    private JTextField textField3;
    private Report report;
    private boolean isReceptionist = false;

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
        RoomType_Combox.addItem("SingleRoom");
        RoomType_Combox.addItem("DoubleRoom");
        RoomType_Combox.addItem("TripleRoom");
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

                    isReceptionist = true;
                } else {
                    JOptionPane.showMessageDialog(HotelManagement.this, "User Not Found!");
                }
            }
        });

        workersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] workerColumnNames = {"ID", "Name", "E-mail", "Phone Number", "Salary", "Job Title"};
                Object[][] data = new Object[REGISTRY.getWorkers().size()][workerColumnNames.length];

                for (int i = 0; i < REGISTRY.getWorkers().size(); i++) {
                    data[i][0] = REGISTRY.getWorkers().get(i).getID();
                    data[i][1] = REGISTRY.getWorkers().get(i).getName();
                    data[i][2] = REGISTRY.getWorkers().get(i).getEmail();
                    data[i][3] = REGISTRY.getWorkers().get(i).getPhoneNumber();
                    data[i][4] = REGISTRY.getWorkers().get(i).getSalary();
                    data[i][5] = REGISTRY.getWorkers().get(i).getJobTitle();
                }

                DefaultTableModel defaultTableModel = new DefaultTableModel(data, workerColumnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return column != 0;
                    }
                };

                workersTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "workerCard");
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
                ArrayList<String> workerData = new ArrayList<String>();

                workerData.add(textField10.getText());
                workerData.add(textField5.getText());
                workerData.add(textField6.getText());
                workerData.add(textField7.getText());
                workerData.add(textField8.getText());
                workerData.add(textField9.getText());

                AddWorker addWorkerOp = new AddWorker(workerData);

                try {
                    addWorkerOp.execute();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Added!");
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Not Added!");
                }
            }
        });

        updateWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> workerData = new ArrayList<String>();

                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 0).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 1).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 2).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 3).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 4).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 5).toString());

                EditWorker editWorkerOp = new EditWorker(workerData);

                try {
                    editWorkerOp.execute();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Edited!");
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Not Edited!");
                }
            }
        });

        deleteWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> workerData = new ArrayList<String>();

                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 0).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 1).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 2).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 3).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 4).toString());
                workerData.add(workersTable.getValueAt(workersTable.getSelectedRow(), 5).toString());

                DeleteWorker deleteWorkerOp = new DeleteWorker(workerData);

                try {
                    deleteWorkerOp.execute();

                    DefaultTableModel model = (DefaultTableModel) workersTable.getModel();
                    model.removeRow(workersTable.getSelectedRow());

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Deleted!");
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Not Deleted!");
                }
            }
        });

        residentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] ResColumnNames = {"Name", "Age", "Phone Number", "Booking ID", "Services",
                        "Room Number", "Room Type", "Duration of Stay", "Boarding Type"};

                Object[][] data = new Object[REGISTRY.getResidents().size()][ResColumnNames.length];

                for (int i = 0; i < REGISTRY.getResidents().size(); i++) {
                    data[i][0] = REGISTRY.getResidents().get(i).getName();
                    data[i][1] = REGISTRY.getResidents().get(i).getAge();
                    data[i][2] = REGISTRY.getResidents().get(i).getPHONE_NUMBER();
                    data[i][3] = REGISTRY.getResidents().get(i).getBOOKING_ID();
                    data[i][4] = REGISTRY.getResidents().get(i).getServiceList();

                    for (int j = 0; j < REGISTRY.getBookings().size(); j++) {
                        if (REGISTRY.getResidents().get(i).getBOOKING_ID() == REGISTRY.getBookings().get(j).getID()) {
                            data[i][5] = REGISTRY.getBookings().get(j).getRoomNumber();
                            data[i][6] = REGISTRY.getRooms().get(Integer.parseInt(data[i][5].toString()))
                                    .getClass().getSimpleName();
                            data[i][7] = REGISTRY.getBookings().get(j).getDurationOfStay();
                            data[i][8] = REGISTRY.getBookings().get(j).getBoardingType();
                        }
                    }
                }

                DefaultTableModel defaultTableModel = new DefaultTableModel(data, ResColumnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return isReceptionist && column != 2 && column != 3 && column != 6;
                    }
                };

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
                if (incomeBox.getSelectedIndex() == 0) {
                    report = new YearlyReport();
                } else if (incomeBox.getSelectedIndex() == 1) {
                    report = new MonthlyReport();
                } else {
                    report = new WeeklyReport();
                }

                incomeValue.setText(String.valueOf(report.generateReport()));
            }
        });

        roomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] RoomsColumnNames = {"Room Number", "Room Type", "Room Availability"};
                Object[][] data = new Object[REGISTRY.getRooms().size()][RoomsColumnNames.length];

                for (int i = 0; i < REGISTRY.getRooms().size(); i++) {
                    data[i][0] = i;
                    data[i][1] = REGISTRY.getRooms().get(i).getClass().getSimpleName();
                    data[i][2] = REGISTRY.getRooms().get(i).isAvailable() ? "Available" : "Occupied";
                }

                DefaultTableModel defaultTableModel = new DefaultTableModel(data, RoomsColumnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                RoomsTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "RoomsCard");
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
                ArrayList<String> residentData = new ArrayList<String>();
                ArrayList<String> bookingData = new ArrayList<String>();

                residentData.add(textField1.getText());
                residentData.add(textField3.getText());
                residentData.add(textField2.getText());
                residentData.add("-1");

                bookingData.add(textField4.getText());
                bookingData.add(BoardingType_Combox.getSelectedItem().toString());
                bookingData.add(RoomType_Combox.getSelectedItem().toString());

                AddBooking addBookingOp = new AddBooking(bookingData);
                AddResident addResidentOp = new AddResident(residentData);
                EditResident editResidentOp;
                DeleteResident deleteResidentOp;

                try {
                    addResidentOp.execute();

                    addBookingOp.execute();

                    residentData.set(3, String.valueOf(REGISTRY.getBookings().getLast().getID()));
                    residentData.add("");

                    editResidentOp = new EditResident(residentData);

                    editResidentOp.execute();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Booked!");
                } catch (NullPointerException ex) {
                    ex.printStackTrace();

                    deleteResidentOp = new DeleteResident(residentData);

                    deleteResidentOp.execute();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Error while Booking!");
                } catch (IllegalArgumentException exc) {
                    exc.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this,
                            "Error while adding resident!");
                }
            }
        });

        updateResident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> residentData = new ArrayList<String>();
                ArrayList<String> bookingData = new ArrayList<String>();

                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 0).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 1).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 2).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 3).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 4).toString());

                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 3).toString());
                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 5).toString());
                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 7).toString());
                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 8).toString());

                EditResident editResidentOp = new EditResident(residentData);
                EditBooking editBookingOp = new EditBooking(bookingData);

                try {
                    editResidentOp.execute();

                    editBookingOp.execute();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Edited!");
                } catch (IllegalArgumentException exc) {
                    exc.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this,
                            "Error while editing!");
                }
            }
        });

        deleteResident.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> residentData = new ArrayList<String>();
                ArrayList<String> bookingData = new ArrayList<String>();

                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 0).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 1).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 2).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 3).toString());
                residentData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 4).toString());

                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 3).toString());
                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 5).toString());
                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 7).toString());
                bookingData.add(residentsTable.getValueAt(residentsTable.getSelectedRow(), 8).toString());

                DeleteResident deleteResidentOp = new DeleteResident(residentData);

                try {
                    for (int j = 0; j < REGISTRY.getBookings().size(); j++) {
                        if (REGISTRY.getBookings().get(j).getID() == Integer.parseInt(bookingData.getFirst())) {
                            JOptionPane.showMessageDialog(HotelManagement.this,
                                    "Total Payment is: $" + REGISTRY.getBookings().get(j).calculateCost());

                            break;
                        }
                    }

                    deleteResidentOp.execute();

                    REGISTRY.freeRoom(Integer.parseInt(bookingData.get(1)));
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this,
                            "Error while checking out!");
                }
            }
        });
    }
}

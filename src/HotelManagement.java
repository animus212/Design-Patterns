import Registry.BookingOperations.*;
import Registry.Registry;
import Registry.ResidentOperations.*;
import Registry.WorkerOperations.*;
import Reports.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HotelManagement extends JFrame {
    private final Registry REGISTRY = Registry.getInstance();
    private JPanel containerPanel;
    private JLabel hotelName;
    private JPanel subMenu;
    private JPanel contentPanel;
    private JPanel topBarPanel;
    private JPanel loginPanel;
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JButton workerButton;
    private JButton residentButton;
    private JButton incomeButton;
    private JButton roomButton;
    private JPanel workerPanel;
    private JTable workerTable;
    private JButton deleteWorkerButton;
    private JButton updateWorkerButton;
    private JButton addWorkerPanelButton;
    private JScrollPane workerScrollPane;
    private JTable residentTable;
    private JButton checkOutButton;
    private JButton updateResidentButton;
    private JButton checkInButton;
    private JScrollPane residentScrollPane;
    private JPanel residentPanel;
    private JPanel incomePanel;
    private JComboBox incomeBox;
    private JButton showIncomeButton;
    private JTextField incomeField;
    private JPanel checkInPanel;
    private JTextField residentNameField;
    private JLabel residentNameLabel;
    private JLabel residentPhoneLabel;
    private JTextField residentDurationField;
    private JButton bookButton;
    private JLabel residentAgeLabel;
    private JLabel residentDurationLabel;
    private JPanel roomPanel;
    private JTable roomTable;
    private JComboBox roomTypeBox;
    private JComboBox boardingTypeBox;
    private JLabel roomTypeLabel;
    private JLabel boardingTypeLabel;
    private JPanel AddWorkerPanel;
    private JTextField workerNameField;
    private JTextField workerEmailField;
    private JTextField workerPhoneField;
    private JTextField workerSalaryField;
    private JTextField workerTitleField;
    private JButton addWorkerButton;
    private JTextField workerIdField;
    private JLabel incomeLabel;
    private JTextField residentPhoneField;
    private JTextField residentAgeField;
    private JScrollPane roomScrollPane;
    private JLabel workerNameLabel;
    private JLabel workerTitleLabel;
    private JLabel workerEmailLabel;
    private JLabel workerSalaryLabel;
    private JLabel workerPhoneLabel;
    private JLabel workerIdLabel;
    private Report report;
    private boolean isReceptionist = false;

    public HotelManagement() {
        setContentPane(containerPanel);
        setTitle("Hotel Management System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        subMenu.setVisible(false);

        incomeBox.addItem("Annual");
        incomeBox.addItem("Monthly");
        incomeBox.addItem("Weekly");
        roomTypeBox.addItem("SingleRoom");
        roomTypeBox.addItem("DoubleRoom");
        roomTypeBox.addItem("TripleRoom");
        boardingTypeBox.addItem("Bed & Breakfast");
        boardingTypeBox.addItem("Half Board");
        boardingTypeBox.addItem("Full Board");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passchars = passwordField.getPassword();
                String Pass = new String(passchars);

                if (Pass.equals("123") && username.equalsIgnoreCase("Man")) {
                    subMenu.setVisible(true);
                    checkInButton.setVisible(false);
                    updateResidentButton.setVisible(false);
                    checkOutButton.setVisible(false);
                } else if (Pass.equals("456") && username.equalsIgnoreCase("Rec")) {
                    subMenu.setVisible(true);
                    workerButton.setVisible(false);
                    workerPanel.setVisible(false);
                    incomeButton.setVisible(false);

                    isReceptionist = true;
                } else {
                    JOptionPane.showMessageDialog(HotelManagement.this, "User Not Found!");
                }
            }
        });

        workerButton.addActionListener(new ActionListener() {
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

                workerTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "workerCard");
            }
        });

        addWorkerPanelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "addWorkerCard");
            }
        });

        addWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> workerData = new ArrayList<String>();

                workerData.add(workerIdField.getText());
                workerData.add(workerNameField.getText());
                workerData.add(workerEmailField.getText());
                workerData.add(workerPhoneField.getText());
                workerData.add(workerSalaryField.getText());
                workerData.add(workerTitleField.getText());

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

        updateWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> workerData = new ArrayList<String>();

                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 0).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 1).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 2).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 3).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 4).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 5).toString());

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

        deleteWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> workerData = new ArrayList<String>();

                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 0).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 1).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 2).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 3).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 4).toString());
                workerData.add(workerTable.getValueAt(workerTable.getSelectedRow(), 5).toString());

                DeleteWorker deleteWorkerOp = new DeleteWorker(workerData);

                try {
                    deleteWorkerOp.execute();

                    DefaultTableModel model = (DefaultTableModel) workerTable.getModel();
                    model.removeRow(workerTable.getSelectedRow());

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Deleted!");
                } catch (Exception ex) {
                    ex.printStackTrace();

                    JOptionPane.showMessageDialog(HotelManagement.this, "Worker Not Deleted!");
                }
            }
        });

        residentButton.addActionListener(new ActionListener() {
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

                residentTable.setModel(defaultTableModel);
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

        showIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (incomeBox.getSelectedIndex() == 0) {
                    report = new YearlyReport();
                } else if (incomeBox.getSelectedIndex() == 1) {
                    report = new MonthlyReport();
                } else {
                    report = new WeeklyReport();
                }

                incomeField.setText(String.valueOf(report.generateReport()));
            }
        });

        roomButton.addActionListener(new ActionListener() {
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

                roomTable.setModel(defaultTableModel);
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "RoomsCard");
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "BookingCard");
            }
        });

        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> residentData = new ArrayList<String>();
                ArrayList<String> bookingData = new ArrayList<String>();

                residentData.add(residentNameField.getText());
                residentData.add(residentAgeField.getText());
                residentData.add(residentPhoneField.getText());
                residentData.add("-1");

                bookingData.add(residentDurationField.getText());
                bookingData.add(boardingTypeBox.getSelectedItem().toString());
                bookingData.add(roomTypeBox.getSelectedItem().toString());

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

        updateResidentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> residentData = new ArrayList<String>();
                ArrayList<String> bookingData = new ArrayList<String>();

                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 0).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 1).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 2).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 3).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 4).toString());

                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 3).toString());
                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 5).toString());
                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 7).toString());
                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 8).toString());

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

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> residentData = new ArrayList<String>();
                ArrayList<String> bookingData = new ArrayList<String>();

                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 0).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 1).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 2).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 3).toString());
                residentData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 4).toString());

                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 3).toString());
                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 5).toString());
                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 7).toString());
                bookingData.add(residentTable.getValueAt(residentTable.getSelectedRow(), 8).toString());

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

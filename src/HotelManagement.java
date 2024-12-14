import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagement extends JFrame{
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
    private JButton reportButton;
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

    public HotelManagement() {
        setContentPane(ContainerPanel);
        setTitle("hotel manager");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);
        setVisible(true);
        subMenu.setVisible(false);

        String[] workerColumnNames = {"Name", "E-mail","Phone Number","Salary", "Job Title"};
        Object[][] data = {
                {"John Doe", "john.doe@example.com", "123-456-7890", "$50,000", "Manager"},
                {"Jane Smith", "jane.smith@example.com", "987-654-3210", "$45,000", "Assistant"},
                {"Alice Brown", "alice.brown@example.com", "555-123-4567", "$48,000", "Coordinator"},
                {"Bob White", "bob.white@example.com", "444-555-6666", "$52,000", "Supervisor"},
                {"Tom Green", "tom.green@example.com", "333-777-8888", "$47,000", "Analyst"}
        };
        DefaultTableModel defaultTableModel = new DefaultTableModel(data,workerColumnNames);
        workersTable.setModel(defaultTableModel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                char [] passchars= passwordField.getPassword();
                String Pass = new String(passchars);
                if (Pass.equals("123") && username.equalsIgnoreCase("manager")){
                    subMenu.setVisible(true);
                    addResident.setVisible(false);
                    updateResident.setVisible(false);
                    deleteResident.setVisible(false);
                } else if (Pass.equals("123") && username.equalsIgnoreCase("receptionist")) {
                    subMenu.setVisible(true);
                    workersButton.setVisible(false);
                    manageWorkers.setVisible(false);
                }
                else JOptionPane.showMessageDialog(HotelManagement.this, "user not found");
            }
        });
        workersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "workerCard");
            }
        });
        residentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
                cardLayout.show(contentPanel, "residentCard");
            }
        });
    }
}

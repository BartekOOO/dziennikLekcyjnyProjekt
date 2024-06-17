import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class AddingTeacherMenu extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;
    private JComboBox<String> titleComboBox;
    private JButton submitButton;
    private JButton cancelButton;

    public AddingTeacherMenu() {
        setTitle("Dodawanie Nauczyciela");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(7, 2, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        JLabel firstNameLabel = new JLabel("  Imię:");
        firstNameField = new JTextField();
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("  Nazwisko:");
        lastNameField = new JTextField();
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);

        JLabel titleLabel = new JLabel("  Tytuł:");
        String[] titles = {"Prof.", "Dr.", "Mgr.", "Inż."};
        titleComboBox = new JComboBox<>(titles);
        mainPanel.add(titleLabel);
        mainPanel.add(titleComboBox);

        JLabel birthDateLabel = new JLabel("  Data Urodzenia:");
        mainPanel.add(birthDateLabel);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(1, 6, 5, 5));  // Changed to GridLayout
        dayField = new JTextField(2);
        monthField = new JTextField(2);
        yearField = new JTextField(4);
        datePanel.add(new JLabel("Dzień"));
        datePanel.add(dayField);
        datePanel.add(new JLabel("Miesiąc"));
        datePanel.add(monthField);
        datePanel.add(new JLabel("Rok"));
        datePanel.add(yearField);

        mainPanel.add(datePanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        add(buttonPanel, BorderLayout.SOUTH);

        submitButton = new JButton("Zatwierdź");
        cancelButton = new JButton("Anuluj");

        buttonPanel.add(submitButton);
        buttonPanel.add(cancelButton);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText().trim();
                String lastName = lastNameField.getText().trim();
                String day = dayField.getText().trim();
                String month = monthField.getText().trim();
                String year = yearField.getText().trim();
                String title = (String) titleComboBox.getSelectedItem();
                Dziennik dziennik = new Dziennik();

                if (!firstName.isEmpty() && !lastName.isEmpty() && !day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
                    try {
                        int dayInt = Integer.parseInt(day);
                        int monthInt = Integer.parseInt(month);
                        int yearInt = Integer.parseInt(year) - 1900;  // Adjust year for java.sql.Date
                        Date birthDate = new Date(yearInt, monthInt - 1, dayInt);  // Adjust month (0-based)

                        dziennik.dodajNauczyciela(title, firstName, lastName, birthDate);

                        SwingUtilities.invokeLater(TeacherListWindow::new);
                        setVisible(false);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Niepoprawny format daty");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie dane");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(TeacherListWindow::new);
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddingTeacherMenu::new);
    }
}

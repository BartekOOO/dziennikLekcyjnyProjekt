import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddingStudentMenu extends JFrame {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dayField;
    private JTextField monthField;
    private JTextField yearField;
    private JButton submitButton;
    private JButton cancelButton;

    public AddingStudentMenu() {
        setTitle("Dodawanie Ucznia");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(6, 2, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        JLabel firstNameLabel = new JLabel("  Imię:");
        firstNameField = new JTextField();
        mainPanel.add(firstNameLabel);
        mainPanel.add(firstNameField);

        JLabel lastNameLabel = new JLabel("  Nazwisko:");
        lastNameField = new JTextField();
        mainPanel.add(lastNameLabel);
        mainPanel.add(lastNameField);

        JLabel birthDateLabel = new JLabel("  Data Urodzenia:");
        mainPanel.add(birthDateLabel);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
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
                Dziennik dziennik = new Dziennik();


                if (!firstName.isEmpty() && !lastName.isEmpty() && !day.isEmpty() && !month.isEmpty() && !year.isEmpty()) {
                    dziennik.dodajUcznia(firstName, lastName, new Date(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day)));
                    SwingUtilities.invokeLater(StudentListWindow::new);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Uzupełnij wszystkie dane");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(StudentListWindow::new);
                setVisible(false);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddingStudentMenu::new);
    }
}

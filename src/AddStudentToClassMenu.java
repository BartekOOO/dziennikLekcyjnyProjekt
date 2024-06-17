import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AddStudentToClassMenu extends JFrame {
    private Rekord rekord;
    private JComboBox<String> classComboBox;
    private JButton submitButton;
    private JButton cancelButton;
    private Map<String, Integer> classMap;

    public AddStudentToClassMenu(Rekord rekord) {
        this.rekord = rekord;
        Dziennik dziennik = new Dziennik();

        setTitle("Przypisz ucznia do klasy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        classMap = new HashMap<>();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        JLabel classLabel = new JLabel("  Klasa:");
        DefaultComboBoxModel<String> classModel = new DefaultComboBoxModel<>();
        for (Rekord rek : dziennik.getKlasy().pobierzWszystkieRekordy()) {
            Klasa klasa = (Klasa) rek.getDane();
            int classIndex = rek.getId();
            classModel.addElement(klasa.getNazwaKlasy());
            classMap.put(klasa.getNazwaKlasy(), classIndex);
        }
        classComboBox = new JComboBox<>(classModel);
        mainPanel.add(classLabel);
        mainPanel.add(classComboBox);

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
                String className = (String) classComboBox.getSelectedItem();

                int classIndex = classMap.get(className);

                dziennik.przypiszUczniaDoKlasy(rekord.getId(),classIndex);

                JOptionPane.showMessageDialog(null, "Uczeń został przypisany do klasy");
                SwingUtilities.invokeLater(StudentListWindow::new);
                setVisible(false);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentDetails profilStudenta = new StudentDetails(rekord);
                profilStudenta.setVisible(true);
                setVisible(false);
            }
        });

        setVisible(true);
    }
}

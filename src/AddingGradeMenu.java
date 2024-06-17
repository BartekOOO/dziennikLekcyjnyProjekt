import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class AddingGradeMenu extends JFrame {
    private Rekord rekord;
    private JTextField gradeField;
    private JComboBox<String> subjectComboBox;
    private JComboBox<String> teacherComboBox;
    private JButton submitButton;
    private JButton cancelButton;
    private Map<String, Integer> subjectMap;
    private Map<String, Integer> teacherMap;

    public AddingGradeMenu(Rekord rekord) {
        this.rekord = rekord;
        Dziennik dziennik = new Dziennik();

        setTitle("Dodawanie Oceny");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        subjectMap = new HashMap<>();
        teacherMap = new HashMap<>();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        JLabel gradeLabel = new JLabel("  Ocena:");
        gradeField = new JTextField();
        mainPanel.add(gradeLabel);
        mainPanel.add(gradeField);

        JLabel subjectLabel = new JLabel("  Przedmiot:");
        DefaultComboBoxModel<String> subjectModel = new DefaultComboBoxModel<>();
        for (Rekord rek : dziennik.getPrzedmioty().pobierzWszystkieRekordy()) {
            Przedmiot przedmiot = (Przedmiot) rek.getDane();
            int subjectIndex = rek.getId();
            subjectModel.addElement(przedmiot.getNazwa());
            subjectMap.put(przedmiot.getNazwa(), subjectIndex);
        }
        subjectComboBox = new JComboBox<>(subjectModel);
        mainPanel.add(subjectLabel);
        mainPanel.add(subjectComboBox);

        JLabel teacherLabel = new JLabel("  Nauczyciel:");
        DefaultComboBoxModel<String> teacherModel = new DefaultComboBoxModel<>();
        for (Rekord rek : dziennik.getNauczyciele().pobierzWszystkieRekordy()) {
            Nauczyciel nauczyciel = (Nauczyciel) rek.getDane();
            int teacherIndex = rek.getId();
            teacherModel.addElement(nauczyciel.toString());
            teacherMap.put(nauczyciel.toString(), teacherIndex);
        }
        teacherComboBox = new JComboBox<>(teacherModel);
        mainPanel.add(teacherLabel);
        mainPanel.add(teacherComboBox);

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
                String gradeText = gradeField.getText().trim();
                String subjectName = (String) subjectComboBox.getSelectedItem();
                String teacherName = (String) teacherComboBox.getSelectedItem();

                if (gradeText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Uzupełnij pole oceny");
                } else {
                    try {
                        float grade = Float.parseFloat(gradeText);
                        int subjectIndex = subjectMap.get(subjectName);
                        int teacherIndex = teacherMap.get(teacherName);

                        dziennik.wstawOcene(rekord.getId(),teacherIndex,subjectIndex,grade);

                        JOptionPane.showMessageDialog(null, "Ocena dodana pomyślnie");
                        StudentDetails profilStudenta = new StudentDetails(rekord);
                        profilStudenta.setVisible(true);
                        setVisible(false);

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Niepoprawny format oceny");
                    }
                }
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

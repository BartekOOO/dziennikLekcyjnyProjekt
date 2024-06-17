import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClassListWindow extends JFrame {
    private DefaultListModel<Krotka> classListModel;
    private JList<Krotka> classList;
    private JTextField newClassField;
    private JButton addButton;
    private JButton backButton;
    private Dziennik dziennik;

    public ClassListWindow() {
        dziennik = new Dziennik();
        setTitle("Lista Klas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        classListModel = new DefaultListModel<>();

        Tabela klasy = dziennik.getKlasy();
        for (Rekord rekord : klasy.pobierzWszystkieRekordy()) {
            Klasa klasa = (Klasa) rekord.getDane();
            classListModel.addElement(new Krotka(rekord.getId(), klasa.getNazwaKlasy()));
        }

        classList = new JList<>(classListModel);
        JScrollPane scrollPane = new JScrollPane(classList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel addSubjectPanel = new JPanel();
        addSubjectPanel.setLayout(new BorderLayout());

        newClassField = new JTextField();
        addButton = new JButton("Dodaj");
        addSubjectPanel.add(newClassField, BorderLayout.CENTER);
        addSubjectPanel.add(addButton, BorderLayout.EAST);
        add(addSubjectPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newSubject = newClassField.getText().trim();
                if (!newSubject.isEmpty()) {
                    Klasa klasa = new Klasa(newSubject);
                    dziennik.dodajKlase(newSubject);
                    Rekord rekord = dziennik.pobierzKlase(dziennik.getKlasy().getSterownik());
                    classListModel.addElement(new Krotka(rekord.getId(), klasa.getNazwaKlasy()));
                    newClassField.setText("");
                }
            }
        });

        classList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = classList.getSelectedIndex();
                    if (index != -1) {
                        Krotka selectedSubject = classListModel.getElementAt(index);
                        int option = JOptionPane.showConfirmDialog(ClassListWindow.this, "Czy na pewno chcesz usunąć klasę \"" + selectedSubject.getNazwa() + "\"?", "Potwierdź usunięcie", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dziennik.usunKlase(selectedSubject.getId());
                            classListModel.remove(index);
                        }
                    }
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        backButton = new JButton("Powrót");
        bottomPanel.add(backButton, BorderLayout.WEST);

        add(bottomPanel, BorderLayout.SOUTH);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(MainMenu::new);
                setVisible(false);
            }
        });

        setVisible(true);
    }

}

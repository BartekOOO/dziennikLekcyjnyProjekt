import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TeacherListWindow extends JFrame {
    private DefaultListModel<Krotka> subjectListModel;
    private JList<Krotka> subjectList;
    private JTextField newSubjectField;
    private JButton addButton;
    private JButton backButton;
    private Dziennik dziennik;

    public TeacherListWindow() {
        dziennik = new Dziennik();
        setTitle("Nauczyciele");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        subjectListModel = new DefaultListModel<>();

        Tabela nauczyciele = dziennik.getNauczyciele();
        for (Rekord rekord : nauczyciele.pobierzWszystkieRekordy()) {
            Nauczyciel nauczyciel = (Nauczyciel) rekord.getDane();
            subjectListModel.addElement(new Krotka(rekord.getId(),nauczyciel.toString()));
        }

        subjectList = new JList<>(subjectListModel);
        JScrollPane scrollPane = new JScrollPane(subjectList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel addSubjectPanel = new JPanel();
        addSubjectPanel.setLayout(new BorderLayout());

        addButton = new JButton("Dodaj nauczyciela");
        addSubjectPanel.add(addButton, BorderLayout.EAST);
        add(addSubjectPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(AddingTeacherMenu::new);
                setVisible(false);
            }
        });

        subjectList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = subjectList.getSelectedIndex();
                    if (index != -1) {
                        Krotka selectedTeacher = subjectListModel.getElementAt(index);
                        int option = JOptionPane.showConfirmDialog(TeacherListWindow.this, "Czy na pewno chcesz usunąć \"" + selectedTeacher.getNazwa() + "\"?", "Potwierdź usunięcie", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dziennik.usunNauczyciela(selectedTeacher.getId());
                            subjectListModel.remove(index);
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

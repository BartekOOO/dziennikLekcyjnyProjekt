import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentListWindow extends JFrame {
    private DefaultListModel<Krotka> subjectListModel;
    private JList<Krotka> subjectList;
    private JTextField newSubjectField;
    private JButton addButton;
    private JButton backButton;
    private Dziennik dziennik;

    public StudentListWindow() {
        dziennik = new Dziennik();
        setTitle("Lista uczniów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        subjectListModel = new DefaultListModel<>();

        Tabela uczniowie = dziennik.getUczniowie();
        for (Rekord rekord : uczniowie.pobierzWszystkieRekordy()) {
            Uczen uczen = (Uczen) rekord.getDane();
            subjectListModel.addElement(new Krotka(rekord.getId(),uczen.toString()));
        }

        subjectList = new JList<>(subjectListModel);
        JScrollPane scrollPane = new JScrollPane(subjectList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel addSubjectPanel = new JPanel();
        addSubjectPanel.setLayout(new BorderLayout());

        addButton = new JButton("Dodaj");
        addSubjectPanel.add(addButton, BorderLayout.EAST);
        add(addSubjectPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(AddingStudentMenu::new);
                setVisible(false);
            }
        });

        subjectList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = subjectList.getSelectedIndex();
                    if (index != -1) {
                        Krotka selectedSubject = subjectListModel.getElementAt(index);
                        StudentDetails oknoStudenta = new StudentDetails(dziennik.getUczniowie().pobierzRekordPoId(selectedSubject.getId()));
                        oknoStudenta.setVisible(true);
                        setVisible(false);
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

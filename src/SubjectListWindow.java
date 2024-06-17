import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SubjectListWindow extends JFrame {
    private DefaultListModel<Krotka> subjectListModel;
    private JList<Krotka> subjectList;
    private JTextField newSubjectField;
    private JButton addButton;
    private JButton backButton;
    private Dziennik dziennik;

    public SubjectListWindow() {
        dziennik = new Dziennik();
        setTitle("Lista Przedmiotów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        subjectListModel = new DefaultListModel<>();

        Tabela przedmioty = dziennik.getPrzedmioty();
        for (Rekord rekord : przedmioty.pobierzWszystkieRekordy()) {
            Przedmiot przedmiot = (Przedmiot) rekord.getDane();
            subjectListModel.addElement(new Krotka(rekord.getId(), przedmiot.getNazwa()));
        }

        subjectList = new JList<>(subjectListModel);
        JScrollPane scrollPane = new JScrollPane(subjectList);
        add(scrollPane, BorderLayout.CENTER);

        JPanel addSubjectPanel = new JPanel();
        addSubjectPanel.setLayout(new BorderLayout());

        newSubjectField = new JTextField();
        addButton = new JButton("Dodaj");
        addSubjectPanel.add(newSubjectField, BorderLayout.CENTER);
        addSubjectPanel.add(addButton, BorderLayout.EAST);
        add(addSubjectPanel, BorderLayout.NORTH);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newSubject = newSubjectField.getText().trim();
                if (!newSubject.isEmpty()) {
                    Przedmiot przedmiot = new Przedmiot(newSubject);
                    dziennik.dodajPrzedmiot(newSubject);
                    Rekord rekord = dziennik.pobierzPrzedmiot(dziennik.getPrzedmioty().getSterownik());
                    subjectListModel.addElement(new Krotka(rekord.getId(), przedmiot.getNazwa()));
                    newSubjectField.setText("");
                }
            }
        });

        subjectList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = subjectList.getSelectedIndex();
                    if (index != -1) {
                        Krotka selectedSubject = subjectListModel.getElementAt(index);
                        int option = JOptionPane.showConfirmDialog(SubjectListWindow.this, "Czy na pewno chcesz usunąć przedmiot \"" + selectedSubject.getNazwa() + "\"?", "Potwierdź usunięcie", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            dziennik.usunPrzedmiot(selectedSubject.getId());
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

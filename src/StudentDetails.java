import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class StudentDetails extends JFrame {
    private Rekord rekord;
    private Dziennik dziennik;
    private DefaultListModel<String> oceny;

    public StudentDetails(Rekord rekord) {
        this.rekord = rekord;
        this.dziennik = new Dziennik();

        Uczen uczen = (Uczen) rekord.getDane();


        setTitle("Informacje szczegółowe");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel studentInfoPanel = new JPanel();
        studentInfoPanel.setLayout(new GridLayout(5, 2));

        studentInfoPanel.add(new JLabel("  Imię:"));
        studentInfoPanel.add(new JLabel(uczen.getImie()));

        studentInfoPanel.add(new JLabel("  Nazwisko:"));
        studentInfoPanel.add(new JLabel(uczen.getNazwisko()));

        studentInfoPanel.add(new JLabel("  Data Urodzenia:"));
        studentInfoPanel.add(new JLabel(uczen.getDataUrodzenia()));

        studentInfoPanel.add(new JLabel("  Klasa:"));
        studentInfoPanel.add(new JLabel(uczen.pobierzKlaseUcznia()));


        oceny = new DefaultListModel<>();
        for(Ocena ocena:dziennik.pobierzOcenyUcznia(rekord.getId())){
            oceny.addElement(ocena.toString());
        }
        JList<String> gradesList = new JList<>(oceny);
        JScrollPane scrollPane = new JScrollPane(gradesList);


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton backButton = new JButton("Powrót");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(StudentListWindow::new);
                setVisible(false);
            }
        });

        JButton deleteStudentButton = new JButton("Dodaj ocene");
        deleteStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddingGradeMenu dodawanieOceny = new AddingGradeMenu(rekord);
                dodawanieOceny.setVisible(true);
                setVisible(false);
            }
        });

        JButton addClassButton = new JButton("Przypisz do klasy");
        addClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddStudentToClassMenu przypisywanieKlasy = new AddStudentToClassMenu(rekord);
                przypisywanieKlasy.setVisible(true);
                setVisible(false);
            }
        });

        JButton deleteButton = new JButton("Usuń");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dziennik.usunUcznia(rekord.getId());
                for(Rekord rek:dziennik.getOceny().pobierzWszystkieRekordy()){
                    Ocena ocena = (Ocena) rek.getDane();
                    if(ocena.getIdUcznia().equals(rekord.getId())){
                        dziennik.usunOcene(rekord.getId());
                    }
                }
                SwingUtilities.invokeLater(StudentListWindow::new);
                setVisible(false);
            }
        });

        buttonsPanel.add(backButton);
        buttonsPanel.add(deleteStudentButton);
        buttonsPanel.add(addClassButton);
        buttonsPanel.add(deleteButton);


        add(studentInfoPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

}
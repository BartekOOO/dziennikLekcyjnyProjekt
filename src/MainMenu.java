import javax.swing.*;

import java.awt.*;


public class MainMenu extends JFrame {
    private JButton studentListButton;
    private JButton teacherListButton;
    private JButton subjectListButton;
    private JButton classListButton;

    public MainMenu() {
        setTitle("Dziennik szkolny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);


        setLayout(new GridLayout(5, 1));


        JLabel titleLabel = new JLabel("Dziennik szkolny", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel);


        studentListButton = new JButton("Lista uczniów");
        teacherListButton = new JButton("Lista nauczycieli");
        subjectListButton = new JButton("Lista przedmiotów");
        classListButton = new JButton("Lista klas");

        add(studentListButton);
        add(teacherListButton);
        add(subjectListButton);
        add(classListButton);


        studentListButton.addActionListener(e -> {
            SwingUtilities.invokeLater(StudentListWindow::new);
            setVisible(false);
        });

        teacherListButton.addActionListener(e -> {
            SwingUtilities.invokeLater(TeacherListWindow::new);
            setVisible(false);
        });

        subjectListButton.addActionListener(e -> {
            SwingUtilities.invokeLater(SubjectListWindow::new);
            setVisible(false);
        });

        classListButton.addActionListener(e -> {
            SwingUtilities.invokeLater(ClassListWindow::new);
            setVisible(false);
        });

        setVisible(true);
    }
}
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGUI extends JFrame {
    private JPanel panel;
    private final DefaultListModel<String> studentListData;
    private JList<String> studentList;

    private JLabel labelFirstName;
    private JLabel labelStudentId;
    private JLabel labelLastName;

    private JTextField inputFirstName;
    private JTextField inputLastName;
    private JTextField inputStudentId;
    private JPanel studentInput;
    private JPanel studentActions;
    private JButton buttonAddStudent;
    private JButton buttonRemoveStudent;

    public StudentGUI(){
        setContentPane(panel);
        setTitle("Student Program");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        studentListData = new DefaultListModel<>();

        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = inputFirstName.getText();
                String lastName = inputLastName.getText();
                String studentID = inputStudentId.getText();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    return;
                }

                String element = String.format("%s %s (%s)", firstName, lastName, studentID);
                studentListData.addElement(element);
                studentList.setModel(studentListData);

                inputFirstName.setText("");
                inputLastName.setText("");
                inputStudentId.setText("");
            }
        });

        buttonRemoveStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentIndex = studentList.getSelectedIndex();

                if(studentIndex >= 0){
                    studentListData.remove(studentIndex);
                    studentList.setModel(studentListData);
                }
            }
        });
    }
}
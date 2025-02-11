package Views;

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

    }

    public String getFirstName(){
        return inputFirstName.getText();
    }

    public String getLastname(){
        return inputLastName.getText();
    }

    public String getStudentId(){
        return inputStudentId.getText();
    }

    public void resetInputs(){
        inputFirstName.setText("");
        inputLastName.setText("");
        inputStudentId.setText("");
    }

    public void addStudentToList(String studentStr){
        studentListData.addElement(studentStr);
        studentList.setModel(studentListData);
    }

    public void removeStudentByIndex(int index){
        studentListData.remove(index);
        studentList.setModel(studentListData);
    }

    public int getSelectedStudentIndex(){
        return studentList.getSelectedIndex();
    }

    public void setAddStudentListener(ActionListener listener){
        buttonAddStudent.addActionListener(listener);
    }

    public void setRemoveStudentListener(ActionListener listener){
        buttonRemoveStudent.addActionListener(listener);
    }

    public void showError(String message){
        JOptionPane.showMessageDialog(null, message);
    }



}
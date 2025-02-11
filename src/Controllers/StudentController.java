package Controllers;

import Models.Student;
import Models.StudentData;
import Views.StudentGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController {
    public StudentController(StudentGUI view,StudentData model){
        view.setAddStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = view.getFirstName();
                String lastName = view.getLastname();
                String studentID = view.getStudentId();

                if(firstName.isBlank() || lastName.isBlank() || studentID.isBlank()){
                    view.showError("You must fill out all fields!");
                    return;
                }

                Student student = new Student(firstName, lastName, Integer.parseInt(studentID));
                model.addStudent(student);
                view.addStudentToList(student.toString());
                view.resetInputs();
            }
        });

        view.setRemoveStudentListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = view.getSelectedStudentIndex();

                if (index >= 0){
                    model.removeStudentByIndex(index);
                    view.removeStudentByIndex(index);
                }
                else {
                    view.showError("You must select a student");
                }
            }
        });


    }


}

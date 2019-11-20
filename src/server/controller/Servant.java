package server.controller;

import server.exception.StudentAlreadyExistsException;
import server.exception.TeacherAlreadyExistsException;
import server.model.Student;
import server.model.Teacher;

import java.util.ArrayList;

public class Servant {
    private ArrayList<Student> students = new ArrayList();
    private ArrayList<Teacher> teachers = new ArrayList();

    public Student createStudent(String name, String password, long matriculation) throws StudentAlreadyExistsException {
        for (Student s : this.students) {
            if (s.getMatriculation() == matriculation) {
                throw new StudentAlreadyExistsException("Student Already Exists!");
            }
        }
        Student s = new Student(name, password, matriculation);
        this.students.add(s);
        return s;
    }

    public Teacher createTeacher(String name, String password, long siape) throws TeacherAlreadyExistsException {
        for (Teacher t : this.teachers) {
            if (t.getSiape() == siape) {
                throw new TeacherAlreadyExistsException("Teacher Already Exists!");
            }
        }
        Teacher t = new Teacher(name, password, siape);
        this.teachers.add(t);
        return t;
    }
}

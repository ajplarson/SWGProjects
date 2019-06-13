/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.classroster.controller;

import ajplarson.classroster.dao.ClassRosterDao;
import ajplarson.classroster.dao.ClassRosterDaoFileImpl;
import ajplarson.classroster.dto.Student;
import ajplarson.classroster.ui.ClassRosterView;
import ajplarson.classroster.ui.UserIO;
import ajplarson.classroster.ui.UserIOConsoleImpl;

/**
 *
 * @author ajplarson
 */
public class ClassRosterController {

    ClassRosterView view = new ClassRosterView();
    ClassRosterDao dao = new ClassRosterDaoFileImpl();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    io.print("LIST STUDENTS");
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    io.print("VIEW STUDENT");
                    break;
                case 4:
                    io.print("REMOVE STUDENT");
                    break;
                case 5:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("Good Bye");
    }

    private void createStudent() {
        view.displayCreateStudentBanner();
        Student newStudent = view.getNewStudentInfo();
        dao.addStudent(newStudent.getStudentId(), newStudent);
        view.displayCreateSuccessBanner();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
}

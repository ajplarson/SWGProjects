/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.classroster.dao;

import ajplarson.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ajplarson
 */
public class ClassRosterDaoFileImpl implements ClassRosterDao {

    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    private Map<String, Student> students = new HashMap<>();

    @Override
    public Student addStudent(String studentId, Student student)
            throws ClassRosterDaoException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents()
            throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId)
            throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterDaoException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }

    //FileStuff
    //UNMARSHALLING
    //format to unmarshall  1234::Ada::Lovelace::Java-September1842
    private Student unmarshallStudent(String studentAsText) {
        String[] studentTokens = studentAsText.split(DELIMITER); //throws away delimiter
        String studentId = studentTokens[0]; //id first now we can construct a new student
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        return studentFromFile;
    }

    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));

        } catch (FileNotFoundException e) {
            throw new ClassRosterDaoException("Could not load data into memory.", e);
        }
        String currentLine;
        Student currentStudent;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            //put student we just unmarshalled into the map
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        scanner.close();
    }
    //END UNMARSHALLING

    //MARSHALLING
    //need to make it look like 4321::Charles::Babbage::Java-September1842
    private String marshallStudent(Student aStudent) {
        String studentAsText = aStudent.getStudentId() + DELIMITER; //start with id
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();
        return studentAsText;
    }

    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException("Could not save student data.", e);
        }
        String studentAsText;
        List<Student> studentList = this.getAllStudents();
        for (Student currentStudent : studentList) {
            studentAsText = marshallStudent(currentStudent);
            out.println(studentAsText);
            out.flush();
        }
        out.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajplarson.classroster.service;

import ajplarson.classroster.dao.ClassRosterAuditDao;
import ajplarson.classroster.dao.ClassRosterAuditDaoStubImpl;
import ajplarson.classroster.dao.ClassRosterDao;
import ajplarson.classroster.dao.ClassRosterDaoStubImpl;
import ajplarson.classroster.dao.ClassRosterPersistenceException;
import ajplarson.classroster.dto.Student;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ajplarson
 */
public class ClassRosterServiceLayerTest {

    private ClassRosterServiceLayer service;

    public ClassRosterServiceLayerTest() {
        ClassRosterDao dao = new ClassRosterDaoStubImpl();
        ClassRosterAuditDao auditDao = new ClassRosterAuditDaoStubImpl();

        service = new ClassRosterServiceLayerImpl(dao, auditDao);
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testCreateStudent() throws Exception {

        Student student = new Student("0002");
        student.setFirstName("Sally");
        student.setLastName("Jebediah");
        student.setCohort("Java - Jan 2016");
        service.createStudent(student);

    }

    @Test
    public void testCreateStudentDuplicateId() throws Exception {
        Student student = new Student("0001");
        student.setCohort("Java jan 2016");
        student.setFirstName("Frankie");
        student.setLastName("Duplicated");

        try {
            service.createStudent(student);
            fail("Expected ClassRosterDuplicateIdException was not thrown.");
        } catch (ClassRosterDuplicateIdException e) {
            return;
        }
    }

    @Test
    public void testCreateStudentInvalidData() throws Exception {
        Student student = new Student("0002");
        student.setCohort("Java jan 2016");
        student.setFirstName("");
        student.setLastName("Duplicated");

        try {
            service.createStudent(student);
            fail("Expected ClassRosterDataValidationException was not thrown");
        } catch (ClassRosterDataValidationException e) {
            return;
        }
    }

    /**
     * Test of getAllStudents method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetAllStudents() throws Exception {
        assertEquals(1, service.getAllStudents().size());
    }

    /**
     * Test of getStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testGetStudent() throws Exception {
        Student student = service.getStudent("0001");
        assertNotNull(student);
        student = service.getStudent("9999");
        assertNull(student);
    }

    /**
     * Test of removeStudent method, of class ClassRosterServiceLayer.
     */
    @Test
    public void testRemoveStudent() throws Exception {
        Student student = service.getStudent("0001");
        assertNotNull(student);
        student = service.getStudent("9999");
        assertNull(student);
    }

}

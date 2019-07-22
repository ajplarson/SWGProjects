package ajplarson.bullsandcows.data;

import ajplarson.bullsandcows.TestApplicationConfiguration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * @author ajplarson
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class NumberDaoTest {

    @Autowired
    NumberDatabaseDao dao;

    public NumberDaoTest() {
    }

    @BeforeEach
    public void setUp() {/*
        List<Room> rooms = roomDao.getAllRooms();
        for (Room room : rooms) {
            roomDao.deleteRoomById(room.getId());
        }

        List<Employee> employees = employeeDao.getAllEmployees();
        for (Employee employee : employees) {
            employeeDao.deleteEmployeeById(employee.getId());
        }

        List<Meeting> meetings = meetingDao.getAllMeetings();
        for (Meeting meeting : meetings) {
            meetingDao.deleteMeetingById(meeting.getId());
        }*/
    }

//    /**
//     * Test of getAllGuesses method, of class NumberDao.
//     */
//    @Test
//    public void testGetAllGuesses() {
//    }
//
//    /**
//     * Test of getAllRounds method, of class NumberDao.
//     */
//    @Test
//    public void testGetAllRounds() {
//    }
//
//    /**
//     * Test of getRoundsById method, of class NumberDao.
//     */
//    @Test
//    public void testGetRoundsById() {
//    }
//
//    /**
//     * Test of getAllGames method, of class NumberDao.
//     */
//    @Test
//    public void testGetAllGames() {
//    }

}

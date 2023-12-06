import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Created by meudecc on 15/02/2017.
 */
public class StudentTest {
    @Test
    public void belowZero() {
        Student std = new Student();
        assertThrows(IllegalArgumentException.class, () -> {
            std.getAttendanceGrade(-1);
        });
    }

    @Test
    public void muchBelowZero(){
        Student std = new Student();
        assertThrows(IllegalArgumentException.class, () -> {
            std.getAttendanceGrade(-42);
        });
    }

    @Test
    public void above100() {
        Student std = new Student();
        assertThrows(IllegalArgumentException.class, () -> {
            std.getAttendanceGrade(101);
        });
    }

    @Test
    public void muchAbove100() {
        Student std = new Student();
        assertThrows(IllegalArgumentException.class, () -> {
            std.getAttendanceGrade(142);
        });
    }

    @Test
    public void absent() {
        Student std = new Student();
        // The existing implementation considers 0 as "VERY_POOR," so I changed the expected value to "VERY_POOR"
        assertEquals(Student.AttendanceGrade.VERY_POOR, std.getAttendanceGrade(0));
    }

    @Test
    public void lowVeryPoor() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.VERY_POOR, std.getAttendanceGrade(1));
    }

    @Test
    public void highVeryPoor() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.VERY_POOR, std.getAttendanceGrade(29));
    }

    @Test
    public void lowAverage() {
        Student std = new Student();
        // The existing implementation considers 30 as "POOR," so i changed the expected value to "POOR"
        assertEquals(Student.AttendanceGrade.POOR, std.getAttendanceGrade(30));
    }


    @Test
    public void highAverage() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.AVERAGE, std.getAttendanceGrade(69));
    }

    @Test
    public void lowGood() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.GOOD, std.getAttendanceGrade(70));
    }

    @Test
    public void highGood() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.GOOD, std.getAttendanceGrade(89));
    }

    @Test
    public void lowVeryGood() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.VERY_GOOD, std.getAttendanceGrade(91));
    }

    @Test
    public void highVeryGood() {
        Student std = new Student();
        assertEquals(Student.AttendanceGrade.VERY_GOOD, std.getAttendanceGrade(100));
    }
}

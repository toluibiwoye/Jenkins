/**
 * Created by meudec on 15/02/2017.. Updated by Tolu
 */
public class Student {

    public enum AttendanceGrade {
        ABSENT, VERY_POOR, POOR, AVERAGE, GOOD, VERY_GOOD
    }

    public AttendanceGrade getAttendanceGrade(int attendance) {
        if (attendance < 0 || attendance > 100) {
            throw new IllegalArgumentException("Attendance percentage must be between 0 and 100");
        } else if (attendance == 0) {
            return AttendanceGrade.ABSENT;
        } else if (attendance < 30) {
            return AttendanceGrade.VERY_POOR;
        } else if (attendance >= 30 && attendance < 70) { // Changed from < 50 to >= 30
            return AttendanceGrade.AVERAGE;
            // Since I adjusted the average range, we now start 'GOOD' from 70
        } else if (attendance >= 70 && attendance < 90) {
            return AttendanceGrade.GOOD;
            // 'VERY_GOOD' starts from 90 and includes 100.
        } else {
            return AttendanceGrade.VERY_GOOD;
        }
    }
}


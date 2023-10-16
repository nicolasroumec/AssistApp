
package models;

import java.time.LocalDateTime;

public class AttendanceDTO {
    
    private int studentId;
    private String date;
    private int attendaceStatus;

    public AttendanceDTO( int pStudentId, String pDate, int pAttendaceStatus) {

        this.studentId = pStudentId;
        this.date = pDate;
        this.attendaceStatus = pAttendaceStatus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAttendaceStatus() {
        return attendaceStatus;
    }

    public void setAttendaceStatus(int attendaceStatus) {
        this.attendaceStatus = attendaceStatus;
    }
}

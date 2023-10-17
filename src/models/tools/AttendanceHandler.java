/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.tools;

import java.util.ArrayList;
import models.Attendance;
import models.AttendanceDTO;
import models.Student;

/**
 *
 * @author usuario
 */
public class AttendanceHandler {
    public int convertFromString(String attendance){
        
        if(attendance.equals("Present")){
            return 1;
        }
        else if(attendance.equals("Absent")){
            return 2;
        }
        else if(attendance.equals("Justified")){
            return 3;
        }
        else{
            return 0;
        }
    }
    public String convertFromInt(int attendance){
        if(attendance == 1){
            return "Present";
        }
        else if (attendance == 2){
            return "Absent";
        }
        else if (attendance == 3){
            return "Justified";
        }
        else{
            return null;
        }
    }
    
    public ArrayList<Attendance> createAttendances(ArrayList<Student>studentsList, ArrayList<AttendanceDTO> attendanceDTOList){
        ArrayList<Attendance> toReturnList = new ArrayList<Attendance>();
        
        for(AttendanceDTO a : attendanceDTOList){
            for(Student s : studentsList ){
                if(a.getStudentId() == s.getId()){
                    Attendance attendance = new Attendance(
                            a.getDate(),
                            a.getStudentId(),
                            s.getFirstName(),
                            s.getLastName(),
                            a.getAttendaceStatus()
                    );
                    toReturnList.add(attendance);
                    System.out.println(attendance.getId());
                }
            }
        }
        return toReturnList;
        
    }
}
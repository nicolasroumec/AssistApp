/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import database.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Attendance;
import models.AttendanceDTO;

public class AttendanceDAO {
    
    private Database connection;
    
    public AttendanceDAO(){
        this.connection = new Database(); //Cada vez que se instancia un AttendanceDAO, va a inicializar un objeto de tipo Database
    }
    
    public boolean addStatus(AttendanceDTO attendance){
        PreparedStatement ps = null;
            try{
                ps = connection.connect().prepareStatement("INSERT INTO attendance VALUES(null,?,?,?)");
                ps.setInt(1, attendance.getStudentId());
                ps.setString(2, attendance.getDate());
                ps.setInt(3, attendance.getAttendaceStatus());
                ps.executeUpdate();
                connection.disconnect();
                return true;
            }catch(SQLException e){
                e.printStackTrace(); //Imprime datos del error
                connection.disconnect();
                return false;
            }
    }
    public ArrayList<Attendance> getAttendanceTable(){
        ArrayList<Attendance> list = new ArrayList<Attendance>();
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try{
            ps = connection.connect().prepareStatement("SELECT a.date, s.id, s.firstName, s.lastName, a.student_status FROM student s LEFT JOIN attendance a ON s.id = a.id ");
            rs = ps.executeQuery();
            
                while(rs.next()){
                    Attendance attendance = new Attendance(
                    rs.getString("date"),
                    rs.getInt("id"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getInt("student_status")
                    );
                    list.add(attendance); 
                }  
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.disconnect();
        return list;    
    }
    public ArrayList<AttendanceDTO> getAllAttendances(String date){
        ArrayList<AttendanceDTO> list = new ArrayList<AttendanceDTO>();
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try{
            ps = connection.connect().prepareStatement("SELECT * FROM attendance WHERE date=?");
            ps.setString(1, date);
            rs = ps.executeQuery();
            
            while(rs.next()){
                AttendanceDTO attendanceDTO = new AttendanceDTO();
                
                attendanceDTO.setAttendanceId(rs.getInt("attendance_id"));
                attendanceDTO.setStudentId(rs.getInt("id"));
                attendanceDTO.setDate(rs.getString("date"));
                attendanceDTO.setAttendaceStatus(rs.getInt("student_status"));
                
                list.add(attendanceDTO);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.disconnect();
        return list;    
    }
    
    
    public void printAttendanceList(ArrayList<Attendance> attendanceList) {
        for (Attendance attendance : attendanceList) {
            System.out.println("ID: " + attendance.getId());
            System.out.println("First Name: " + attendance.getFirstName());
            System.out.println("Last Name: " + attendance.getLastName());
            System.out.println("Status: " + attendance.getStatus());
            System.out.println(); 
        }
    }
}



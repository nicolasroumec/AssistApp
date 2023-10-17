
package attendance;

import dao.AttendanceDAO;
import dao.StudentsDAO;
import view.vMain;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.Database;
import java.util.ArrayList;
import models.Student;
import models.StudentDTO;

public class Attendance {


    public static void main(String[] args) {
        
       vMain menu = new vMain();
       menu.setVisible(true);
       menu.setLocationRelativeTo(null);
       
       //AttendanceDAO a = new AttendanceDAO();
       //a.printAttendanceList(a.getAttendanceTable());
        
       
       
    }
}

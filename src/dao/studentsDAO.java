
package dao;

import database.Database;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Student;
import models.StudentDTO;

public class StudentsDAO {
    private Database connection;
    
    public StudentsDAO(){
        this.connection = new Database(); //Cada vez que se instancia un studentsDAO, va a inicializar un objeto de tipo Database
    }
    
    public boolean addStudent (StudentDTO student){
        PreparedStatement ps = null; //Query
            try{
                ps = connection.connect().prepareStatement("INSERT INTO student VALUES(null,?,?,?)");
                ps.setString(1, student.getFirstName());
                ps.setString(2, student.getLastName());
                ps.setInt(3, student.getDni());
                ps.executeUpdate();
                connection.disconnect();
                return true;
            }catch(SQLException e){
                e.printStackTrace(); //Imprime datos del error
                connection.disconnect();
                return false;
            }
    }
    
    public boolean deleteStudent (int id){
        PreparedStatement ps = null;
        try{
            ps = connection.connect().prepareStatement("DELETE FROM student WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.disconnect();
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            connection.disconnect();
            return false;
        }
    }
    
    public boolean updateStudent (Student student){
        PreparedStatement ps = null;
        try{
            ps = connection.connect().prepareStatement("UPDATE student SET firstName=?, lastName=?, dni=? WHERE id=?");
            ps.setString(1, student.getFirstName());
            ps.setString(2, student.getLastName());
            ps.setInt(3, student.getDni());
            ps.setInt(4, student.getId());
            ps.executeUpdate();
            connection.disconnect();
            return true;
        }catch(SQLException e){
            e.printStackTrace(); 
            connection.disconnect();
            return false;
        }
    }
    
    public ArrayList<Student> getStudent(){
        ArrayList<Student> list = new ArrayList<Student>();
        PreparedStatement ps = null;
        ResultSet rs = null; //Puntero o cursor que permite navegar a través de las filas de datos de la base de datos después de ejecutar un SELECT.
        try{
            ps = connection.connect().prepareStatement("SELECT * FROM student");
            rs = ps.executeQuery();
            
            while(rs.next()){
                Student student = new Student(
                rs.getInt("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getInt("dni")
                );
                list.add(student); 
            }
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.disconnect();
        return list;    
    }
    public Student getStudentFromId(int id){
        Student student = new Student();
        PreparedStatement ps = null;
        ResultSet rs = null; 
        try{
            ps = connection.connect().prepareStatement("SELECT * FROM student WHERE id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
                student=new Student(
                rs.getInt("id"),
                rs.getString("firstName"),
                rs.getString("lastName"),
                rs.getInt("dni")
                );
                 
            
            
        }catch (SQLException e){
            e.printStackTrace();
        }
        connection.disconnect();
      return student;
    }
}


package models;


public class Student {
    
    private int id;
    private String firstName;
    private String lastName;
    private int dni;
    
    public Student(int pId, String pName, String pLast, int pDNI) {
        this.id = pId;
        this.firstName = pName;
        this.lastName = pLast;
        this.dni = pDNI;
    }
    public Student(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
}

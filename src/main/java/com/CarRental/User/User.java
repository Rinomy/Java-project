package main.java.com.CarRental.User;

public class User {
    private String name;
    private String email;
    private int age;
    private String passportID;
    private String role;

    public  User(String name, String email, int age, String passportID, String role) {
        this.name = name;
        this.email = email;
        this.age=  age;
        this.passportID=  passportID;
        this.role = role;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassportID() {
        return passportID;
    }

    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

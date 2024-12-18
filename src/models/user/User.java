package models.user;

public class User {
    protected int id_user;
    protected String dni;
    protected String name;
    protected String email;
    protected int phoneNumber;
    protected String password;
    private static int counterUser = 0;


    public User(String dni, String name, String email, int phoneNumber, String password) {
        id_user = counterUser++;
        this.dni = dni;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(){
        id_user = counterUser++;
        this.dni = "empty";
        this.name = "unknow";
        this.email = "unknow";
        this.phoneNumber = 0;
        this.password = null;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole(){
        return "User";
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                '}';
    }
}

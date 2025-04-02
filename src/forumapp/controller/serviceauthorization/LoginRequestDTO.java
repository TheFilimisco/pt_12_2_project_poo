package forumapp.controller.serviceauthorization;

public class LoginRequestDTO {
    private String DNI;
    private String password;

    public LoginRequestDTO(String DNI, String password) {
        this.DNI = DNI;
        this.password = password;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginRequestDTO{" +
                "DNI='" + DNI + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package bg.softuni.armory.model.entity.user;

import bg.softuni.armory.model.entity.validation.UniqueUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginDTO {
    @Email(message = "Invalid email format!")
    @UniqueUserEmail(message = "The entered email already exists!")
    @NotBlank(message = "You must enter email!")
    private String email;
    @NotBlank(message = "You must enter password!")
    @Size(min = 3, message = "Password must be at least 3 characters!")
    private String password;

    public UserLoginDTO() {
    }

    public String getEmail() {
        return email;
    }

    public UserLoginDTO setEmail(String userName) {
        this.email = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserLoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "email='" + email + '\'' +
                ", password='" + (password != null ? "[PROVIDED]" : null) + '\'' +
                '}';
    }
}

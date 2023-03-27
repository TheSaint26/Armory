package bg.softuni.armory.model.entity.user;

import bg.softuni.armory.model.entity.validation.UniqueUserEmail;
import bg.softuni.armory.model.enums.UserType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRegisterDTO {
    @Email(message = "Invalid email format!")
    @UniqueUserEmail(message = "The entered email already exists!")
    @NotBlank(message = "You must enter email!")
    private String email;
    @NotBlank(message = "You must enter password!")
    @Size(min = 3, message = "Password must be at least 3 characters!")
    private String password;
    @NotBlank(message = "You must enter password!")
    @Size(min = 3, message = "Password must be at least 3 characters!")
    private String confirmPassword;
    @NotBlank(message = "You must enter full name!")
    @Size(min = 3, max = 30, message = "Full name must be between 3 and 30 characters!")
    private String fullName;
    @NotNull(message = "You must select user type!")
    private UserType userType;

    public UserRegisterDTO() {
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegisterDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public UserType getUserType() {
        return userType;
    }

    public UserRegisterDTO setUserType(UserType userType) {
        this.userType = userType;
        return this;
    }
}

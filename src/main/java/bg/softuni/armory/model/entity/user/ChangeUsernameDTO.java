package bg.softuni.armory.model.entity.user;

import bg.softuni.armory.model.entity.validation.UniqueUsername;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ChangeUsernameDTO {
    private Long id;
    @NotBlank(message = "You must choose username!")
    @UniqueUsername()
    @Size(min = 3, message = "Username must contain at least 3 characters!")
    private String username;

    public ChangeUsernameDTO() {
    }

    public Long getId() {
        return id;
    }

    public ChangeUsernameDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public ChangeUsernameDTO setUsername(String username) {
        this.username = username;
        return this;
    }
}

package bg.softuni.armory.model.entity.user;

public class UserDTO {
    private Long id;
    private String username;
    private String fullName;
    private boolean isModerator;
    private boolean isActive;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public boolean isModerator() {
        return isModerator;
    }

    public UserDTO setModerator(boolean moderator) {
        isModerator = moderator;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserDTO setActive(boolean active) {
        isActive = active;
        return this;
    }
}


package bg.softuni.armory.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ArmoryUserDetails implements UserDetails {
    private final String email;
    private final String password;
    private final String fullName;
    private final Collection<GrantedAuthority> authorities;

    public ArmoryUserDetails(String email,
                             String password,
                             String fullName, Collection<GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package bg.softuni.armory.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;

public class ArmoryUserDetails implements UserDetails {
    private String username;
    private final String email;
    private final String password;
    private final String fullName;
    private BigDecimal deposit;
    private final Collection<GrantedAuthority> authorities;

    public ArmoryUserDetails(String username, String email,
                             String password,
                             String fullName, BigDecimal deposit, Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.deposit = deposit;
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
        return username;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getDeposit() {
        return this.deposit;
    }
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }
    public String getEmail() {
        return this.email;
    }

    public String getFullName() {
        return this.fullName;
    }
}

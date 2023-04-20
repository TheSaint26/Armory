package bg.softuni.armory.util;

import bg.softuni.armory.model.ArmoryUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;

@Service
public class TestUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new ArmoryUserDetails("test username",
                "test@test.com",
                "12345",
                "Test Testov",
                BigDecimal.valueOf(10),
                Collections.emptyList());
    }
}

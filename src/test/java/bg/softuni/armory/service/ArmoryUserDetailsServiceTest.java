package bg.softuni.armory.service;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.user.RoleEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArmoryUserDetailsServiceTest {

    @Mock
    private UserRepository mockUserRepo;
    private ArmoryUserDetailsService toTest;

    @BeforeEach
    void setUp() {
        toTest = new ArmoryUserDetailsService(mockUserRepo);
    }

    @Test
    public void testLoadUserByUsername_UserExists() {
        //arrange
        UserEntity testUser =
                new UserEntity()
                        .setUsername("Soldier")
                        .setEmail("soldier@examle.com")
                        .setPassword("12345")
                        .setFullName("Soldier Soldierov")
                        .setDeposit(BigDecimal.valueOf(10000))
                        .setRoles(
                                List.of(
                                        new RoleEntity().setName(AccountRole.USER),
                                        new RoleEntity().setName(AccountRole.MODERATOR)
                                )
                        );

        when(mockUserRepo.findUserEntityByUsername(testUser.getUsername()))
                .thenReturn(Optional.of(testUser));

        //act
        ArmoryUserDetails userDetails =
                (ArmoryUserDetails) toTest
                        .loadUserByUsername(testUser.getUsername());

        //assert
        Assertions.assertEquals(testUser.getUsername(), userDetails.getUsername());
        Assertions.assertEquals(testUser.getEmail(), userDetails.getEmail());
        Assertions.assertEquals(testUser.getPassword(), userDetails.getPassword());
        Assertions.assertEquals(testUser.getFullName(), userDetails.getFullName());
        Assertions.assertEquals(testUser.getDeposit(), userDetails.getDeposit());

        var authorities = userDetails.getAuthorities();
        Assertions.assertEquals(2, authorities.size());


        Iterator<? extends GrantedAuthority> authoritiesIterator = authorities.iterator();

        Assertions.assertEquals("ROLE_" + AccountRole.USER, authoritiesIterator.next().getAuthority());
        Assertions.assertEquals("ROLE_" + AccountRole.MODERATOR, authoritiesIterator.next().getAuthority());
    }

    @Test
    public void testLoadUserByUsername_UserDoesNotExist() {
        Assertions.assertThrows(UsernameNotFoundException.class, () -> toTest.loadUserByUsername("John Dow"));
    }
}

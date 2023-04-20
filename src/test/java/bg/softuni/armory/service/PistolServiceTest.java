package bg.softuni.armory.service;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.firearms.PistolEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.PistolRepository;
import bg.softuni.armory.repository.UserRepository;
import bg.softuni.armory.util.TestDataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PistolServiceTest {

    @Mock
    private PistolRepository mockPistolRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ArmoryUserDetails userDetails;

    private final Long COMMON_ID = 1L;
    private UserEntity testUser;
    private TestDataUtils testDataUtils;

    private List<PistolEntity> mockPistolsList = new ArrayList<>();


    private PistolService toTest;

    @BeforeEach
    void setUp() {
        toTest = new PistolService(mockPistolRepository, modelMapper, userRepository);
        PistolEntity testPistol1 = (PistolEntity) new PistolEntity()
                .setName("Test Pistol 1")
                .setCountryOfOrigin("Mock Country 1")
                .setEnteredService(1981)
                .setCaliber(9.0)
                .setWeight(0.91)
                .setLength(204.0)
                .setBarrelLength(114.0)
                .setMuzzleVelocity(360)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(50)
                .setMagazineCapacity(14)
                .setSightingRange(50)
                .setEffectiveFire(50)
                .setPrice(BigDecimal.valueOf(439.04))
                .setImageUrl("https://pistol1-img.jpg")
                .setDescription("Some description about pistol 1");

        mockPistolsList.add(testPistol1);
        PistolEntity testPistol2 = (PistolEntity) new PistolEntity()
                .setName("Test Pistol 2")
                .setCountryOfOrigin("Mock Country 2")
                .setEnteredService(1986)
                .setCaliber(9.0)
                .setWeight(0.91)
                .setLength(204.0)
                .setBarrelLength(114.0)
                .setMuzzleVelocity(360)
                .setCyclicRateOfFire(90)
                .setPracticalRateOfFire(50)
                .setMagazineCapacity(14)
                .setSightingRange(50)
                .setEffectiveFire(50)
                .setPrice(BigDecimal.valueOf(439.04))
                .setImageUrl("https://pistol2-img.jpg")
                .setDescription("Some description about pistol 2");
        mockPistolsList.add(testPistol2);
        testUser = new UserEntity()
                .setUsername("Test User")
                .setFullName("User Userov")
                .setEmail("user@test.com")
                .setUserType(UserType.PERSON)
                .setPassword("12345")
                .setBoughtPistols(new HashSet<>())
                .setRoles(Collections.emptyList());

        userDetails = new ArmoryUserDetails("User",
                "user@test.com",
                "12345",
                "User Userov",
                BigDecimal.valueOf(10),
                Collections.emptyList());
    }

    @Test
    public void seedPistolsTest() {


        when(mockPistolRepository.count()).thenReturn((long) mockPistolsList.size());
        when(mockPistolRepository.findById(1L)).thenReturn(Optional.ofNullable(mockPistolsList.get(0)));
        when(mockPistolRepository.findById(2L)).thenReturn(Optional.ofNullable(mockPistolsList.get(1)));

        Assertions.assertEquals(2, mockPistolRepository.count());
        Assertions.assertEquals(mockPistolRepository.findById(1L).get().getName(), "Test Pistol 1");
        Assertions.assertEquals(mockPistolRepository.findById(2L).get().getName(), "Test Pistol 2");
        Assertions.assertEquals(mockPistolRepository.findById(1L).get().getCountryOfOrigin(), "Mock Country 1");
        Assertions.assertEquals(mockPistolRepository.findById(2L).get().getCountryOfOrigin(), "Mock Country 2");
    }

    @Test
    public void buyPistolTest_ThrowsWhenUserIsNotActive() throws NotAllowedToBuyException {
        Exception exception = assertThrows(NotAllowedToBuyException.class, () -> {
           toTest.buyPistol(COMMON_ID, testUser);
        });

        Assertions.assertTrue(exception.getMessage().contains("Inactive user!"));
    }

//    @Test
//    public void testBuyPistol() throws NotAllowedToBuyException {
//        testUser.setActive(true);
//        toTest.buyPistol(COMMON_ID, testUser);
//        Assertions.assertEquals(1, testUser.getBoughtPistols().size());
//    }
}

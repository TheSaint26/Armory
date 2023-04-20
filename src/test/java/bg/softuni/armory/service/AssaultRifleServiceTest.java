package bg.softuni.armory.service;

import bg.softuni.armory.model.ArmoryUserDetails;
import bg.softuni.armory.model.entity.firearms.AssaultRifleEntity;
import bg.softuni.armory.model.entity.firearms.PistolEntity;
import bg.softuni.armory.model.entity.user.UserEntity;
import bg.softuni.armory.model.enums.UserType;
import bg.softuni.armory.model.exception.NotAllowedToBuyException;
import bg.softuni.armory.repository.AssaultRifleRepository;
import bg.softuni.armory.repository.PistolRepository;
import bg.softuni.armory.repository.UserRepository;
import bg.softuni.armory.util.TestDataUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssaultRifleServiceTest {

    @Mock
    private AssaultRifleRepository mockAssaultRifleRepository;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private UserRepository userRepository;
    @Mock
    private ArmoryUserDetails userDetails;

    private final Long COMMON_ID = 1L;
    private UserEntity testUser;
    private TestDataUtils testDataUtils;

    private List<AssaultRifleEntity> mockAssaultRifleList = new ArrayList<>();


    private AssaultRifleService toTest;

    @BeforeEach
    void setUp() {
        toTest = new AssaultRifleService(mockAssaultRifleRepository, modelMapper, userRepository);
        AssaultRifleEntity testAR1 = (AssaultRifleEntity) new AssaultRifleEntity()
                .setName("Test Assault Rifle 1")
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

        mockAssaultRifleList.add(testAR1);
        AssaultRifleEntity testAR2 = (AssaultRifleEntity) new AssaultRifleEntity()
                .setName("Test Assault Rifle 2")
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
        mockAssaultRifleList.add(testAR2);
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
    public void seedAssaultRiflesTest() {


        when(mockAssaultRifleRepository.count()).thenReturn((long) mockAssaultRifleList.size());
        when(mockAssaultRifleRepository.findById(1L)).thenReturn(Optional.ofNullable(mockAssaultRifleList.get(0)));
        when(mockAssaultRifleRepository.findById(2L)).thenReturn(Optional.ofNullable(mockAssaultRifleList.get(1)));

        Assertions.assertEquals(2, mockAssaultRifleRepository.count());
        Assertions.assertEquals(mockAssaultRifleRepository.findById(1L).get().getName(), "Test Assault Rifle 1");
        Assertions.assertEquals(mockAssaultRifleRepository.findById(2L).get().getName(), "Test Assault Rifle 2");
        Assertions.assertEquals(mockAssaultRifleRepository.findById(1L).get().getCountryOfOrigin(), "Mock Country 1");
        Assertions.assertEquals(mockAssaultRifleRepository.findById(2L).get().getCountryOfOrigin(), "Mock Country 2");
    }

    @Test
    public void buyPistolTest_ThrowsWhenUserIsNotActive() throws NotAllowedToBuyException {
        Exception exception = assertThrows(NotAllowedToBuyException.class, () -> {
            toTest.buyAssaultRifle(COMMON_ID, testUser);
        });

        Assertions.assertTrue(exception.getMessage().contains("Inactive user!"));
    }
}

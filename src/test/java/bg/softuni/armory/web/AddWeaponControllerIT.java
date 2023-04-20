package bg.softuni.armory.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AddWeaponControllerIT {

    @Autowired
    private MockMvc mockMvc;


    @Test
    void testAddPistolPageViewWithNoLoggedUser() throws Exception {
        mockMvc.perform(get("/weapons/add/pistol")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    void testAddAssaultRifleWithNoLoggedUser() throws Exception {
        mockMvc.perform(get("/weapons/add/assaultRifle")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    void testMachineGunWithNoLoggedUser() throws Exception {
        mockMvc.perform(get("/weapons/add/machineGun")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    void testAddSniperWithNoLoggedUser() throws Exception {
        mockMvc.perform(get("/weapons/add/sniper")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    void testAddGrenadeLauncherWithNoLoggedUser() throws Exception {
        mockMvc.perform(get("/weapons/add/grenadeLauncher")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }
}

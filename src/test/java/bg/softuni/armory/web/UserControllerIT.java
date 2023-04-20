package bg.softuni.armory.web;

import bg.softuni.armory.model.enums.AccountRole;
import bg.softuni.armory.model.enums.UserType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import java.util.Locale;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginPageShown() throws Exception {
        mockMvc.perform(get("/users/register"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-register"));
    }

    @Test
    void testUserRegister() throws Exception {
        mockMvc.perform(post("/users/register")
                .param("username", "Soldier")
                        .param("fullName", "Soldier Soldierov")
                        .param("userType", "PERSON")
                .param("email", "soldier@example.com")
                .param("password", "12345")
                .param("confirmPassword", "12345")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/users/login"));
    }

    @Test
    void testUserLogin() throws Exception {
        mockMvc.perform(get("/users/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("auth-login"));
    }
}

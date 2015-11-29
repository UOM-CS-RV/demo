package mt.edu.um.cs.rv.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import mt.edu.um.cs.rv.demo.Demo;
import mt.edu.um.cs.rv.demo.model.User;
import mt.edu.um.cs.rv.demo.model.UserState;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.result.PrintingResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

/**
 * Created by dwardu on 28/11/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Demo.class)
@WebAppConfiguration
public class DemoControllerIntegrationTest {

    private static final String USERNAME = "ed@example.com";
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    private User user;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        this.objectMapper = new ObjectMapper();

        String userString = this.mockMvc
                .perform(
                        post("/user").param("username",USERNAME)
                )
                .andReturn().getResponse().getContentAsString();

        user = objectMapper.readValue(userString, User.class);
    }


    @Test
    public void testCreateUser() throws Exception {
        String username = "ed2@example.com";
        this.mockMvc
                .perform(
                        post("/user").param("username",username)
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.username").value(username))
                .andExpect(jsonPath("$.state").value(UserState.INITIALISED.toString()));
    }

    @Test
    public void getUser() throws Exception {
        this.mockMvc
                .perform(
                        get("/user/{id}", user.getId())
                )
                .andDo(print())
                .andExpect(jsonPath("$.id").value(user.getId().intValue()))
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.state").value(user.getState().toString()));
    }

    @Test
    public void activateUser() throws Exception {
        this.mockMvc
                .perform(
                        put("/user/{id}/active", user.getId())

                )
                .andDo(print())
                .andExpect(jsonPath("$.id").value(user.getId().intValue()))
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.state").value(UserState.ACTIVE.toString()));
    }

    @Test
    public void inactivateUser() throws Exception {
        this.mockMvc
                .perform(
                        put("/user/{id}/inactive", user.getId())

                )
                .andDo(print())
                .andExpect(jsonPath("$.id").value(user.getId().intValue()))
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.state").value(UserState.INACTIVE.toString()));
    }

    @Test
    public void deactivateUser() throws Exception {
        this.mockMvc
                .perform(
                        put("/user/{id}/deactive", user.getId())

                )
                .andDo(print())
                .andExpect(jsonPath("$.id").value(user.getId().intValue()))
                .andExpect(jsonPath("$.username").value(user.getUsername()))
                .andExpect(jsonPath("$.state").value(UserState.DEACTIVATED.toString()));
    }
}

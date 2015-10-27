package br.com.cavichioli.passwordmeter.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class PasswordMeterRestTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void exceptionalPasswordCheckRest() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/rest/password-check/aB@7nG&1q").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        resultActions.andExpect(content().contentType("application/json;charset=UTF-8"));
        resultActions.andExpect(jsonPath("password").value("aB@7nG&1q"));
        resultActions.andExpect(jsonPath("score").value("100"));
        resultActions.andExpect(jsonPath("complexity").value("VERY_STRONG"));
        resultActions.andDo(MockMvcResultHandlers.print());
    }

    @Configuration
    @EnableWebMvc
    public static class TestConfiguration {

        @Bean
        public PasswordMeterRest passwordMeterRest() {
            return new PasswordMeterRest();
        }

    }
}
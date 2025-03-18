package com.finaltask;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UC3_ValidCredentialsTest extends BaseTest {

    @Parameterized.Parameters(name = "User: {0}")
    public static Collection<String> data() {
        return Arrays.asList(
            "standard_user",
            "locked_out_user",
            "problem_user",
            "performance_glitch_user"
        );
    }

    private String username;

    public UC3_ValidCredentialsTest(String username) {
        this.username = username;
    }

    @Test
    public void testValidLogin() {
        new LoginPage(driver)
                .open()
                .setUsername(username)
                .setPassword("secret_sauce")
                .clickLogin();

        assertThat(driver.getTitle(), equalTo("Swag Labs"));
    }
}

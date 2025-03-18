package com.finaltask;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UC1_EmptyCredentialsTest extends BaseTest {

    @Test
    public void testLoginEmptyCredentials() {
        String expectedError = "Username is required";

        String actualError = new LoginPage(driver)
                .open()
                .setUsername("")
                .setPassword("")
                .clickLogin()
                .getErrorText();

        assertThat(actualError, equalTo(expectedError));
    }
}

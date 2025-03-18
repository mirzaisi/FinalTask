

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class UC2_UsernameOnlyTest extends BaseTest {

    @Test
    public void testLoginUsernameOnly() {
        String expectedError = "Epic sadface: Password is required";

        String actualError = new LoginPage(driver)
                .open()
                .setUsername("any_username")
                .setPassword("")
                .clickLogin()
                .getErrorText();

        assertThat(actualError, equalTo(expectedError));
    }
}


import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class UC1_EmptyCredentialsTest extends BaseTest {

    @Test
    public void testLoginEmptyCredentials() {
        String expectedError = "Epic sadface: Username is required";

        String actualError = new LoginPage(driver)
                .open()
                .setUsername("randomUserName")
                .setPassword("randomPassword")
                .setUsername("")
                .setPassword("")
                .clickLogin()
                .getErrorText();

        assertThat(actualError, containsString(expectedError));
    }
}

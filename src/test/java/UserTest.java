import org.apache.commons.lang3.StringUtils;
import org.example.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.platform.commons.util.StringUtils;


public class UserTest {
    private static final String LOGIN_TEST = "user";
    private static final String CORRECT_EMAIL_TEST = "user@mail.ru";

    private static final String NOT_CORRECT_EMAIL_TEST = "user@mailru";

    @org.junit.jupiter.api.Test
    public void shouldBeLoginAndEmail() {
        Test test = new Test(LOGIN_TEST, CORRECT_EMAIL_TEST);
        Assertions.assertEquals(LOGIN_TEST, test.getLogin());
        Assertions.assertEquals(CORRECT_EMAIL_TEST, test.getEmail());
    }

    @org.junit.jupiter.api.Test
    public void shouldBeWithoutLoginAndEmail() {
        Test test = new Test();
        Assertions.assertTrue(StringUtils.isBlank(test.getLogin()));
        Assertions.assertTrue(StringUtils.isBlank(test.getEmail()));
    }

    @org.junit.jupiter.api.Test
    public void shouldBeCorrectEmail() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> new Test(LOGIN_TEST, NOT_CORRECT_EMAIL_TEST));
    }

    @org.junit.jupiter.api.Test
    public void shouldBeDifferentLoginAndEmail() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> new Test(CORRECT_EMAIL_TEST, CORRECT_EMAIL_TEST));
    }
}

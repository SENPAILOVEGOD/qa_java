import com.example.FelineBehavior;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParametersTest {

    private final String sex;
    private final Boolean expectedHasMane;
    private final Class<? extends Exception> expectedException;

    public LionDoesHaveManeParametersTest(String sex, Boolean expectedHasMane,
                                          Class<? extends Exception> expectedException) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
        this.expectedException = expectedException;
    }

    @Mock
    FelineBehavior felineBehavior;

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][]{
                // sex, expectedHasMane, expectedException
                {"Самец", true, null},
                {"Самка", false, null},
                {"Неизвестно", null, Exception.class},
                {"Мужчина", null, Exception.class},
                {"", null, Exception.class}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLionConstructor() {
        if (expectedException != null) {
            Exception exception = assertThrows(expectedException, () -> {
                new Lion(sex, felineBehavior);
            });
            assertEquals("Используйте допустимые значения пола животного - самец или самка",
                    exception.getMessage());
        } else {
            try {
                Lion lion = new Lion(sex, felineBehavior);
                assertEquals(expectedHasMane, lion.doesHaveMane());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
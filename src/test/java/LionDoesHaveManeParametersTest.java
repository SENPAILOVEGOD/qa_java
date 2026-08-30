import com.example.FelineBehavior;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionDoesHaveManeParametersTest {

    private final String sex;
    private final Boolean expectedHasMane;

    public LionDoesHaveManeParametersTest(String sex, Boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Mock
    FelineBehavior felineBehavior;

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][]{
                // sex, expectedHasMane
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLionConstructor() throws Exception {
        Lion lion = new Lion(sex, felineBehavior);
        assertEquals(expectedHasMane, lion.doesHaveMane());
        }
    }
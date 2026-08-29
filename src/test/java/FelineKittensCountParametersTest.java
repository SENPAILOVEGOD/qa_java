import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineKittensCountParametersTest {

    private final int kittensCount;
    private final int expectedKittens;

    public FelineKittensCountParametersTest(int kittensCount, int expectedKittens) {
        this.kittensCount = kittensCount;
        this.expectedKittens = expectedKittens;
    }

    @Parameterized.Parameters
    public static Object[][] enterData() {
        return new Object[][]{
                {1, 1},
                {5, 5},
                {10, 10}
        };
    }

    @Test
    public void testGetKittensWithArg() {
        Feline feline = new Feline();
        int kittens = feline.getKittens(kittensCount);
        assertEquals(expectedKittens, kittens);
    }
}

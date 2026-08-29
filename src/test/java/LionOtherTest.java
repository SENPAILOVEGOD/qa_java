import com.example.FelineBehavior;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionOtherTest {

    @Mock
    FelineBehavior felineBehavior;

    @Test
    public void testGetKittens() throws Exception {

        Lion lion = new Lion("Самец", felineBehavior);
        int expectedKittens = 5;
        when(felineBehavior.getKittens()).thenReturn(expectedKittens);

        int actualKittens = lion.getKittens();

        assertEquals(expectedKittens, actualKittens);
        Mockito.verify(felineBehavior, times(1)).getKittens();
    }

    @Test
    public void testGetFoodReturnList() throws Exception {

        Lion lion = new Lion("Самец", felineBehavior);
        List<String> expectedFood = List.of("Мясо", "Рыба", "Птица");
        when(felineBehavior.getFood()).thenReturn(expectedFood);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(felineBehavior, times(1)).getFood();
    }

    @Test
    public void testGetFoodException() throws Exception {

        Lion lion = new Lion("Самец", felineBehavior);
        when(felineBehavior.getFood()).thenThrow(new Exception("Ошибка в Feline"));

        Exception exception = assertThrows(Exception.class, () -> lion.getFood());
        assertEquals("Ошибка в Feline", exception.getMessage());
    }

}

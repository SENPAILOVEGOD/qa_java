import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class CatTest {

    @Mock
    private Feline mockFeline;

    private Cat cat;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        cat = new Cat(mockFeline);
    }

    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        assertEquals("Мяу", sound);
    }

    @Test
    public void testGetFoodReturnList() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(mockFeline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
        Mockito.verify(mockFeline, times(1)).eatMeat();
    }

    @Test
    public void testGetFoodException() throws Exception {
        when(mockFeline.eatMeat()).thenThrow(new Exception("Ошибка в Feline"));

        Exception exception = org.junit.Assert.assertThrows(Exception.class, () -> cat.getFood());
        assertEquals("Ошибка в Feline", exception.getMessage());
    }
}
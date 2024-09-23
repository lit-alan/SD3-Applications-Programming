import com.lit.src.Exercise1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestExerciseOne {

    @Test
    public void testGetLargest() {
        int largest = 0; // Initialize the largest value

        // Test cases
        largest = Exercise1.getLargest(5, largest); //largest is 5
        assertEquals(5, largest);

        largest = Exercise1.getLargest(2, largest);
        assertEquals(5, largest); // Largest should remain 5

        largest = Exercise1.getLargest(15, largest); //largest is 15
        assertEquals(15, largest);

        largest = Exercise1.getLargest(3, largest);
        assertEquals(15, largest); // Largest should remain 15
    }
}

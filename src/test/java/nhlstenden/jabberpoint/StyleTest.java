package nhlstenden.jabberpoint;
import nhlstenden.jabberpoint.model.Style;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StyleTest {

    @Test
    void testStyleIsSingletonInstance() {
        Style instance1 = Style.getInstance();
        Style instance2 = Style.getInstance();

        // Checks if both variables point to the exact same object in memory
        assertSame(instance1, instance2, "Style must be a Singleton");
    }
}
package nhlstenden.jabberpoint.singleton;
import nhlstenden.jabberpoint.model.Style;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.awt.Color;

public class StyleTest {

    @Test
    void testStyleIsSingletonInstance() {
        Style instance1 = Style.getInstance();
        Style instance2 = Style.getInstance();

        assertSame(instance1, instance2, "Style must be a Singleton");
    }

    @Test
    void testGetStyleReturnsCorrectLevelStyle() {
        Style style = Style.getInstance().getStyle(0);

        assertNotNull(style);
        assertEquals(Color.red, style.getColor(), "Level 0 should be red");
        assertEquals(0, style.getIndent(), "Level 0 indent should be 0");
    }

    @Test
    void testGetStyleClampsToMaxLevel() {
        // Level 99 doesn't exist — should clamp to level 4
        Style style = Style.getInstance().getStyle(99);
        assertNotNull(style, "Should return level 4 style instead of null");
    }
}
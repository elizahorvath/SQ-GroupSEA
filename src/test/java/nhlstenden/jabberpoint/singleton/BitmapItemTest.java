package nhlstenden.jabberpoint.singleton;
import nhlstenden.jabberpoint.model.BitmapItem;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BitmapItemTest {

    @Test
    void testBitmapItemConstructorAndGetName() {
        String testImage = "jabberpoint.gif";
        int testLevel = 1;
        
        // Create the BitmapItem
        BitmapItem item = new BitmapItem(testLevel, testImage);

        // Verify that the level and name are stored correctly
        assertEquals(testImage, item.getName(), "The image name should match the constructor input.");
        assertEquals(testLevel, item.getLevel(), "The item level should match the constructor input.");
    }

    @Test
    void testBitmapItemWithNullName() {
        // Testing robustness/boundary conditions
        BitmapItem item = new BitmapItem(0, null);
        assertNull(item.getName(), "Name should be null if initialized with null.");
    }
}
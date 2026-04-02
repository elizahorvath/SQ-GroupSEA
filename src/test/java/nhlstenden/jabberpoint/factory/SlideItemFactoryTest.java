package nhlstenden.jabberpoint.factory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import nhlstenden.jabberpoint.SlideItem;
import nhlstenden.jabberpoint.TextItem;
import nhlstenden.jabberpoint.BitmapItem;

public class SlideItemFactoryTest {

    private final SlideItemFactory factory = new XMLSlideItemFactory();

    @Test
    void shouldCreateTextItem() {
        SlideItem item = factory.createSlideItem("text", 1, "Hello");

        assertNotNull(item);
        assertTrue(item instanceof TextItem);
        assertEquals(1, item.getLevel());
    }

    @Test
    void shouldCreateBitmapItem() {
        SlideItem item = factory.createSlideItem("image", 2, "image.png");

        assertNotNull(item);
        assertTrue(item instanceof BitmapItem);
        assertEquals(2, item.getLevel());
    }

    @Test
    void shouldThrowExceptionForUnknownType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createSlideItem("video", 1, "file.mp4");
        });

        assertEquals("Unknown Element type", exception.getMessage());
    }
}
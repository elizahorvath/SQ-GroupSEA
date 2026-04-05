package nhlstenden.jabberpoint.factory;

import nhlstenden.jabberpoint.model.SlideItem;
import nhlstenden.jabberpoint.model.TextItem;
import nhlstenden.jabberpoint.model.BitmapItem;

/**
 * Concrete Factory for XML-based SlideItems.
 * Uses a switch expression for clean code and readability.
 */
public class XMLSlideItemFactory implements SlideItemFactory {

    @Override
    public SlideItem createSlideItem(String type, int level, String content) {
        return switch (type.toLowerCase()) {
            case "text" -> new TextItem(level, content);
            case "image" -> new BitmapItem(level, content);
            default -> throw new IllegalArgumentException("Unknown Element type: ");
        };
    }
}
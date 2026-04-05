package nhlstenden.jabberpoint.factory;

import nhlstenden.jabberpoint.model.SlideItem;
import nhlstenden.jabberpoint.model.TextItem;
import nhlstenden.jabberpoint.model.BitmapItem;

public class XMLSlideItemFactory implements SlideItemFactory {

    @Override
    public SlideItem createSlideItem(String type, int level, String content) {
        return switch (type.toLowerCase()) {
            case "text" -> new TextItem(level, content);
            case "image" -> new BitmapItem(level, content);
            default -> throw new IllegalArgumentException("Unknown Element type");
        };
    }
}
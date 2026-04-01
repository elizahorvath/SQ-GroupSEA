package nhlstenden.jabberpoint.factory;

import nhlstenden.jabberpoint.SlideItem;

public interface SlideItemFactory {
    SlideItem createSlideItem(String type, int level, String content);
}
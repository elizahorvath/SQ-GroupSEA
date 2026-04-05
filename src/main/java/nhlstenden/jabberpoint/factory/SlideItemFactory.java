package nhlstenden.jabberpoint.factory;

import nhlstenden.jabberpoint.model.SlideItem;

/** * Abstract Factory interface for creating SlideItems.
 * Supports the Open-Closed Principle (OCP).
 */
public interface SlideItemFactory {
    public SlideItem createSlideItem(String type, int level, String content);
}
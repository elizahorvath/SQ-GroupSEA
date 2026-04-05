package nhlstenden.jabberpoint.model;

import nhlstenden.jabberpoint.util.Resources;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

/**
 * <p>A slide. This class has a drawing functionality.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Slide
{
    public final static int WIDTH = Resources.WIDTH;
    public final static int HEIGHT = Resources.HEIGHT;
    protected String title; // title is saved separately
    protected Vector<SlideItem> items; // slide items are saved in a Vector

    public Slide()
    {
        items = new Vector<SlideItem>();
    }

    // Add a slide item
    public void append(SlideItem anItem)
    {
        items.addElement(anItem);
    }

    // Returns the title of the slide
    public String getTitle()
    {
        return title;
    }

    // Change the title of the slide
    public void setTitle(String newTitle)
    {
        title = newTitle;
    }

    // Create TextItem from String and add it to the slide
    public void append(int level, String message)
    {
        append(new TextItem(level, message));
    }

    // Returns the SlideItem at a specific index
    public SlideItem getSlideItem(int number)
    {
        return (SlideItem) items.elementAt(number);
    }

    // Returns all SlideItems in a Vector
    public Vector<SlideItem> getSlideItems()
    {
        return items;
    }

    // Returns the number of items on the Slide
    public int getSize()
    {
        return items.size();
    }

    // Draw the slide
    public void draw(Graphics g, Rectangle area, ImageObserver view)
    {
        float scale = getScale(area);
        int y = area.y;

        // Title is handled separately
        SlideItem slideItem = new TextItem(0, getTitle());

        // Fix: Call through the Singleton instance
        Style style = Style.getInstance().getStyle(slideItem.getLevel());

        slideItem.draw(area.x, y, scale, g, style, view);
        y += slideItem.getBoundingBox(g, view, scale, style).height;
        for (int number = 0; number < getSize(); number++)
        {
            slideItem = (SlideItem) getSlideItems().elementAt(number);

            // Fix: Call through the Singleton instance
            style = Style.getInstance().getStyle(slideItem.getLevel());

            slideItem.draw(area.x, y, scale, g, style, view);
            y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    // Calculate the scale for drawing based on the area size
    private float getScale(Rectangle area)
    {
        return Math.min(((float) area.width) / ((float) WIDTH), ((float) area.height) / ((float) HEIGHT));
    }
}

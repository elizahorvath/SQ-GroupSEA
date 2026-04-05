package nhlstenden.jabberpoint.model;

import nhlstenden.jabberpoint.observer.PresentationObserver;

import java.util.ArrayList;


/**
 * <p>Presentation maintains the slides in the presentation.</p>
 * <p>There is only instance of this class.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Presentation
{

    private String showTitle;                   // title of the presentation
    private ArrayList<Slide> showList;          // an ArrayList with Slides
    private int currentSlideNumber = 0;         // the slidenummer of the current Slide

    // List of observers (views) that want updates
    private ArrayList<PresentationObserver> observers = new ArrayList<>();

    public Presentation()
    {
        clear();
    }

    //Subject Responsibilities

    /**
     * Register a new observer (eg. SlideViewComponent)
     */
    public void addObserver(PresentationObserver observer)
    {
        observers.add(observer);
    }

    /**
     * Remove an observer
     */
    public void removeObserver(PresentationObserver observer)
    {
        observers.remove(observer);
    }

    /**
     * Notify all observers that the model has changed
     */
    private void notifyObserver()
    {
        for (PresentationObserver observer : observers)
        {
            observer.update(this);
        }
    }

    //Presentation Logic

    public int getSize()
    {
        return showList.size();
    }

    public String getTitle()
    {
        return showTitle;
    }

    public void setTitle(String nt)
    {
        showTitle = nt;
    }

    /**
     * Returns the number of the current slide
     */
    public int getSlideNumber()
    {
        return currentSlideNumber;
    }

    /**
     * Change the current slide number and notify the window/view component
     */
    public void setSlideNumber(int number)
    {
        currentSlideNumber = number;
        notifyObserver();
    }

    /**
     * Go to the previous slide unless at the beginning of the presentation
     */
    public void prevSlide()
    {
        if (currentSlideNumber > 0)
        {
            setSlideNumber(currentSlideNumber - 1);
        }
    }

    /**
     * Go to the next slide unless at the end of the presentationon.
     */
    public void nextSlide()
    {
        if (currentSlideNumber < (showList.size() - 1))
        {
            setSlideNumber(currentSlideNumber + 1);
        }
    }

    /**
     * Reset the presentation
     */
    public void clear()
    {
        showList = new ArrayList<Slide>();
        setSlideNumber(-1);
    }

    /**
     * Add a slide to the presentation
     */
    public void append(Slide slide)
    {
        showList.add(slide);
    }

    /**
     * Get a slide by index
     */
    public Slide getSlide(int number)
    {
        if (number < 0 || number >= getSize())
        {
            return null;
        }

        return (Slide) showList.get(number);
    }

    /**
     * Returns the current slide
     */
    public Slide getCurrentSlide()
    {
        return getSlide(currentSlideNumber);
    }

    /**
     * Exit the program
     */
    public void exit(int n)
    {
        System.exit(n);
    }
}

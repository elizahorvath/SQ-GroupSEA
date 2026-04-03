package nhlstenden.jabberpoint.observer;

import nhlstenden.jabberpoint.model.Presentation;

/**
 * Observer interface for the Observer pattern.
 * Any class that wants to be notified when the Presentation changes must
 * implement this interface.
 * <p>
 * The update() method is called by Presentation (the Subject) whenever
 * the current slide changes.
 */

public interface PresentationObserver
{
    /**
     * Called when the Presentation updates (e.g., slide changes)
     *
     * @param presentation the Presentation object that changed
     */

    void update(Presentation presentation);
}

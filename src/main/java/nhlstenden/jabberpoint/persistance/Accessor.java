package nhlstenden.jabberpoint.persistance;

import nhlstenden.jabberpoint.model.Presentation;

import java.io.IOException;

/**
 * <p>An Accessor makes it possible to read or write
 * data for a presentation.</p>
 * <p>Non-abstract subclasses must implement the load and save methods.</p>
 *
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class Accessor implements PresentationLoader, PresentationSaver
{
    public static final String DEMO_NAME = "Demonstration presentation";
    public static final String DEFAULT_EXTENSION = ".xml";

    public static PresentationLoader getDemoAccessor()
    {
        return new DemoPresentation();
    }
}

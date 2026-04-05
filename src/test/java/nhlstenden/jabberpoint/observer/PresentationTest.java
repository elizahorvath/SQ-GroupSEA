package nhlstenden.jabberpoint.observer;

import nhlstenden.jabberpoint.model.Presentation;
import nhlstenden.jabberpoint.model.Slide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

class PresentationTest
{
    private Presentation presentation;

    @BeforeEach
    void setUp()
    {
        presentation = new Presentation();
    }

    @Test
    void observerIsNotifiedOnSlideChange()
    {
        AtomicBoolean wasCalled = new AtomicBoolean(false);

        PresentationObserver observer = p ->
        {
            wasCalled.set(true);
            assertEquals(presentation, p);
        };

        presentation.addObserver(observer);

        presentation.setSlideNumber(1);

        assertTrue(wasCalled.get());
    }

    @Test
    void observerIsNotifiedAfterRemoval()
    {
        AtomicBoolean wasCalled = new AtomicBoolean(false);

        PresentationObserver observer = p -> wasCalled.set(true);

        presentation.addObserver(observer);
        presentation.removeObserver(observer);

        presentation.setSlideNumber(2);

        assertFalse(wasCalled.get());
    }

    @Test
    void nextSlideNotifiesObserver()
    {
        presentation.append(new Slide());
        presentation.append(new Slide());

        AtomicBoolean wasCalled = new AtomicBoolean(false);
        presentation.addObserver(p -> wasCalled.set(true));

        presentation.setSlideNumber(0);
        wasCalled.set(false);

        presentation.nextSlide();

        assertTrue(wasCalled.get());
    }
}
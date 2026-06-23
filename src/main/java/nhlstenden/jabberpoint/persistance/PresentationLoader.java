package nhlstenden.jabberpoint.persistance;

import nhlstenden.jabberpoint.model.Presentation;
import java.io.IOException;

public interface PresentationLoader
{
    void loadFile(Presentation p, String filename) throws IOException;
}
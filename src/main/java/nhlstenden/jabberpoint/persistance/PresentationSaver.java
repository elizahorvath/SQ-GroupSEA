package nhlstenden.jabberpoint.persistance;

import nhlstenden.jabberpoint.model.Presentation;
import java.io.IOException;

public interface PresentationSaver
{
    void saveFile(Presentation p, String filename) throws IOException;
}
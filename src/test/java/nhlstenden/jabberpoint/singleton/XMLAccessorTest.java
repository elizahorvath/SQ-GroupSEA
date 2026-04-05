package nhlstenden.jabberpoint.singleton;
import nhlstenden.jabberpoint.persistance.XMLAccessor;
import nhlstenden.jabberpoint.model.Presentation;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class XMLAccessorTest {

    @Test
    void testLoadFileThrowsExceptionWhenFileIsMissing() {
        XMLAccessor accessor = new XMLAccessor();
        Presentation presentation = new Presentation();

        // Verifies that the re-thrown IOException works as intended
        assertThrows(IOException.class, () -> {
            accessor.loadFile(presentation, "missing_file.xml");
        });
    }
}
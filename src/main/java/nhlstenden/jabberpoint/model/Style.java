package nhlstenden.jabberpoint.model;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

/** <p>Style handles Indent, Color, Font, and Leading.</p>
 * <p>There is a direct relation between style-number and item-level:
 * in Slide, the style is fetched for an item using the style-number as the item-level.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Style {
	private static Style instance; // the single instance of Style (Singleton)
	
	// Indents per level
    private static final int INDENT_0 = 0;
    private static final int INDENT_1 = 20;
    private static final int INDENT_2 = 50;
    private static final int INDENT_3 = 70;
    private static final int INDENT_4 = 90;

    // Font sizes per level
    private static final int FONT_SIZE_0 = 48;
    private static final int FONT_SIZE_1 = 40;
    private static final int FONT_SIZE_2 = 36;
    private static final int FONT_SIZE_3 = 30;
    private static final int FONT_SIZE_4 = 24;

    // Leading / Spacing constants
    private static final int LEADING_TITLE = 20;
    private static final int LEADING_DEFAULT = 10;


	// Map to store styles per level
	private final Map<Integer, Style> levelStyles = new HashMap<>();
	
	// Instance variables
    private final Font font;
    private final Color color;
    private final int indent;
    private final int fontSize;
    private final int leading;

	private static final String FONT_NAME = "Helvetica";

	/* Singleton Access Point */
	public static Style getInstance() {
        if (instance == null) {
            instance = new Style();
        }
        return instance;
    }

	/* Private constructor for the Singleton Registry.
     * Initializes all the standard styles (removes Magic Numbers).*/
	private Style() {
        // Default values for the registry "container"
        this.indent = 0;
        this.color = Color.black;
        this.fontSize = 0;
        this.leading = 0;
        this.font = null;

        // Initialize the various levels
        levelStyles.put(0, new Style(INDENT_0, Color.red,   FONT_SIZE_0, LEADING_TITLE));
        levelStyles.put(1, new Style(INDENT_1, Color.blue,  FONT_SIZE_1, LEADING_DEFAULT));
        levelStyles.put(2, new Style(INDENT_2, Color.black, FONT_SIZE_2, LEADING_DEFAULT));
        levelStyles.put(3, new Style(INDENT_3, Color.black, FONT_SIZE_3, LEADING_DEFAULT));
        levelStyles.put(4, new Style(INDENT_4, Color.black, FONT_SIZE_4, LEADING_DEFAULT));
    }

	/* Private constructor for creating individual level instances. */
	private Style(int indent, Color color, int points, int leading) {
        this.indent = indent;
        this.color = color;
        this.fontSize = points;
        this.font = new Font(FONT_NAME, Font.BOLD, points);
        this.leading = leading;
    }

	public Style getStyle(int level) {
        if (level >= levelStyles.size()) {
            level = levelStyles.size() - 1;
        }
        return levelStyles.get(level);
    }

	// Getters
    public Color getColor() {
        return color;
    }

    public int getIndent() {
        return indent;
    }

    public int getLeading() {
        return leading;
    }

    public Font getFont(float scale) {
        return font.deriveFont(fontSize * scale);
    }

    @Override
    public String toString() {
        return "[" + indent + "," + color + "; " + fontSize + " on " + leading + "]";
    }
}

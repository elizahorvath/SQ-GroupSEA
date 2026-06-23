package nhlstenden.jabberpoint.view;
import nhlstenden.jabberpoint.model.Presentation;
import nhlstenden.jabberpoint.model.Slide;
import nhlstenden.jabberpoint.observer.PresentationObserver;

import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JFrame;


/** <p>SlideViewerComponent is a graphical component that can show slides.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class SlideViewerComponent extends JComponent implements PresentationObserver
{
    private Slide slide;
    private Font labelFont = null;
    private JFrame frame = null;

    // Only store what we actually need for rendering
    private int slideNumber = -1;
    private int totalSlides = 0;
    private String presentationTitle = "";

    private static final long serialVersionUID = 227L;

    private static final Color BGCOLOR = Color.white;
    private static final Color COLOR = Color.black;
    private static final String FONTNAME = "Dialog";
    private static final int FONTSTYLE = Font.BOLD;
    private static final int FONTHEIGHT = 10;
    private static final int XPOS = 1100;
    private static final int YPOS = 20;

    public SlideViewerComponent(Presentation pres, JFrame frame)
    {
        setBackground(BGCOLOR);
        this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
        this.frame = frame;
        pres.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(Slide.WIDTH, Slide.HEIGHT);
    }

    @Override
    public void update(Presentation presentation)
    {
        this.slide = presentation.getCurrentSlide();
        this.slideNumber = presentation.getSlideNumber();
        this.totalSlides = presentation.getSize();
        this.presentationTitle = presentation.getTitle();

        repaint();
        frame.setTitle(presentationTitle);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        g.setColor(BGCOLOR);
        g.fillRect(0, 0, getSize().width, getSize().height);

        if (slideNumber < 0 || slide == null)
        {
            return;
        }

        g.setFont(labelFont);
        g.setColor(COLOR);
        g.drawString("Slide " + (1 + slideNumber) + " of " + totalSlides, XPOS, YPOS);

        Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));
        slide.draw(g, area, this);
    }
}

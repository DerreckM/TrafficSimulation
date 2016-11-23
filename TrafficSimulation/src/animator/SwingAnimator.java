package animator;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
//import java.awt.Image;
import java.util.Observable;


//import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

//import animator.SwingAnimatorBuilder.MyPainter;
import util.SwingAnimatorPainter;
  
public class SwingAnimator implements Animator {
  // This field is manipulated by the main program thread
  private int delay;
  
  // This field is manipulated by the swing thread
  private JFrame frame; // Swing representation of an OS window
  private ContentPane content; // A 'paintable' component
  private boolean disposed = false; // If disposed true, die
  
  public SwingAnimator(final SwingAnimatorPainter painter, final String name, final int width, final int height, int delay) {
    this.delay = delay;
    // this will create a graphics window and display it
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          content = new ContentPane(painter, width, height); // A 'paintable' component for content
          frame = new JFrame();  
          frame.setTitle(name);  
          frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // this method will end program if Frame is closed
          frame.setContentPane(content); // this will tie the content with the Frame
          frame.pack(); // this will fix the Frame layout
          frame.setVisible(true); // this will display the Frame
        }});
  }

  public void dispose() {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          frame.dispose();
          disposed = true;
        }});
  }

  public void update(final Observable model, Object ignored) {
    if (disposed)
      throw new IllegalStateException();
    
    // Redraw the window
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
          // content.repaint() causes a call to content.paint(g)
          // where g is an appropriate graphics argument.
          content.repaint();
        }});
    
    // Delay the main thread
    try {
        Thread.currentThread();
		Thread.sleep(delay);
    } catch (InterruptedException e) {}
  }

  private static class ContentPane extends JPanel {
    private static final long serialVersionUID = 2016L;
    private int width;
    private int height;
    private SwingAnimatorPainter painter;
    
    ContentPane(SwingAnimatorPainter painter, int width, int height) {
      this.painter = painter;
      this.width = width;
      this.height = height;
      setPreferredSize(new Dimension(width, height));
      setDoubleBuffered(true);
      setOpaque(true);
      setBackground(Color.WHITE);
    }
    
    public void paint(Graphics g) {
      // The swing thread may call this method before the simulation calls SwingAnimator.update()
      if (painter != null ) {
        g.clearRect(0, 0, width, height); // The clearRect is required because JPanel is lightweight
        painter.paint(g);
      }
    }
  }
}
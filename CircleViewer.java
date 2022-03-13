import javax.swing.JFrame;

/**
*   This program allows the user to view font effects.
*/
public class CircleViewer 
{
	private static final int FRAME_WIDTH = 900;
	private static final int FRAME_HEIGHT = 700;

   public static void main(String[] args)
   {  
      JFrame frame = new JFrame();
      frame.add( new MainPanel());

  

   frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);

      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Lab8");
      frame.setVisible(true);      
   }
}


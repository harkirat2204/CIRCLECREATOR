import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;



public class MainPanel extends JPanel{

   private JLabel numOfCirclesLabel;
   private JTextField numOfCirclesField;

   private JLabel rOfSmallCircleLabel;
   private JTextField rOfSmallCircleField;

   private JLabel  rOfLargeCircleLabel;
   private JTextField  rOfLargeCircleField;
 
   private DrawPanel drawPanel;
   private JPanel dataPanel;
   private JPanel buttonPanel;
  private Random rand;
  /** Constructor
  */
   public MainPanel(){
  
   	drawPanel = new DrawPanel();
    createDataPanel();
   	createButtonPanel();

   	rand = new Random();

   	setLayout(new BorderLayout());

 	add(dataPanel, BorderLayout.NORTH);
 	add(buttonPanel, BorderLayout.WEST);
 	add(drawPanel, BorderLayout.CENTER);
   }/** This creates the data pane
   */
	public void createDataPanel(){
		dataPanel = new JPanel();
		numOfCirclesLabel = new JLabel("Number of Circles: ");
		numOfCirclesField = new JTextField("5",10);
		numOfCirclesField.setEditable(true);

		rOfSmallCircleLabel = new JLabel("Radius of smallest circle: ");
		rOfSmallCircleField = new JTextField("10",10);
		rOfSmallCircleField.setEditable(true);

		rOfLargeCircleLabel = new JLabel("Radius of largest circle: ");
		rOfLargeCircleField = new JTextField("300",10);
		rOfLargeCircleField.setEditable(true);

		dataPanel.add(numOfCirclesLabel);
		dataPanel.add(numOfCirclesField);
		dataPanel.add(rOfSmallCircleLabel);
		dataPanel.add(rOfSmallCircleField);
		dataPanel.add(rOfLargeCircleLabel);
		dataPanel.add(rOfLargeCircleField);
   }/** This creates the button pane
   */
	public void createButtonPanel(){
		buttonPanel = new JPanel();
		buttonPanel.setLayout( new GridLayout(4,1));

		JButton create = createButton();
		JButton sort = sortButton();
		JButton cocenter = cocenterButton();
		JButton reset = resetButton();

		buttonPanel.add(create);
		buttonPanel.add(sort);
		buttonPanel.add(cocenter);
		buttonPanel.add(reset);  	
   }

	public JButton createButton(){
	   	JButton button = new JButton("Create");
	   	class CreateListner implements ActionListener{
	   		public void actionPerformed(ActionEvent event){
	   			int numOfCircles = Integer.parseInt(numOfCirclesField.getText());
	   			int minRadius = Integer.parseInt(rOfSmallCircleField.getText());
	   			int maxRadius = Integer.parseInt(rOfLargeCircleField.getText());
	   			
	   			for(int i  = 0; i < numOfCircles; i++){
	   				int randomRadius =  minRadius + rand.nextInt(maxRadius-minRadius+1);
	   				int randomX = rand.nextInt(getWidth());
	   				int randomY =rand.nextInt(getHeight());
	   				drawPanel.create(randomRadius, randomX, randomY);
	   			} 			
	   		}
	   	}
	   	button.addActionListener(new CreateListner());
	   	return button;
   }/** This creates thesort button 
   */
   public JButton sortButton(){
   	JButton button = new JButton("Sort");

   	class SortListner implements ActionListener{
   		public void actionPerformed(ActionEvent event){
   			drawPanel.sort();
   		}
   	}
   	button.addActionListener(new SortListner());
	return button;

   }/** This creates the cocenter button
   */
   	public JButton cocenterButton(){
   		JButton button = new JButton("co-centre");
   		class CoCenterListener implements ActionListener{
   	 		public void actionPerformed(ActionEvent event){
   	 			drawPanel.movee();
   			}
   		}
   		button.addActionListener(new CoCenterListener());
   		return button;
   	}
   	/** This creates the reset button
   */
   	public JButton resetButton(){
   		JButton button = new JButton("reset");

   		class ResetListener implements ActionListener{
   			public void actionPerformed(ActionEvent event){
   				drawPanel.reset();
   			}
   		} 
   			button.addActionListener(new ResetListener());
   		return button;
   	}
}









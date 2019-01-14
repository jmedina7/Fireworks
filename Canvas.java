import javax.swing.JComponent;
import javax.swing.JFrame;

public class Canvas extends JComponent{
	// Method to create window
	public static void window() {
		
		App canvas = new App();
		JFrame frame = new JFrame("Fireworks: Are You Ready to Blow?");
		frame.add(canvas);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 1000);
		frame.setVisible(true);
	}
}



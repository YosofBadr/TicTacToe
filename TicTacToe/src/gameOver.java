import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class gameOver extends JFrame
{
	public gameOver(String winningPlayer)
	{
		// Name of window through the super
		super("Game Over");
		
		JLabel winningMessage;
		
		if (winningPlayer == "draw")
		   winningMessage = new JLabel("Game is a draw!",  SwingConstants.CENTER);
		else
		   winningMessage = new JLabel(winningPlayer + " has won the game!",  SwingConstants.CENTER);
		
		add(winningMessage);
		
		// Size of window, width/height
		setSize(300, 100 );
		
		// On startup window is in the middle
		setLocationRelativeTo(null);
		
		setResizable(false);
		
		setVisible(true);
	} //  messageBoard constructor
	
} // class messageBoard

// A simple java implementation of Tic Tac Toe with a GUI

// Imports needed for the arrangement and display of the window
// And required imports for event handling
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class TicTacToe extends JFrame
{
	// Variable to keep track of who's turn it is, initially X
	public String currentPlayer = "X";
	
	// String variables to hold the value of the buttons being compared
	// Used when evaluating if a player has matched 3 positions
	public String b1;
	public String b2;
	public String b3;

	// Boolean variable used to keep track if the game has ended (a player has achieved a win)
	public boolean gameOver = false;
	
	// 
	JPanel panel = new JPanel(new GridLayout(3,3));
		
	// 2D array which will contain the button objects
	JButton buttons[][] = new JButton[3][3];
	
	// Main method is run first, calls the constructor of the game
	public static void main(String[] args)
	{
		new TicTacToe();
	} // main method
	
	// winAchieved method will take no arguments
	// Will determine if any player has successfully matched 3 squares 
	// If so then the gameOver variable is updated to true  
	// Checks matches in rows, columns and then diagonals
	public boolean winAchieved()
	{
		for (int i = 0; i < 3; i++)
		{
			    b1 = buttons[i][0].getText();
				b2 = buttons[i][1].getText();
				b3 = buttons[i][2].getText();

				if ((!b1.equals(""))
					&& (b1.equals(b2)) 
					&& (b2.equals(b3)))
				{
					new gameOver(b1);
					return gameOver = true; 
				} // if
		} // for 
		
		for (int j = 0; j < 3; j++)
		{
			    b1 = buttons[0][j].getText();
				b2 = buttons[1][j].getText();
				b3 = buttons[2][j].getText();

				if ((!b1.equals(""))
					&& (b1.equals(b2)) 
					&& (b2.equals(b3)))
				{
					new gameOver(b1);
					return gameOver = true; 
				} // if
				} // for 
		
	    b1 = buttons[0][0].getText();
	   	b2 = buttons[1][1].getText();
	   	b3 = buttons[2][2].getText();
	   	
		if ((!b1.equals(""))
			&& (b1.equals(b2)) 
			&& (b2.equals(b3)))
		{
			new gameOver(b1);
			return gameOver = true; 
		} // if
		
	    b1 = buttons[1][1].getText();
	   	b2 = buttons[0][2].getText();
	   	b3 = buttons[2][0].getText();
	   	
		if ((!b1.equals(""))
			&& (b1.equals(b2)) 
			&& (b2.equals(b3)))
		{
			new gameOver(b1);
			return gameOver = true; 
		} // if
		
		return gameOver = false; 
	} // winAchievedd()
	
	// Constructor to create the window with all the buttons
	public TicTacToe()
	{
		// Name of window through the super
		super("TicTacToe");
		
		// Size of window, width/height
		setSize(500, 500);
		
		// On click of close button the program is also shut down
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// On startup window is in the middle
		setLocationRelativeTo(null);
		
		eventHandler handler = new eventHandler();
		
		// Nested for loops to create new button objects and place them into the array
		// Places each button into the panel and gives assigns it a listner
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
			{
				buttons[i][j] = new JButton("");
				panel.add(buttons[i][j]);
				buttons[i][j].addActionListener(handler);
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 90));
				buttons[i][j].setContentAreaFilled(false);
				buttons[i][j].setFocusPainted(false);
				buttons[i][j].setFocusable(false);
				buttons[i][j].setRolloverEnabled(false);
			} // for 
		
		// Places panel onto the JFrame (window)
		add(panel);
	
		// Ensure window is always the same size
		setResizable(false);
		
		// Displays window
		setVisible(true);
	} // constructor TicTacToe()
	
	// eventHanlder class acts as a listener and takes care of button clicks
	private class eventHandler implements ActionListener
	{
	
		// Once a button is clicked actionPerformed is called with the action as a parameter
		public void actionPerformed(ActionEvent e)
		{
			// Checks the source of the button click (which one of the 9 buttons)
			JButton button = (JButton)e.getSource(); 
			
			// Checks if button clicked is empty (can't override a button previously played on)
			// If button is empty then it checks if game is still in play 
			// If so then we change the text of the tile according to the current player
			// Update currentPlayer
			// Checks new board if a win has been reached 
			if (button.getText() == "")
			{
				if (!gameOver)
				{
						button.setText("" + currentPlayer);
						
						currentPlayer = currentPlayer == "X" ? "O" : "X";
						
						winAchieved();

				} // if
			} // if	
		} // actionPerformed
	} // class eventHandler
} // class TicTacToe

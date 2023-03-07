package ticTacToe;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener {
	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean playerOneTurn;
	
	// Win indexes conditions
	int[][] winCombArray = {{0,1,2} , {3,4,5} , {6,7,8} , {0,3,6} , {1,4,7} , {2,5,8} , {0,4,8} , {2,4,6}};
	ArrayList<Integer> xArrayList = new ArrayList<>() ;
	ArrayList<Integer> oArrayList = new ArrayList<>() ;
	// store the winning combination array (3 num) for change the color of that 3 boxes .
	int winComb;
	
	TicTacToe() {
		// Set frame layout
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		// Set text field layout
		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Arial", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		
		// Set title panel layout
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0, 0, 800, 100);
		
		buttonPanel.setLayout(new GridLayout(3, 3));
		buttonPanel.setBackground(new Color(150, 150, 150));
		
		for(int i = 0; i < 9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 9; i++) {
			if(e.getSource() == buttons[i]) {
				if(playerOneTurn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(255, 0, 0));
						buttons[i].setText("X");
						playerOneTurn = false;
						textField.setText("O turn");
						check(i);
					}
				} else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color(0, 0, 255));
						buttons[i].setText("O");
						playerOneTurn = true;
						textField.setText("X turn");
						check(i);
					}
				}
			}
		}
	}
	
	public void firstTurn() {
		try {
			disableButtons();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		enableButtons();
		
		if(random.nextInt(2) == 0) {
			playerOneTurn = true;
			textField.setText("X turn");
		} else {
			playerOneTurn = false;
			textField.setText("O turn");
		}
	}
	
	public void check(int idx) {
		// Check X wins conditions
		// add the button num into xArrayList or oArrayList.
		if(playerOneTurn == false) {
			xArrayList.add(idx);
		} else {
			oArrayList.add(idx);
		}
		
		// if the xArrayList contains the winning combination (3 specific nums) .
		if (checkWin(xArrayList)) {

			textField.setText("X wins") ;
			
			// buttons of winning combination (3 nums)
			for (int i : winCombArray[winComb]) {
				buttons[i].setBackground(Color.GREEN);
			}
		}

		// Check O wins conditions
		else if (checkWin(oArrayList)) {

			textField.setText("O wins") ;
			
			// buttons of winning combination (3 nums)
			for (int i : winCombArray[winComb]) {
				buttons[i].setBackground(Color.GREEN);
			}
		}

		// Check tie conditions
		else {
			for (int i=0 ; i<9 ; i++) {
				// if 1 of 9 button texts is blank
				if (buttons[i].getText().isBlank()) {
					// the tie condition is not satisfied .
					break ;
				}
				// if both 9 button texts are not blank .
				if (i == 8) {
					// game finishes .
					// the text color of buttons will be disabled as well so they will turn gray .
					tieGame();
				}
			}
		}
	}
	
	// check whether the winning condition is met .
	public boolean checkWin(ArrayList<Integer> arrayList) {
		
		boolean win = false ;
		
		// iterate through all nested arrays .
		for (int i = 0; i < 8 ; i++) {
			// iterate through all 3 nums inside the nested array .
			for (int j = 0; j < 3 ; j++) {
				// if the arrayList contains the num .
				if (arrayList.contains(winCombArray[i][j])) {
					// if the arrayList contains all the 3 nums in the same nested array .
					if (j == 2) {
						win = true ;
						winComb = i ;
						// accelerate the outer loop to terminate it .
						i = 7 ;
					}
				}
				// if the arrayList doesn't contain the num .
				else {
					win = false ;
					// search for the next nested array .
					break ;
				}
			}
		}
		// return the determination result .
		return win ;
	}
	
	public void tieGame() {
		disableButtons() ;

		textField.setText("Tie") ;
	}
	
	public void disableButtons() {
		for (int b=0 ; b<9 ; b++) {
			buttons[b].setEnabled(false) ;
		}
	}

	// game starts .
	public void enableButtons() {
		for (int b=0 ; b<9 ; b++) {
			buttons[b].setEnabled(true) ;
		}
	}
}

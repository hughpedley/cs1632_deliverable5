import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Cell extends JButton {

    private boolean _beenAlive = false;

    private int _maxSize = 10000;
    
    public Cell() {
	super(" ");
	setFont(new Font("Courier", Font.PLAIN, 12));
	addActionListener(new CellButtonListener());
    }

    public Cell(boolean alive) {
	super(" ");
	setFont(new Font("Courier", Font.PLAIN, 12));
	addActionListener(new CellButtonListener());
	setAlive(alive);
    }

    public void resetBeenAlive() {
	_beenAlive = false;
    }

    public void reset() {
	resetBeenAlive();
	setAlive(false);
    }
    
    public boolean getAlive() {
	String text = getText();
	return (text.equals("X"));
    }

    public String toString() {
    	/**
    	 * Original toString code, before refactoring
    	 * Takes too much time because it makes 10000 different strings (because strings are immutable)
    	 * and then only uses the first two characters of it as a returned value
    	String toReturn = new String("");
    	String currentState = getText();
    	for (int j = 0; j < _maxSize; j++) {
    		toReturn += currentState;
    	}
    	if (toReturn.substring(0,1).equals("X")) {
    		return toReturn.substring(0,1);
    	} else {
    		return ".";
    	}
		*/
    	
    	//Refactored code:
    	//It's really only the previous if/else statement that it necessary
    	//for this method
    	String toReturn = getText();
    	
    	if(toReturn.equals("x")) {
    		return toReturn;
    	} else {
    		return ".";
    	}
    }
    
    public void setAlive(boolean a) {
	// note that "if (a)" and "if (a == true)"
	// really say the same thing!
	if (a) {
	    _beenAlive = true;
	    setText("X");
	    setBackground(Color.RED);
	} else {
	    setText(" ");
	    if (_beenAlive) {
		setBackground(Color.GREEN);
	    } else {
		setBackground(Color.GRAY);
	    }
	}
	setContentAreaFilled(true);
        setOpaque(true);
    }

    class CellButtonListener implements ActionListener {

	// Every time we click the button, it will perform
	// the following action.

	public void actionPerformed(ActionEvent e) {
	    Cell source = (Cell) e.getSource();
	    String currentText = source.getText();
	    resetBeenAlive();
	    if (currentText.equals(" ")) {
		setAlive(true);
	    } else if (currentText.equals("X")) {
		setAlive(false);
	    } else {
		// This shouldn't happen
		setAlive(false);
	    }
	}
    
    }

}

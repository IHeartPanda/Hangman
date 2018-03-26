import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener{
	JFrame f = new JFrame();
	JPanel p = new JPanel();
	JLabel l = new JLabel();
	JLabel guess = new JLabel();
	Stack<String> s = new Stack <String>();
	String currentWord;
	String displayedWord = "";
	char gues;
	char under = '_';
	String temp = "";
	public static void main(String[] args) {
		Hangman h = new Hangman();
	}

	Hangman() {
		
		String ran = JOptionPane.showInputDialog("Enter a number between 1 - 2,999");
		int rand = Integer.parseInt(ran);

		for (int i = 0; i < rand; i++) {
			Random r = new Random();
			int num = r.nextInt(3000);
			int st = 0;
			try {
				BufferedReader br = new BufferedReader(new FileReader("src/dictionary.txt"));
				String line = br.readLine();
				while(line != null){
					line = br.readLine();
					st++;
					if(st == num) {
						s.add(line);
						currentWord = line;
					}
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		f.addKeyListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		p.add(l);
		p.add(guess);
		l.setText("Guess a Letter");
		f.setVisible(true);
		initializeDisplayedWord();
		f.setSize(500, 300);
	}
	void initializeDisplayedWord() {
		for (int i = 0; i < currentWord.length(); i++) {
			displayedWord += "_";
		}
		guess.setText(displayedWord);
	}
	void updateDisplayedWord(char c) {

			for (int j = 0; j < currentWord.length(); j++) {
				if (currentWord.charAt(j)==c) {
					temp += c;
				}
				else {
					temp += displayedWord.charAt(j);
				}
			}
			displayedWord = temp;

	}
	void checkWord(String ch) {
		for (int i = 0; i < ch.length(); i++) {
			if (ch.charAt(i) == under) {
				return;
			}
		}
				currentWord = s.pop();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		updateDisplayedWord(e.getKeyChar());
		guess.setText(displayedWord);
		checkWord(temp);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

/*
 * get the number then create a for loop that is the length of the number the user inputs
 * use a random to get a number every time it loops and add the word it to the stack
 * file reader!!!
//Read from a file one line at a time
try {
	BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test.txt"));
	
	String line = br.readLine();
	while(line != null){
		System.out.println(line);
		line = br.readLine();
	}
	
	br.close();
} catch (FileNotFoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
*/
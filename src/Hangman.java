import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Hangman {
	public static void main(String[] args) {
		
	}

	Hangman() {
		
		String ran = JOptionPane.showInputDialog("Enter a number between 1 - 2,999");
		int rand = Integer.parseInt(ran);
		Stack<String> s = new Stack <String>();
		for (int i = 0; i < rand; i++) {
			Random r = new Random();
			int num = r.nextInt(3000);
			int st = 0;
			try {
				BufferedReader br = new BufferedReader(new FileReader("Hangman/src/dictionary.txt"));
				String line = br.readLine();
				while(line != null){
					line = br.readLine();
					st++;
					if(st == num) {
						s.add(line);
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
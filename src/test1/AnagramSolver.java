package test1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class AnagramSolver {

	ArrayList<String> anagrams = new ArrayList<String>();
	ArrayList<String> dictionary = new ArrayList<String>();

	public static void main(String[] args) {
		AnagramSolver solver = new AnagramSolver();
		solver.readDictionary();
		solver.findAnagrams(JOptionPane.showInputDialog("Type in a word to find the anagrams: "));
	}

	public void readDictionary() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/test1/dict.txt"));
			String contentLine = br.readLine();
			while (contentLine != null) {
				dictionary.add(contentLine);
				contentLine = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void findAnagrams(String s) {
		anagrams = new ArrayList<String>();
		findAnagramsRec(s, "");
		findWords();
	}

	public void findAnagramsRec(String inp, String ret) {
		if (inp.length() == 0) {
			anagrams.add(ret);
		} else {
			for (int i = 0; i < inp.length(); i++) {
				findAnagramsRec(inp.substring(0, i) + inp.substring(i + 1), ret + Character.toString(inp.charAt(i)));
			}
		}
	}

	public void findWords() {
		for (String s : anagrams) {
			for (String d : dictionary) {
				if (s.equals(d)) {
					System.out.println(s);
				}
			}
		}
	}
}

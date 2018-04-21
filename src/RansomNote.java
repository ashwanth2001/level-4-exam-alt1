import java.util.*;

public class RansomNote {
	Map<String, Integer> magazineMap;
	Map<String, Integer> noteMap;

	public RansomNote(String magazine, String note) {
		magazineMap = new HashMap<String, Integer>();
		noteMap = new HashMap<String, Integer>();
		for (char c = 'a'; c <= 'z'; c++) {
			magazineMap.put(Character.toString(c), 0);
			noteMap.put(Character.toString(c), 0);
		}

		for (int i = 0; i < magazine.length(); i++) {
			if (magazine.charAt(i) != ' ')
				magazineMap.replace(magazine.substring(i, i + 1), magazineMap.get(magazine.substring(i, i + 1)) + 1);
		}
		for (int i = 0; i < note.length(); i++) {
			if (note.charAt(i) != ' ')
				noteMap.replace(note.substring(i, i + 1), noteMap.get(note.substring(i, i + 1)) + 1);
		}
	}

	public boolean solve() {
		for (char c = 'a'; c <= 'z'; c++) {
			if (magazineMap.get(Character.toString(c)) < noteMap.get(Character.toString(c))) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}
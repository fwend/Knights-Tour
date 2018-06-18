package semordnilaps;

import java.io.*;
import java.util.*;

public class Semordnilaps {

	public static void main(String[] args) throws IOException {
		List<String> lst = readLines("unixdict.txt");
		Map<String, Boolean> seen = new HashMap<>();
		int count = 0;
		for (String w : lst) {
			String r = new StringBuilder(w).reverse().toString();
			if (seen.containsKey(r)) {
				if (count++ < 5)
					System.out.printf("%-10s %-10s\n", w, r);
			} else seen.put(w, true);
		}
		System.out.println("\nSemordnilap pairs found: " + count);
	}

	private static List<String> readLines(String fn) throws IOException {
		List<String> lines;
		try (BufferedReader br = new BufferedReader(new FileReader(fn))) {
			lines = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null)
				lines.add(line.trim().toLowerCase());
		}
		return lines;
	}
}

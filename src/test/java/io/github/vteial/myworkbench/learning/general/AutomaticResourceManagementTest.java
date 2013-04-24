package io.github.vteial.myworkbench.learning.general;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AutomaticResourceManagementTest {

	public static void main(String... args) throws Exception {
		String s = "src/test/java/learning/general/AutomaticResourceManagementTest.java";
		InputStream is = new FileInputStream(s);
		InputStreamReader isr = new InputStreamReader(is);
		try (BufferedReader br = new BufferedReader(isr)) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
		}

	}
}

package learning.general;

import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class StreamToStringTest {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8080/gro-workbench/ping.java");
		InputStream is = url.openStream();
		String s = StreamToStringTest.streamToString(is);
		is.close();
		System.out.println(s);
	}

	public static String streamToString(InputStream is) {
		return new Scanner(is, "UTF-8").useDelimiter("\\A").next();
	}
}

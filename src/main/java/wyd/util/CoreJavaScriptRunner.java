package wyd.util;

import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class CoreJavaScriptRunner {

	public static void main(String[] args) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			FileReader reader = new FileReader(args[0]);
			engine.eval(reader);
			reader.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}

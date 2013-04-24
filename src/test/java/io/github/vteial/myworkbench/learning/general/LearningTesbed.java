package io.github.vteial.myworkbench.learning.general;

import io.github.vteial.util.JcTreeTextPrinter;

import com.gaurav.tree.ArrayListTree;

public class LearningTesbed {

	public static void main(String[] args) throws Exception {
		ArrayListTree<String> tree = new ArrayListTree<String>();
		tree.add("Level-1");
		tree.add("Level-1", "Level-11");
		tree.add("Level-1", "Level-12");
		tree.add("Level-1", "Level-13");
		tree.add("Level-12", "Level-121");
		tree.add("Level-12", "Level-122");
		tree.add("Level-122", "Level-1221");
		tree.add("Level-13", "Level-131");
		tree.add("Level-13", "Level-132");
		tree.add("Level-13", "Level-133");
		tree.add("Level-11", "Level-111");
		tree.add("Level-11", "Level-112");
		System.out.println(tree);
		JcTreeTextPrinter<String> renderer = new JcTreeTextPrinter<String>(
				tree);
		System.out.println(renderer);
	}

}

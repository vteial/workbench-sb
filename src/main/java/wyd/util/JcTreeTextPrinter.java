package wyd.util;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import com.gaurav.tree.NodeNotFoundException;
import com.gaurav.tree.Tree;

public class JcTreeTextPrinter<T> {

	private Tree<T> tree;

	private boolean showRoot = true;

	private StringBuilder sb;

	public JcTreeTextPrinter(Tree<T> tree) {
		this.tree = tree;
	}

	public boolean isShowRoot() {
		return showRoot;
	}

	public void setShowRoot(boolean showRoot) {
		this.showRoot = showRoot;
	}

	public void printTree() {
		System.out.println(toString());
	}

	public void printTree(PrintStream printStream) {
		printStream.println(toString());
	}

	@Override
	public String toString() {
		sb = new StringBuilder();
		T root = tree.root();
		try {
			printNode(root, "", "", showRoot);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return sb.toString();
	}

	private void printNode(T node, String pref, String bud, boolean render)
			throws NodeNotFoundException {
		if (render) {
			sb.append(pref);
			sb.append(bud);
			sb.append("-- ");
			sb.append(node.toString());
			sb.append("\n");
		}
		String pref1 = pref + "   ";
		String pref2 = pref + "   |";
		String pref3 = pref + "";
		List<T> childs = new ArrayList<T>(tree.children(node));
		int childCount = childs.size();
		String ind;
		String bud2;
		if (childCount > 0) {
			for (int i = 0; i < childCount; i++) {
				boolean lastElement = i == childCount - 1;
				if (lastElement) {
					ind = pref1;
					bud2 = "`";
				} else {
					ind = pref2;
					bud2 = "";
				}
				printNode(childs.get(i), !render ? pref3 : ind, !render ? ""
						: bud2, true);
			}
		}
	}

}

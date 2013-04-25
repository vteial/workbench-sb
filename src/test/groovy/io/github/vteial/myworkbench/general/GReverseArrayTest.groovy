// To live run use online groovy console from here http://groovyconsole.appspot.com/

package io.github.vteial.myworkbench.general;

def reverseArray0 = { def items ->
	return items.reverse(false)
}

def reverseArray1 = { def items ->
	def nItems = [];
	int j = items.size()-1;
	for(int i = 0; i < items.size(); i++) {
		nItems[i] = items[j--];
	}
	return nItems;
}

def reverseArray2 = { def items ->
	int j = items.size() - 1;
	int e = items.size() / 2;
	for(int i = 0; i < e; i++) {
		def t = items[i];
		items[i] = items[j];
		items[j--] = t;
	}
}

def reverseArray33 = {}
reverseArray33 = { def items, def i, def j ->
	if(i < j) {
		def t = items[i]
		items[i] = items[j]
		items[j] = t;
		reverseArray33(items, ++i, --j)
	}
}

def reverseArray3 = { def items ->
	reverseArray33(items, 0, items.size() - 1)
}

def items = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
println "Given Items = $items";

items = reverseArray0(items);
println "Reverse Version 0 : $items"

items = reverseArray1(items);
println "Reverse Version 1 : $items"

reverseArray2(items);
println "Reverse Version 2 : $items";

reverseArray3(items);
println "Reverse Version 2 : $items";

package learning.general;

def reverse1 = { def items ->
	def nItems = [];
	int j = items.size()-1;
	for(int i = 0; i < items.size(); i++) {
		nItems[i] = items[j--];
	}
	return nItems;
}

def reverse2 = { def items ->
	int j = items.size() - 1;
	int e = items.size() / 2;
	for(int i = 0; i < e; i++) {
		def t = items[i];
		items[i] = items[j];
		items[j--] = t;
	}
}

def items = [1, 2, 3, 4, 5, 6];
println "Given Items = $items";

println "Reverse Version 0 : " + items.reverse(false);

println "Reverse Version 1 : " + reverse1(items);

reverse2(items);
println "Reverse Version 2 : " + items;

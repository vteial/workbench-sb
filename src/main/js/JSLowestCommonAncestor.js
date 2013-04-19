
var getNodeContentsUpToRoot = function(node) {
	
	if(node === 'nodeA') {
		return [1, 2, 3, 8, 9];
	} 
	return [1, 2, 3, 4, 5, 66, 77];
};

var lca = function(nodeAContents, nodeBConents) {
	var distance = nodeAContents.length > nodeBContents.length ? nodeBContents.length : nodeAContents.length;
	println('Distance : ' + distance);
	for(var i = 0; i < distance; i++) {
		if(nodeAContents[i] !== nodeBContents[i]) {
			return nodeAContents[i-1];
		}
	}
};

var nodeAContents = getNodeContentsUpToRoot('nodeA');
var nodeBContents = getNodeContentsUpToRoot('nodeB');

println('LCA : ' + lca(nodeAContents, nodeBContents));
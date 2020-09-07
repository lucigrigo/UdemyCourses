package lucian.grigore.algorithm.prefixtree;

class PrefixTree {

    PrefixNode root;

    PrefixTree() {
        root = new PrefixNode();
    }

    void insert(char[] word, int id) {
        PrefixNode current = root;

        for (char x : word) {
            if (current.hasChildren(x)) {
                current = current.getChildren(x);
            } else {
                PrefixNode node = new PrefixNode(x, 0);
                current.addChildren(node);
                current = node;
            }
        }

        current.isWord = true;
        current.id = id;
    }
}

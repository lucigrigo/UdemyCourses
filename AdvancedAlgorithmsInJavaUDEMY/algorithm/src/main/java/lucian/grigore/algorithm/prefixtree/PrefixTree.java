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

    PrefixNode find(char[] word) {
        PrefixNode current = root;

        for (char x : word) {
            if (current.hasChildren(x)) {
                current = current.getChildren(x);
            } else {
                return null;
            }
        }

        if (!current.isWord)
            return null;
        return current;
    }

    boolean delete(char[] word, PrefixNode node, int wIndex) {
        if (wIndex == word.length - 1) {
            PrefixNode w = node.getChildren(word[wIndex]);
            w.isWord = false;
            w.id = 0;
            if (w.canDelete()) {
                node.children.remove(word[wIndex]);
                return true;
            }
        } else {
            if (!node.hasChildren(word[wIndex]))
                return false;
            boolean canDelete = delete(word, node.getChildren(word[wIndex]), ++wIndex);
            if (canDelete) {
                if (node.getChildren(word[--wIndex]).isWord)
                    return false;
                node.children.remove(word[wIndex]);
                return true;
            }
        }
        return false;
    }
}

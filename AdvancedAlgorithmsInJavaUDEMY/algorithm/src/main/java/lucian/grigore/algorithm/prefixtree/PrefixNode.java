package lucian.grigore.algorithm.prefixtree;

import java.util.HashMap;
import java.util.Map;

public class PrefixNode {

    private char c;
    int id;
    Map<Character, PrefixNode> children;
    boolean isWord = false;

    PrefixNode() {
        this.c = 0;
        this.id = 0;
    }

    PrefixNode(char c, int id) {
        this.c = c;
        this.id = id;
    }

    boolean hasChildren(char c) {
        return (children != null && children.containsKey(c));
    }

    PrefixNode getChildren(char c) {
        if (!hasChildren(c)) return null;
        return children.get(c);
    }

    void addChildren(PrefixNode node) {
        if (children == null) children = new HashMap<Character, PrefixNode>();
        if (!hasChildren(node.c)) children.put(node.c, node);
    }

    public boolean canDelete() {
        if (children == null || children.size() == 0) return true;
        return false;
    }

    @Override
    public String toString() {
        if (children != null)
            return c + (isWord ? "." + id : "") + "->[" + children.values() + "]";
        return c + "." + id;
    }
}

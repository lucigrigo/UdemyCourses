package lucian.grigore.algorithm.suffixtrie;

import java.util.LinkedList;
import java.util.List;

public class TrieNode {

    private static final int MAX_ARRAY = 256;
    TrieNode[] children = new TrieNode[MAX_ARRAY];
    List<Integer> indexes = new LinkedList<Integer>();

    public TrieNode() {
        for (int i = 0; i < MAX_ARRAY; ++i)
            children[i] = null;
    }

    void insertSuffix(String text) {
        text = text + "$";
        for (int i = 0; i < text.length(); ++i) {
            insertSuffix(text, i);
        }
    }

    void insertSuffix(String text, int index) {
        if (text.length() > index) {
            char current = text.charAt(index);
            if (children[current] == null)
                children[current] = new TrieNode();
            children[current].indexes.add(index);
            children[current].insertSuffix(text, ++index);
        }
    }

    public List<Integer> search(String pattern) {
        return search(pattern, 0);
    }

    private List<Integer> search(String pattern, int startPosition) {
        if (pattern.length() == startPosition)
            return indexes;

        if (children[pattern.charAt(startPosition)] != null) {
            return search(pattern, ++startPosition);
        }
        return null;
    }

    public boolean isSuffix(String pattern) {
        return isSuffix(pattern, 0);
    }

    private boolean isSuffix(String pattern, int start) {
        if(pattern.length() == start)
            return children['$'] != null;

        if(children[pattern.charAt(start)] != null)
            return children[pattern.charAt(start)].isSuffix(pattern, ++start);

        return false;
    }

    public boolean isSubstring(String pattern) {
        List<Integer> indexes = search(pattern);
        return indexes != null;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < children.length; ++i) {
            if (children[i] != null)
                s += (char) i + "->" + children[i].toString();
        }
        return s;
    }
}

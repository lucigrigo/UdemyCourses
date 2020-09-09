package lucian.grigore.algorithm.suffixtrie;

public class TrieNode {

    private static final int MAX_ARRAY = 256;
    TrieNode[] children = new TrieNode[MAX_ARRAY];

    public TrieNode() {
        for (int i = 0; i < MAX_ARRAY; ++i)
            children[i] = null;
    }

    void insertSuffix(String text) {
        text = text + "$";
        for(int i = 0; i < text.length(); ++i) {
            insertSuffix(text, i);
        }
    }

    void insertSuffix(String text, int index) {
        if (text.length() > index) {
            char current = text.charAt(index);
            if (children[current] == null)
                children[current] = new TrieNode();
            children[current].insertSuffix(text, ++index);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < children.length; ++i) {
            if(children[i] != null)
                s += (char) i + "->" + children[i].toString();
        }
        return s;
    }
}

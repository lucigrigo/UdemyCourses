package lucian.grigore.algorithm.suffixtrie;

import java.util.HashMap;
import java.util.Map;

public class TrieNodeMap {

    Map<Character, TrieNodeMap> children = new HashMap<Character, TrieNodeMap>();

    void insertSuffix(String text) {
        text = text + "$";
        for(int i = 0; i < text.length(); ++i) {
            insertSuffix(text, i);
        }
    }

    void insertSuffix(String text, int index) {
        if (text.length() > index) {
            char current = text.charAt(index);
            if (children.get(current) == null)
                children.put(current, new TrieNodeMap());
            children.get(current).insertSuffix(text, ++index);
        }
    }

    @Override
    public String toString() {
        String s = "";

        for(Character c : children.keySet()) {
            s += c + "->" + children.get(c).toString();
        }

        return s;
    }
}

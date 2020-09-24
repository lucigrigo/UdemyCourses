package lucian.grigore.algorithm.suffixtrie;

public class SuffixTrieMap {

    TrieNode root = new TrieNode();

    SuffixTrieMap(String text) {
        root.insertSuffix(text);
    }
}

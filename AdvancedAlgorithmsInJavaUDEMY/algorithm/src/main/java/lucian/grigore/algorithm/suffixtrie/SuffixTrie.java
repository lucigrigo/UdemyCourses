package lucian.grigore.algorithm.suffixtrie;

public class SuffixTrie {

    TrieNode root = new TrieNode();

    SuffixTrie(String text) {
        root.insertSuffix(text);
    }
}

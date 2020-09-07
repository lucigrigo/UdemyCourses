package lucian.grigore.algorithm.prefixtree;

import org.junit.Test;

public class PrefixTreeTest {

    @Test
    public void insertTest() {
        PrefixTree tree = new PrefixTree();
        tree.insert("cat".toCharArray(), 1);
        tree.insert("door".toCharArray(), 2);
        System.out.println(tree.root.toString());
    }
}

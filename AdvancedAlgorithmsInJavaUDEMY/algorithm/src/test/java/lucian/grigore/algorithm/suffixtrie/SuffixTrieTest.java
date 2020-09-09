package lucian.grigore.algorithm.suffixtrie;

import org.junit.Assert;
import org.junit.Test;

public class SuffixTrieTest {

    @Test
    public void insertTest() {
        SuffixTrie t = new SuffixTrie("banana");
        Assert.assertNotNull(t.root.children['a']);
        Assert.assertNotNull(t.root.children['b']);
        Assert.assertNotNull(t.root.children['n']);
        Assert.assertNull(t.root.children['c']);

        Assert.assertNotNull(t.root.children['b'].children['a']);
        Assert.assertNull(t.root.children['b'].children['n']);

        Assert.assertNotNull(t.root.children['a'].children['$']);
        Assert.assertNotNull(t.root.children['a'].children['n']);

        System.out.println(t.root);
    }
}

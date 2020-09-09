package lucian.grigore.algorithm.prefixtree;

import org.junit.Assert;
import org.junit.Test;

public class PrefixTreeTest {

    @Test
    public void insertTest() {
        PrefixTree tree = new PrefixTree();
        tree.insert("cat".toCharArray(), 1);
        tree.insert("door".toCharArray(), 2);
        System.out.println(tree.root.toString());
    }

    @Test
    public void findTest() {
        PrefixTree tree = new PrefixTree();
        tree.insert("cat".toCharArray(), 1);
        tree.insert("door".toCharArray(), 2);
        tree.insert("cats".toCharArray(), 3);

        Assert.assertEquals(3, tree.find("cats".toCharArray()).id);
        Assert.assertEquals(2, tree.find("door".toCharArray()).id);
        Assert.assertEquals(1, tree.find("cat".toCharArray()).id);
        Assert.assertTrue(tree.find("cat".toCharArray()).isWord);
        Assert.assertTrue(tree.find("cats".toCharArray()).isWord);
        Assert.assertTrue(tree.find("door".toCharArray()).isWord);
        Assert.assertNull(tree.find("wrong".toCharArray()));
    }

    @Test
    public void deleteTest() {
        PrefixTree tree = new PrefixTree();
        tree.insert("cat".toCharArray(), 1);
        tree.insert("door".toCharArray(), 2);
        tree.insert("cats".toCharArray(), 3);
        tree.insert("done".toCharArray(), 4);
        tree.insert("horse".toCharArray(), 5);
        System.out.println(tree.root.toString());

        tree.delete("cats".toCharArray(), tree.root, 0);
        System.out.println(tree.root.toString());

        tree.delete("door".toCharArray(), tree.root, 0);
        System.out.println(tree.root.toString());

        tree.delete("horse".toCharArray(), tree.root, 0);
        System.out.println(tree.root.toString());
    }

}
package ArbolesBinarios;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TreeApiTest {
    TreeApi<Integer> api = new TreeApi<>();
    BinaryTree<Integer> tree= new BinaryTree<>(3,new BinaryTree<Integer>(5,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1,new BinaryTree<>(),new BinaryTree<Integer>(6)),new BinaryTree<>(4)));

    @Test
    public void size(){
        assertEquals(8,api.size(tree));
    }
    @Test
    public void completeNodes(){
        assertEquals(2,api.completeNodes(tree));
    }
    @Test
    public void inorden(){
        ArrayList<Integer> inordenArray = new ArrayList<>();
        ArrayList<Integer> inordenCompare = new ArrayList<>();
        inordenCompare.add(6);
        inordenCompare.add(9);
        inordenCompare.add(5);
        inordenCompare.add(3);
        inordenCompare.add(1);
        inordenCompare.add(6);
        inordenCompare.add(2);
        inordenCompare.add(4);
        api.inorden(tree,inordenArray);
        assertEquals(inordenCompare,inordenArray);
    }
    @Test
    public void byLevel() throws IsEmptyException {
        ArrayList<Integer> byLevelArray = new ArrayList<>();
        ArrayList<Integer> byLevelCompare = new ArrayList<>();
        byLevelCompare.add(3);
        byLevelCompare.add(5);
        byLevelCompare.add(2);
        byLevelCompare.add(6);
        byLevelCompare.add(1);
        byLevelCompare.add(4);
        byLevelCompare.add(9);
        byLevelCompare.add(6);
        api.byLevel(tree,byLevelArray);
        assertEquals(byLevelCompare,byLevelArray);
    }

    @Test
    public void postorden(){
        ArrayList<Integer> postordenArray = new ArrayList<>();
        ArrayList<Integer> postordenCompare = new ArrayList<>();
        postordenCompare.add(9);
        postordenCompare.add(6);
        postordenCompare.add(5);
        postordenCompare.add(6);
        postordenCompare.add(1);
        postordenCompare.add(4);
        postordenCompare.add(2);
        postordenCompare.add(3);
        api.postorden(tree,postordenArray);
        assertEquals(postordenCompare,postordenArray);
    }
    @Test
    public void preorden(){
        ArrayList<Integer> preordenArray = new ArrayList<>();
        ArrayList<Integer> preordenCompare = new ArrayList<>();
        preordenCompare.add(3);
        preordenCompare.add(5);
        preordenCompare.add(6);
        preordenCompare.add(9);
        preordenCompare.add(2);
        preordenCompare.add(1);
        preordenCompare.add(6);
        preordenCompare.add(4);
        api.preorden(tree,preordenArray);
        assertEquals(preordenCompare,preordenArray);
    }
    @Test
    public void leaves(){
        assertEquals(3,api.leaves(tree));
    }
    @Test
    public void ocurrences(){
        assertEquals(1,api.occurrences(tree,1));
        assertEquals(2,api.occurrences(tree,6));
        assertEquals(0,api.occurrences(tree,99));
    }
    @Test
    public void elementsInLevel(){
        assertEquals(1, api.elementsInLevel(tree,0));
        assertEquals(2, api.elementsInLevel(tree,1));
        assertEquals(3, api.elementsInLevel(tree,2));
        assertEquals(2, api.elementsInLevel(tree,3));
    }
    @Test
    public void height(){
        assertEquals(3,api.height(tree));
    }
    @Test
    public void sumElements(){
        assertEquals(36,api.sumElements(tree));
    }
    @Test
    public void sumElementsThreeMultiple(){
        assertEquals(24,api.sumElementsThreeMultiple(tree));
    }
    @Test
    public void equals(){
        BinaryTree<Integer> treeCopy = tree;
        BinaryTree<Integer> falseCopy1 = new BinaryTree<>(2,tree,new BinaryTree<>());
        BinaryTree<Integer> falseCopy2 = new BinaryTree<>(3,new BinaryTree<>(), new BinaryTree<>(55));
        assertTrue(api.equals(treeCopy,tree));
        assertFalse(api.equals(falseCopy1,tree));
        assertFalse(api.equals(falseCopy2,tree));
    }
    @Test
    public void isomorph(){
        BinaryTree<Integer> tree1 = new BinaryTree<>(4,new BinaryTree<Integer>(5,new BinaryTree<Integer>(7,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(22,new BinaryTree<Integer>(3,new BinaryTree<>(),new BinaryTree<Integer>(7)),new BinaryTree<>(4)));
        BinaryTree<Integer> tree2= new BinaryTree<>(3,new BinaryTree<Integer>(5,new BinaryTree<Integer>(6),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1,new BinaryTree<>(),new BinaryTree<Integer>(6)),new BinaryTree<>()));
        assertTrue(api.isomorph(tree1,tree));
        assertFalse(api.isomorph(tree2,tree));
    }
    @Test
    public void areSimilar(){
        BinaryTree<Integer> tree1= new BinaryTree<>(5,new BinaryTree<Integer>(3,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(1,new BinaryTree<Integer>(2,new BinaryTree<>(),new BinaryTree<Integer>(7)),new BinaryTree<>(4)));
        BinaryTree<Integer> tree2= new BinaryTree<>(2,new BinaryTree<Integer>(98,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1,new BinaryTree<>(),new BinaryTree<Integer>(6)),new BinaryTree<>(4)));
        assertTrue(api.areSimilar(tree,tree1));
        assertFalse(api.areSimilar(tree,tree2));
    }
    @Test
    public void isComplete(){
        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
        BinaryTree<Integer> tree2 = new BinaryTree<>(1,new BinaryTree<>(2),new BinaryTree<>(3));
        assertTrue(api.isComplete(tree1));
        assertTrue(api.isComplete(tree2));
        assertFalse(api.isComplete(tree));
    }
    @Test
    public void isFull(){
        BinaryTree<Integer> aTree = new BinaryTree<>(1,new BinaryTree<>(2,new BinaryTree<>(3),new BinaryTree<>(4)),new BinaryTree<>(3,new BinaryTree<>(5),new BinaryTree<>(6)));
        assertTrue(api.isComplete(aTree));
        assertFalse(api.isComplete(tree));
    }
    @Test
    public void isEstable(){
        BinaryTree<Integer> stableTree = new BinaryTree<>(10,new BinaryTree<>(9,new BinaryTree<>(8),new BinaryTree<>(7)),new BinaryTree<>(5,new BinaryTree<>(1),new BinaryTree<>(3)));
        assertTrue(api.isStable(stableTree));
        assertFalse(api.isStable(tree));
    }
    @Test
    public void included(){
        BinaryTree<Integer> tree1 = new BinaryTree<>(10,new BinaryTree<>(3,new BinaryTree<Integer>(5,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1,new BinaryTree<>(),new BinaryTree<Integer>(7)),new BinaryTree<>(4))),new BinaryTree<>(22));
        BinaryTree<Integer> tree2 = new BinaryTree<>(11, new BinaryTree<>(21), new BinaryTree<>(5,new BinaryTree<Integer>(3,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(1,new BinaryTree<Integer>(2,new BinaryTree<>(12),new BinaryTree<Integer>(7)),new BinaryTree<>(4))));
        BinaryTree<Integer> tree3 = new BinaryTree<>(3,new BinaryTree<Integer>(21,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1,new BinaryTree<>(),new BinaryTree<Integer>(6)),new BinaryTree<>(4)));
        assertTrue(api.included(tree, tree1));
        assertTrue(api.included(tree, tree2));
        assertTrue(api.included(tree, tree));
        assertFalse(api.included(tree, tree3));
    }
    @Test
    public void occursBinaryTree(){
        BinaryTree<Integer> tree1 = new BinaryTree<>(10,tree,new BinaryTree<>(2));
        BinaryTree<Integer> tree2 = new BinaryTree<>(11, new BinaryTree<>(2), new BinaryTree<>(5,new BinaryTree<Integer>(3,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(1,new BinaryTree<Integer>(2,new BinaryTree<>(12),new BinaryTree<Integer>(6)),new BinaryTree<>(4))));
        BinaryTree<Integer> tree3 = new BinaryTree<>(3,new BinaryTree<Integer>(21,new BinaryTree<Integer>(6,new BinaryTree<>(),new BinaryTree<Integer>(9)),new BinaryTree<>()),new BinaryTree<Integer>(2,new BinaryTree<Integer>(1,new BinaryTree<>(),new BinaryTree<Integer>(6)),tree));
        assertTrue(api.occursBinaryTree(tree1,tree));
        assertFalse(api.occursBinaryTree(tree2, tree ));
        assertTrue(api.occursBinaryTree(tree3, tree));
    }
    @Test
    public void frontier(){
        ArrayList<Integer> frontierArray = new ArrayList<>();
        ArrayList<Integer> frontierCompare = new ArrayList<>();
        frontierCompare.add(4);
        frontierCompare.add(6);
        frontierCompare.add(9);
        api.frontier(tree,frontierArray);
        assertEquals(frontierCompare,frontierArray);
    }

}

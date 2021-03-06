package ComparacionDeArbolesBinariosDeBusqueda;

import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

import java.util.ArrayList;

public class Comparison {
    public static void main(String[] args) {
        Integer[] elements = generateRandomArray();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();

        //Construccion de los tres arboles
        long binarySearchTreeConstructionTime = fillBinarySearchTree(binarySearchTree,elements);
        long avlTreeConstructionTime = fillAVLTree(avlTree,elements);
        long redBlackTreeConstructionTime = fillRedBlackTree(redBlackTree,elements);

        System.out.println("Binary search tree construction time: "+ binarySearchTreeConstructionTime +" mili seconds");
        System.out.println("AVL tree construction time: "+ avlTreeConstructionTime +" mili seconds");
        System.out.println("Red black tree construction time: "+ redBlackTreeConstructionTime +" mili seconds");
        System.out.println();
        System.out.println("Binary search tree searches: ");
        int binarySearchTreecomparisons = 0;
        for (int i = 0; i < 10; i++) {
            int searchIndex = i*100;
            int comparisons = 0;
            try {
                comparisons = binarySearchTree.searchCountingComparisons(elements[searchIndex]);
                binarySearchTreecomparisons += comparisons;
                System.out.println("Element " + elements[searchIndex] + " tries: " + comparisons);
            } catch (ElementNotFoundInTree elementNotFoundInTree) {
                System.out.println(elementNotFoundInTree.getMessage());
            }
        }
        Double bstMean = (double) binarySearchTreecomparisons/10;
        System.out.println("Mean: " + bstMean);
        System.out.println();
        System.out.println("AVL tree searches: ");
        int avlcomparisons = 0;
        for (int i = 0; i < 10; i++) {
            int searchIndex = i*100;
            int comparisons = 0;
            try {
                comparisons = avlTree.searchCountingComparisons(elements[searchIndex]);
                avlcomparisons += comparisons;
                System.out.println("Element " + elements[searchIndex] + " tries: " + comparisons);
            } catch (ElementNotFoundInTree elementNotFoundInTree) {
                elementNotFoundInTree.printStackTrace();
            }
        }
        Double avlMean = (double) avlcomparisons/10;
        System.out.println("Mean: " + avlMean);
        System.out.println();
        System.out.println("Red black tree searches: ");
        int rbtComparisons = 0;
        for (int i = 0; i < 10; i++) {
            int searchIndex = i*100;
            int comparisons = 0;
            comparisons = redBlackTree.searchCountingComparisons(elements[searchIndex]);
            rbtComparisons += comparisons;
            System.out.println("Element " + elements[searchIndex] + " tries: " + comparisons);
        }
        Double rbtMean = (double) rbtComparisons/10;
        System.out.println("Mean: " + rbtMean);
        System.out.println();
        System.out.println("--------------TABLE-------------");
        searchTriesTable(binarySearchTree,avlTree,redBlackTree,elements);
        System.out.println();
        statistics();

    }

    public static Integer[] generateRandomArray(){
        ArrayList<Integer> array = new ArrayList<>();
        while(array.size() < 1000){
            int num = (int) (Math.random()*100000 + 1);
            if(!array.contains(num)){
                array.add(num);
            }
        }
        Integer[] a = new Integer[1000];
        a = array.toArray(a);
        return a;
    }

    public static long fillBinarySearchTree(BinarySearchTree<Integer> binarySearchTree, Integer[] array){
        long startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                try {
                    binarySearchTree.insert(array[i]);
                } catch (RepeatedElementException e){
                    System.out.println(e.getMessage());
                }
            }
        return (System.currentTimeMillis() - startTime);
    }

    public static long fillAVLTree(AVLTree<Integer> avlTree, Integer[] array){
        long startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                try {
                    avlTree.insert(array[i]);
                } catch (RepeatedElementException e){
                    System.out.println(e.getMessage());
                }
            }
        return System.currentTimeMillis() - startTime;
    }

    public static long fillRedBlackTree(RedBlackTree<Integer> redBlackTree, Integer[] array){
        long startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                redBlackTree.insert(array[i]);
            }
        return System.currentTimeMillis() - startTime;
    }
    public static void searchTriesTable(BinarySearchTree<Integer> bst, AVLTree<Integer> avl, RedBlackTree<Integer> rbt, Integer[] nums){ //item d)
        System.out.println("Searching Number       " + "BST" + "  AVL  " + "RBT  " );
        int bstTotal = 0;
        int avlTotal = 0;
        int rbtTotal = 0;
        for (int i = 0; i < 10; i++) {
            int searchingIndex = i*100;
            try {
                int bstComp = bst.searchCountingComparisons(nums[searchingIndex]);
                bstTotal+=bstComp;
                int avlComp = avl.searchCountingComparisons(nums[searchingIndex]);
                avlTotal+=avlComp;
                int rbtComp = rbt.searchCountingComparisons(nums[searchingIndex]);
                rbtTotal+=rbtComp;
                System.out.println(nums[searchingIndex] + "                  " + bstComp + "    " + avlComp + "    "+ rbtComp);
            } catch (ElementNotFoundInTree elementNotFoundInTree) {
                System.out.println(elementNotFoundInTree.getMessage());
            }
        }
        System.out.println("Mean                   " + (double)bstTotal/10 + "    " + (double)avlTotal/10 + "    " + (double)rbtTotal/10);
    }
    public static void statistics(){ //Item e)
        //Creating variables to sum the results from 10 tries.
        long bstTime = 0;
        long avlTime= 0;
        long rbtTime= 0;
        double bstHeight= 0;
        double avlHeight= 0;
        double rbtHeight= 0;
        double bstTries= 0;
        double avlTries= 0;
        double rbtTries= 0;
        for (int i = 0; i < 10; i++) {
            Integer[] elements = generateRandomArray();
            BinarySearchTree<Integer> bst = new BinarySearchTree<>();
            AVLTree<Integer> avl = new AVLTree<>();
            RedBlackTree<Integer> rbt = new RedBlackTree<>();
            bstTime+=fillBinarySearchTree(bst,elements);
            avlTime+=fillAVLTree(avl,elements);
            rbtTime+=fillRedBlackTree(rbt,elements);

            //Calcular alturas y sumarlas a las variables
            for (int j = 0; i < 10; i++) {
                int searchingIndex = i*100;
                try {
                    int bstComp = bst.searchCountingComparisons(elements[searchingIndex]);
                    bstHeight = bstHeight + bst.treeHeight();
                    bstTries+=bstComp;
                    int avlComp = avl.searchCountingComparisons(elements[searchingIndex]);
                    avlHeight = avlHeight + avl.treeHeight();
                    avlTries+=avlComp;
                    int rbtComp = rbt.searchCountingComparisons(elements[searchingIndex]);
                    rbtHeight = rbtHeight + rbt.treeHeight();
                    rbtTries+=rbtComp;
                } catch (ElementNotFoundInTree elementNotFoundInTree) {
                    System.out.println(elementNotFoundInTree.getMessage());
                }
            }
        }

        System.out.println("BINARY SEARCH TREE MEANS- " + "Construction time: " + bstTime/10 + " Height: " + bstHeight/10 + " Search tries: " + bstTries/10);
        System.out.println("AVL TREE MEANS- " + "Construction time: " + avlTime/10 + " Height: " + avlHeight/10 + " Search tries: " + avlTries/10);
        System.out.println("RED BLACK TREE MEANS- " + "Construction time: " + rbtTime/10 + " Height: " + rbtHeight/10 + " Search tries: " + rbtTries/10);



    }


}

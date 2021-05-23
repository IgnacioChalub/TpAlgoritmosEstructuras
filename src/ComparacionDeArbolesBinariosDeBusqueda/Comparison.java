package ComparacionDeArbolesBinariosDeBusqueda;

import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.ElementNotFoundInTree;
import ComparacionDeArbolesBinariosDeBusqueda.Exceptions.RepeatedElementException;

public class Comparison {
    public static void main(String[] args) {
        int[] intArray = generateRandomArray();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        AVLTree<Integer> avlTree = new AVLTree<>();
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();

        //Construccion de los tres arboles
        double binarySearchTreeConstructionTime = fillBinarySearchTree(binarySearchTree,intArray);
        double avlTreeConstructionTime = fillAVLTree(avlTree,intArray);
        double redBlackTreeConstructionTime = fillRedBlackTree(redBlackTree,intArray);
        System.out.println("hola");
        System.out.println("Binary search tree construction time: "+ binarySearchTreeConstructionTime +"mili seconds");
        System.out.println("AVL tree construction time: "+ avlTreeConstructionTime +"mili seconds");
        System.out.println("Red black tree construction time: "+ redBlackTreeConstructionTime +"mili seconds");

        int comparisons = 0;
        for (int i = 0; i < 10; i++) {
            int randomInt = (int) Math.random()*1000;
            try {
                comparisons += binarySearchTree.searchCountingComparisons(intArray[i*100]);
            } catch (ElementNotFoundInTree elementNotFoundInTree) {
                elementNotFoundInTree.printStackTrace();
            }
        }

        System.out.println(comparisons);
    }

    public static int[] generateRandomArray(){
        int[] newArray = new int[1000];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = (int) Math.random()*100000;
        }
        return newArray;
    }

    public static double fillBinarySearchTree(BinarySearchTree<Integer> binarySearchTree, int[] array){
        long startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                try {
                    binarySearchTree.insert(array[i]);
                } catch (RepeatedElementException e){
                    e.printStackTrace();
                }
            }
        return (System.currentTimeMillis() - startTime);
    }

    public static double fillAVLTree(AVLTree<Integer> avlTree, int[] array){
        double startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                try {
                    avlTree.insert(array[i]);
                } catch (RepeatedElementException e){
                    e.printStackTrace();
                }
            }
        return System.currentTimeMillis() - startTime;
    }

    public static double fillRedBlackTree(RedBlackTree<Integer> redBlackTree, int[] array){
        long startTime = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                redBlackTree.insert(array[i]);
            }
        return System.currentTimeMillis() - startTime;
    }


}
